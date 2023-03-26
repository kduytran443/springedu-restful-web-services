package com.duyb1906443.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.duyb1906443.entity.UserEntity;
import com.duyb1906443.entity.UserNotificationEntity;

public interface UserNotificationRepository extends JpaRepository<UserNotificationEntity, Long> {
	
	List<UserNotificationEntity> findAllByUserAndReaded(UserEntity user, Integer readed);
	
}
