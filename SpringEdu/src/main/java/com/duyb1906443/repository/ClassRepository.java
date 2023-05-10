package com.duyb1906443.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.duyb1906443.entity.ClassEntity;
import com.duyb1906443.entity.ClassScheduleEntity;

public interface ClassRepository extends JpaRepository<ClassEntity, Long> {
	
	
}
