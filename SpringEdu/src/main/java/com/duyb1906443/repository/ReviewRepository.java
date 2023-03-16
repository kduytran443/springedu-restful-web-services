package com.duyb1906443.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.duyb1906443.entity.ClassEntity;
import com.duyb1906443.entity.ReviewEntity;
import com.duyb1906443.entity.UserEntity;

public interface ReviewRepository extends JpaRepository<ReviewEntity, Long> {
	
	List<ReviewEntity> findAllByClassEntity(ClassEntity classEntity);
	
	@Query(value = "SELECT CAST(AVG(stars) AS float) FROM review WHERE class_id = ?1", nativeQuery = true)
	Float getAvgReviewRatingByClassId(Long classId);
	
	ReviewEntity findOneByClassEntityAndUser(ClassEntity classEntity, UserEntity user);
}
