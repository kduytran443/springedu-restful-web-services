package com.duyb1906443.service;

import java.util.List;

import com.duyb1906443.dto.CategoryDTO;

public interface CategoryService {
	CategoryDTO save(CategoryDTO dto);
	List<CategoryDTO> findAllWithGoodStatus();
	List<CategoryDTO> findAll();
	void delete(Long id);
	void unblock(Long id);
	CategoryDTO findOneByCode(String code);
	CategoryDTO findOne(Long id);
	Integer getMemberCount(String code);
}
