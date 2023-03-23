package com.duyb1906443.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.duyb1906443.dto.ConstructedResponseTestDTO;
import com.duyb1906443.entity.ConstructedResponseTestEntity;

@Component
public class ConstructedResponseTestConverter
		implements IConverterToDTO<ConstructedResponseTestEntity, ConstructedResponseTestDTO>,
		IConverterToEntity<ConstructedResponseTestEntity, ConstructedResponseTestDTO> {
	
	@Autowired
	private FileConverter fileConverter;
	
	@Override
	public ConstructedResponseTestEntity toEntity(ConstructedResponseTestDTO dto) {
		ConstructedResponseTestEntity entity = new ConstructedResponseTestEntity();
		entity.setContent(dto.getContent());
		entity.setName(dto.getName());
		entity.setMark(dto.getMark());
		return entity;
	}
	public ConstructedResponseTestEntity toEntity(ConstructedResponseTestDTO dto, ConstructedResponseTestEntity entity) {
		entity.setContent(dto.getContent());
		entity.setName(dto.getName());
		entity.setMark(dto.getMark());
		return entity;
	}

	@Override
	public List<ConstructedResponseTestEntity> toEntityList(List<ConstructedResponseTestDTO> dtos) {
		return dtos.stream().map(dto -> toEntity(dto)).collect(Collectors.toList());
	}

	@Override
	public ConstructedResponseTestDTO toDTO(ConstructedResponseTestEntity entity) {
		ConstructedResponseTestDTO dto = new ConstructedResponseTestDTO();
		if(entity.getClassExcercise() != null) dto.setClassExcerciseId(entity.getClassExcercise().getId());
		dto.setContent(entity.getContent());
		if(entity.getFiles() != null) {
			dto.setFiles(fileConverter.toDTOList(entity.getFiles()));
		}
		dto.setId(entity.getId());
		dto.setMark(entity.getMark());
		dto.setName(entity.getName());
		
		return dto;
	}

	@Override
	public List<ConstructedResponseTestDTO> toDTOList(List<ConstructedResponseTestEntity> entities) {
		return entities.stream().map(entity -> toDTO(entity)).collect(Collectors.toList());
	}

}
