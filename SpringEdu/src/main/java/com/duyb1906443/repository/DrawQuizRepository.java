package com.duyb1906443.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.duyb1906443.entity.DrawQuizEntity;
import com.duyb1906443.entity.SubmittedExerciseEntity;

public interface DrawQuizRepository extends JpaRepository<DrawQuizEntity, Long> {
	
	List<DrawQuizEntity> findAllBySubmittedExercise(SubmittedExerciseEntity SubmittedExercise);
	
}
