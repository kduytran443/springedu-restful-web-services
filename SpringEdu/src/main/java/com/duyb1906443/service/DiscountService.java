package com.duyb1906443.service;

import java.util.List;

import com.duyb1906443.dto.DiscountDTO;

public interface DiscountService {
	
	List<DiscountDTO> getAllByClassId(Long classId);
	DiscountDTO findOneById(Long id);
	DiscountDTO save(DiscountDTO discountDTO);
	void delete(Long disconutId);
	
}
