package com.duyb1906443.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duyb1906443.converter.CatogoryConverter;
import com.duyb1906443.dto.CategoryDTO;
import com.duyb1906443.entity.CategoryEntity;
import com.duyb1906443.repository.CategoryRepository;
import com.duyb1906443.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private CatogoryConverter categoryConverter;
	
	@Override
	public CategoryDTO save(CategoryDTO dto) {
		CategoryEntity categoryEntity = new CategoryEntity();
		if(dto.getId() != null) {
			CategoryEntity oldEntity = categoryRepository.findOne(dto.getId());
			categoryEntity = categoryConverter.toEntity(dto, oldEntity); 
		}
		else {
			categoryEntity = categoryConverter.toEntity(dto);
		}
		
		return categoryConverter.toDTO(categoryRepository.save(categoryEntity));
	}

	@Override
	public List<CategoryDTO> findAll() {
		return categoryConverter.toDTOList(categoryRepository.findAll());
	}

	@Override
	public void delete(Long id) {
		categoryRepository.delete(id);
	}

	@Override
	public CategoryDTO findOneByCode(String code) {
		return categoryConverter.toDTO(categoryRepository.findOneByCode(code));
	}
	
}
