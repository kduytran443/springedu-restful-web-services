package com.duyb1906443.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.duyb1906443.dto.TextDataDTO;
import com.duyb1906443.entity.TextDataEntity;

@Component
public class TextDataConverter
		implements IConverterToEntity<TextDataEntity, TextDataDTO>, IConverterToDTO<TextDataEntity, TextDataDTO> {

	@Override
	public TextDataEntity toEntity(TextDataDTO dto) {
		TextDataEntity entity = new TextDataEntity();
		if (dto.getId() != null)
			entity.setId(dto.getId());
		entity.setContent(dto.getContent());
		return entity;
	}

	public TextDataEntity toEntity(TextDataDTO dto, TextDataEntity entity) {
		if (dto.getId() != null)
			entity.setId(dto.getId());
		entity.setContent(dto.getContent());
		return entity;
	}

	@Override
	public List<TextDataEntity> toEntityList(List<TextDataDTO> dtos) {
		List<TextDataEntity> entities = new ArrayList<>();

		for (TextDataDTO textDataDTO : dtos) {
			entities.add(toEntity(textDataDTO));
		}

		return entities;
	}

	@Override
	public TextDataDTO toDTO(TextDataEntity entity) {
		TextDataDTO dto = new TextDataDTO();
		dto.setId(entity.getId());
		dto.setContent(entity.getContent());
		return dto;
	}

	@Override
	public List<TextDataDTO> toDTOList(List<TextDataEntity> entities) {
		List<TextDataDTO> dtos = new ArrayList<>();

		for (TextDataEntity textDataEntity : entities) {
			dtos.add(toDTO(textDataEntity));
		}

		return dtos;
	}

}
