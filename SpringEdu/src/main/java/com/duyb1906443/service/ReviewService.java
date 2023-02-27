package com.duyb1906443.service;

import java.util.List;

import com.duyb1906443.dto.ReviewDTO;

public interface ReviewService {
	
	List<ReviewDTO> findAllByClassId(Long classId);
	float getAvgReviewRatingByClassId(Long classId);
	
}
