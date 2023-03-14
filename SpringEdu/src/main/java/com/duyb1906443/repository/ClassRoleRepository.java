package com.duyb1906443.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.duyb1906443.entity.ClassRoleEntity;

public interface ClassRoleRepository extends JpaRepository<ClassRoleEntity, Long> {
	
	ClassRoleEntity findOneByCode(String code);
	
}
