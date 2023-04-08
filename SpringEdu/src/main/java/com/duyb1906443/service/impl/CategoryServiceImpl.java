package com.duyb1906443.service.impl;

import java.util.List;
import java.util.stream.Collectors;

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
		if (dto.getId() != null) {
			CategoryEntity oldEntity = categoryRepository.findOne(dto.getId());
			categoryEntity = categoryConverter.toEntity(dto, oldEntity);
		} else {
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
		CategoryEntity categoryEntity = categoryRepository.findOne(id);
		categoryEntity.setStatus(0);
		categoryRepository.save(categoryEntity);
	}

	@Override
	public CategoryDTO findOneByCode(String code) {
		CategoryEntity entity = categoryRepository.findOneByCode(code);
		if (entity != null) {
			return categoryConverter.toDTO(entity);
		}
		return null;
	}

	@Override
	public void unblock(Long id) {
		CategoryEntity categoryEntity = categoryRepository.findOne(id);
		categoryEntity.setStatus(1);
		categoryRepository.save(categoryEntity);
	}

	@Override
	public List<CategoryDTO> findAllWithGoodStatus() {
		return categoryConverter.toDTOList(categoryRepository.findAll().stream().filter(item -> item.getStatus() == 1)
				.collect(Collectors.toList()));
	}

	@Override
	public CategoryDTO findOne(Long id) {
		CategoryEntity entity = categoryRepository.findOne(id);
		if (entity != null) {
			return categoryConverter.toDTO(entity);
		}
		return null;
	}

}
