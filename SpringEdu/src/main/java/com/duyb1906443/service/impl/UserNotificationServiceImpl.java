package com.duyb1906443.service.impl;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duyb1906443.converter.NotificationConverter;
import com.duyb1906443.dto.NotificationDTO;
import com.duyb1906443.entity.ClassMemberEntity;
import com.duyb1906443.entity.NotificationEntity;
import com.duyb1906443.entity.UserEntity;
import com.duyb1906443.entity.UserNotificationEntity;
import com.duyb1906443.repository.NotificationRepository;
import com.duyb1906443.repository.UserNotificationRepository;
import com.duyb1906443.repository.UserRepository;
import com.duyb1906443.service.UserNotificationService;

@Service
public class UserNotificationServiceImpl implements UserNotificationService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserNotificationRepository userNotificationRepository;

	@Autowired
	private NotificationRepository notificationRepository;

	@Autowired
	private NotificationConverter notificationConverter;

	@Override
	public void sendNotification(List<Long> userIds, NotificationDTO notificationDTO) {

		UserEntity sender = userRepository.findOne(notificationDTO.getSenderId());
		NotificationEntity notificationEntity = notificationConverter.toEntity(notificationDTO);

		Date date = new Date();
		notificationEntity.setTime(new Timestamp(date.getTime()));
		notificationEntity.setUser(sender);
		notificationEntity = notificationRepository.save(notificationEntity);

		if (notificationEntity != null) {
			for (Long userId : userIds) {
				UserEntity receiver = userRepository.findOne(userId);

				UserNotificationEntity userNotificationEntity = new UserNotificationEntity();
				userNotificationEntity.setNotification(notificationEntity);
				userNotificationEntity.setReaded(0);
				userNotificationEntity.setUser(receiver);

				userNotificationEntity = userNotificationRepository.save(userNotificationEntity);
			}
		}

	}

	private NotificationDTO miniConvert(UserNotificationEntity entity) {
		NotificationDTO dto = new NotificationDTO();
		dto.setContent(entity.getNotification().getContent());
		dto.setSenderFullname(entity.getNotification().getUser().getFullname());
		dto.setId(entity.getId());
		dto.setRedirectUrl(entity.getNotification().getRedirectUrl());
		dto.setSenderAvatar(entity.getNotification().getUser().getAvatar());
		dto.setSenderUsername(entity.getNotification().getUser().getUsername());
		dto.setTime(entity.getNotification().getTime());
		dto.setRead(entity.getReaded());

		return dto;
	}

	@Override
	public List<NotificationDTO> findAllByUserId(Long id) {

		UserEntity userEntity = userRepository.findOne(id);

		List<UserNotificationEntity> userNotificationEntities = userEntity.getUserNotifications();
		List<NotificationDTO> dtos = userNotificationEntities.stream().map(entity -> miniConvert(entity))
				.collect(Collectors.toList());
		Collections.sort(dtos, new Comparator<NotificationDTO>() {
			@Override
			public int compare(NotificationDTO o1, NotificationDTO o2) {

				return o1.getId() > o2.getId() ? -1 : 1;
				
			}
		});
		return dtos;
	}

	@Override
	public void readAll(Long userId) {
		UserEntity userEntity = userRepository.findOne(userId);

		// Tìm những thông báo mà user chưa đọc (read=0)
		List<UserNotificationEntity> userNotificationEntities = userNotificationRepository
				.findAllByUserAndReaded(userEntity, 0);

		for (UserNotificationEntity userNotificationEntity : userNotificationEntities) {
			userNotificationEntity.setReaded(1);
			userNotificationRepository.save(userNotificationEntity);
		}
	}

	@Override
	public void sendNotificationForMembers(List<ClassMemberEntity> member, NotificationDTO notificationDTO) {
		List<Long> ids = member.stream().map(entity -> entity.getUser().getId()).collect(Collectors.toList());
		sendNotification(ids, notificationDTO);
	}

	@Override
	public void sendNotification(NotificationDTO notificationDTO) {
		sendNotification(notificationDTO.getReceiverIds(), notificationDTO);
	}

}
