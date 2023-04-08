package com.duyb1906443.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.duyb1906443.entity.ClassEntity;
import com.duyb1906443.entity.ClassExcerciseEntity;

public interface ClassExcerciseRepository extends JpaRepository<ClassExcerciseEntity, Long> {
	
	List<ClassExcerciseEntity> findByClassEntityOrderByIdDesc(ClassEntity classEntity);
	
}
