package com.duyb1906443.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.duyb1906443.dto.FileDTO;
import com.duyb1906443.entity.FileEntity;

@Component
public class FileConverter implements IConverterToDTO<FileEntity, FileDTO>, IConverterToEntity<FileEntity, FileDTO> {

	@Override
	public FileDTO toDTO(FileEntity entity) {
		FileDTO dto = new FileDTO();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setSize(entity.getSize());
		dto.setType(entity.getType());
		dto.setData(entity.getData());
		return dto;
	}

	@Override
	public List<FileDTO> toDTOList(List<FileEntity> entities) {
		List<FileDTO> dtos = new ArrayList<>();
		
		for (FileEntity fileEntity : entities) {
			dtos.add(toDTO(fileEntity));
		}
		
		return dtos;
	}

	@Override
	public FileEntity toEntity(FileDTO dto) {
		FileEntity entity = new FileEntity();
		
		if(dto.getData() != null) entity.setData(dto.getData());
		if(dto.getId() != null) entity.setId(dto.getId());
		if(dto.getName() != null) entity.setName(dto.getName());
		if(dto.getType() != null) entity.setType(dto.getType());
		if(dto.getSize() != null) entity.setSize(dto.getSize());
		
		return entity;
	}
	
	public FileEntity toEntity(FileDTO dto, FileEntity entity) {
		entity.setData(dto.getData());
		if(dto.getId() != null) entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setType(dto.getType());
		entity.setSize(dto.getSize());
		
		return entity;
	}

	@Override
	public List<FileEntity> toEntityList(List<FileDTO> dtos) {
		List<FileEntity> entities = new ArrayList<>();
		for (FileDTO fileDTO : dtos) {
			entities.add(toEntity(fileDTO));
		}
		return entities;
	}
	
}
