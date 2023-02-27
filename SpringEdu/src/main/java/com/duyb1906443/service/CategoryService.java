package com.duyb1906443.service;

import java.util.List;

import com.duyb1906443.dto.CategoryDTO;

public interface CategoryService {
	CategoryDTO save(CategoryDTO dto);
	List<CategoryDTO> findAll();
	void delete(Long id);
	CategoryDTO findOneByCode(String code);
}
