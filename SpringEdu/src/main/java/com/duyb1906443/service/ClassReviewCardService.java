package com.duyb1906443.service;

import java.util.List;

import com.duyb1906443.dto.ClassReviewCardDTO;

public interface ClassReviewCardService {
	
	List<ClassReviewCardDTO> findAll();
	List<ClassReviewCardDTO> findAllByUser(Long userId);
	List<ClassReviewCardDTO> findAllByCategoryCode(String categoryCode);
	
}
