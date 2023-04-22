package com.duyb1906443.service.impl;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.duyb1906443.converter.MessageConverter;
import com.duyb1906443.dto.MessageDTO;
import com.duyb1906443.entity.ClassEntity;
import com.duyb1906443.entity.CustomUserDetails;
import com.duyb1906443.entity.MessageEntity;
import com.duyb1906443.entity.UserEntity;
import com.duyb1906443.repository.ClassMemberRepository;
import com.duyb1906443.repository.ClassRepository;
import com.duyb1906443.repository.MessageRepository;
import com.duyb1906443.repository.UserRepository;
import com.duyb1906443.service.MessageService;

@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	private ClassRepository classRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private MessageConverter messageConverter;

	@Autowired
	private MessageRepository messageRepository;

	@Autowired
	private ClassMemberRepository classMemberRepository;

	@Override
	public List<MessageDTO> findAllByClassId(Long classId) {
		ClassEntity classEntity = classRepository.findOne(classId);

		List<MessageEntity> messageEntities = classEntity.getMessages().stream().map(item -> {
			if (item.getStatus() != 1) {
				item.setContent("");
			}
			return item;
		}).collect(Collectors.toList());
		
		Collections.sort(messageEntities, new Comparator<MessageEntity>() {

			@Override
			public int compare(MessageEntity o1, MessageEntity o2) {
				if(o2.getId() > o1.getId()) {
					return 1;
				}
				else {
					return -1;
				}
			}
		});

		return messageConverter.toDTOList(messageEntities);
	}

	@Override
	public MessageDTO findOneById(Long id) {
		MessageEntity entity = messageRepository.findOne(id);
		return messageConverter.toDTO(entity);
	}

	@Override
	public MessageDTO save(MessageDTO messageDTO) {
		ClassEntity classEntity = classRepository.findOne(messageDTO.getClassId());
		Long userId = ((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal())
				.getUser().getId();
		UserEntity userEntity = userRepository.findOne(userId);

		MessageEntity messageEntity = messageConverter.toEntity(messageDTO);

		Date date = new Date();
		messageEntity.setClassEntity(classEntity);
		messageEntity.setDate(new Timestamp(date.getTime()));
		messageEntity.setStatus(1);
		messageEntity.setUser(userEntity);
		
		messageEntity.setContent(messageDTO.getContent());
		
		messageEntity = messageRepository.save(messageEntity);
		
		return messageConverter.toDTO(messageEntity);
	}

	@Override
	public MessageDTO delete(Long id) {
		MessageEntity entity = messageRepository.findOne(id);
		entity.setStatus(0);
		entity = messageRepository.save(entity);
		return messageConverter.toDTO(entity);
	}

	@Override
	public Integer getCountUnreadMessageByUserId() {
		Long userId = ((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal())
				.getUser().getId();
		UserEntity userEntity = userRepository.findOne(userId);
		List<ClassEntity> classEntities = classMemberRepository.findAllByUser(userEntity).stream()
				.filter(item -> item.getClassAccepted() == 1 && item.getMemberAccepted() == 1)
				.map(item -> item.getClassEntity()).collect(Collectors.toList());
		
		//List<MessageEntity> messageEntities = classEntities.stream().map(item -> messageRepository.findTopByClassEntityByOrderByIdDesc(item)).collect(Collectors.toList());
		return 0;
	}

	@Override
	public Integer getCountUnreadMessageByUserIdAndClassId(Long classId) {
		Long userId = ((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal())
				.getUser().getId();

		ClassEntity classEntity = classRepository.findOne(classId);
		UserEntity userEntity = userRepository.findOne(userId);
		
		return 0;
	}

}
