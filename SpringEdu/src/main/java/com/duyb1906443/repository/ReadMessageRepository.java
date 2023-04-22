package com.duyb1906443.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.duyb1906443.entity.ClassEntity;
import com.duyb1906443.entity.MessageEntity;
import com.duyb1906443.entity.ReadMessageEntity;

public interface ReadMessageRepository extends JpaRepository<ReadMessageEntity, Long> {
	
}
