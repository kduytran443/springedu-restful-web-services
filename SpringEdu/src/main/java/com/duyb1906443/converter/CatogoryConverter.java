package com.duyb1906443.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.duyb1906443.dto.CategoryDTO;
import com.duyb1906443.entity.CategoryEntity;

@Component
public class CatogoryConverter
		implements IConverterToDTO<CategoryEntity, CategoryDTO>, IConverterToEntity<CategoryEntity, CategoryDTO> {

	@Override
	public CategoryEntity toEntity(CategoryDTO dto) {
		CategoryEntity entity = new CategoryEntity();
		entity.setCode(dto.getCode());
		entity.setDescription(dto.getDescription());
		entity.setImage(dto.getImage());
		entity.setName(dto.getName());
		entity.setIcon(dto.getIcon());
		return entity;
	}

	public CategoryEntity toEntity(CategoryDTO dto, CategoryEntity entity) {
		entity.setCode(dto.getCode());
		entity.setDescription(dto.getDescription());
		entity.setImage(dto.getImage());
		entity.setName(dto.getName());
		entity.setIcon(dto.getIcon());
		return entity;
	}

	@Override
	public CategoryDTO toDTO(CategoryEntity entity) {
		CategoryDTO dto = new CategoryDTO();
		if (entity.getId() != null) {
			dto.setId(entity.getId());
		}
		dto.setCode(entity.getCode());
		dto.setDescription(entity.getDescription());
		dto.setImage(entity.getImage());
		dto.setName(entity.getName());
		dto.setIcon(entity.getIcon());
		return dto;
	}

	@Override
	public List<CategoryEntity> toEntityList(List<CategoryDTO> dtos) {
		List<CategoryEntity> entities = new ArrayList<CategoryEntity>();
		for (CategoryDTO dto : dtos) {
			entities.add(toEntity(dto));
		}
		return entities;
	}

	@Override
	public List<CategoryDTO> toDTOList(List<CategoryEntity> entities) {
		List<CategoryDTO> dtos = new ArrayList<CategoryDTO>();
		for (CategoryEntity entity : entities) {
			dtos.add(toDTO(entity));
		}
		return dtos;
	}

}
