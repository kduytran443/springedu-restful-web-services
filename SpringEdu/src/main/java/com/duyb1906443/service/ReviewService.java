package com.duyb1906443.service;

import java.util.List;

import com.duyb1906443.dto.ReviewDTO;

public interface ReviewService {
	
	List<ReviewDTO> findAllByClassId(Long classId);
	Float getAvgReviewRatingByClassId(Long classId);
	ReviewDTO createReview(ReviewDTO reviewDTO);
	ReviewDTO editReview(ReviewDTO reviewDTO);
	ReviewDTO getReviewByUserAndClass(ReviewDTO reviewDTO);
	
}
