package com.duyb1906443.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.duyb1906443.entity.ClassEntity;
import com.duyb1906443.entity.ClassMemberEntity;

public interface ClassMemberRepository extends JpaRepository<ClassMemberEntity, Long> {
	
	List<ClassMemberEntity> findAllByClassEntity(ClassEntity classEntity);
	
}
