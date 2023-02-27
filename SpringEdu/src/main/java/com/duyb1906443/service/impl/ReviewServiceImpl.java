package com.duyb1906443.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duyb1906443.converter.ReviewConverter;
import com.duyb1906443.dto.ReviewDTO;
import com.duyb1906443.entity.ClassEntity;
import com.duyb1906443.entity.ReviewEntity;
import com.duyb1906443.repository.ClassRepository;
import com.duyb1906443.repository.ReviewRepository;
import com.duyb1906443.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewRepository reviewRepository;
	
	@Autowired
	private ClassRepository classRepository;
	
	@Autowired
	private ReviewConverter reviewConverter;
	
	@Override
	public List<ReviewDTO> findAllByClassId(Long classId) {
		ClassEntity classEntity = classRepository.findOne(classId);
		
		List<ReviewEntity> reviewEntities = reviewRepository.findAllByClassEntity(classEntity);
		List<ReviewDTO> reviewDTOs = new ArrayList<ReviewDTO>();
		
		for (ReviewEntity reviewEntity : reviewEntities) {
			ReviewDTO reviewDTO = reviewConverter.toDTO(reviewEntity);
			reviewDTO.setUserAvatar(reviewEntity.getUser().getAvatar());
			reviewDTO.setUserName(reviewEntity.getUser().getUsername());
			reviewDTOs.add(reviewDTO);
		}
		
		return reviewDTOs;
	}

	@Override
	public float getAvgReviewRatingByClassId(Long classId) {
		return reviewRepository.getAvgReviewRatingByClassId(classId);
	}
	
}
