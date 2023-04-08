package com.duyb1906443.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.duyb1906443.entity.ClassEntity;
import com.duyb1906443.entity.TopicEntity;

public interface TopicRepository extends JpaRepository<TopicEntity, Long> {
	
	TopicEntity findOneByOrdinalNumberAndClassEntity(int ordinalNumber, ClassEntity classEntity);
	List<TopicEntity> findAllByClassEntity(ClassEntity classEntity);
	
}
