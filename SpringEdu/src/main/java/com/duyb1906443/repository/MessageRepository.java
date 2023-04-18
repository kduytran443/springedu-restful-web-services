package com.duyb1906443.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.duyb1906443.entity.MessageEntity;

public interface MessageRepository extends JpaRepository<MessageEntity, Long> {
	
	List<MessageEntity> findAllByOrderByIdDesc();
	
}
