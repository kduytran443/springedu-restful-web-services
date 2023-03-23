package com.duyb1906443.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.duyb1906443.entity.ClassExcerciseEntity;
import com.duyb1906443.entity.SubmittedExerciseEntity;
import com.duyb1906443.entity.UserEntity;

public interface SubmittedExerciseRepository extends JpaRepository<SubmittedExerciseEntity, Long> {
	
	List<SubmittedExerciseEntity> findAllByUserAndClassExcercise(UserEntity user, ClassExcerciseEntity classExcercise);
	
}
