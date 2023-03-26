package com.duyb1906443.service;

import java.util.List;

import com.duyb1906443.dto.NotificationDTO;
import com.duyb1906443.entity.ClassMemberEntity;

public interface UserNotificationService {

	void sendNotificationForMembers(List<ClassMemberEntity> member, NotificationDTO notificationDTO);
	void sendNotification(List<Long> ids, NotificationDTO notificationDTO);
	void sendNotification(NotificationDTO notificationDTO);
	List<NotificationDTO> findAllByUserId(Long id);
	void readAll(Long userId);
	
}
