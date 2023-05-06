package com.duyb1906443.service;

import java.util.List;

import com.duyb1906443.dto.ClassReviewCardDTO;

public interface ClassReviewCardService {
	
	List<ClassReviewCardDTO> findAll();
	List<ClassReviewCardDTO> search(String value, String categoryCode, Float fee, Float rating);
	List<ClassReviewCardDTO> findAllByUser(Long userId);
	List<ClassReviewCardDTO> findAllByCategoryCode(String categoryCode);
	Long getMember(Long classId);
	
}
