package com.duyb1906443.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.duyb1906443.dto.NoteFolderDTO;
import com.duyb1906443.entity.NoteFolderEntity;

@Component
public class NoteFolderConverter implements IConverterToDTO<NoteFolderEntity, NoteFolderDTO>, IConverterToEntity<NoteFolderEntity, NoteFolderDTO> {

	@Override
	public NoteFolderEntity toEntity(NoteFolderDTO dto) {
		// TODO Auto-generated method stub
		NoteFolderEntity entity = new NoteFolderEntity();
		
		if(dto.getCreatedDate() != null) {
			entity.setCreatedDate(dto.getCreatedDate());			
		}
		if(dto.getName() != null) {
			entity.setName(dto.getName());			
		}
		if(dto.getStatus() != null) {
			entity.setStatus(dto.getStatus());			
		}
		
		return entity;
	}
	public NoteFolderEntity toEntity(NoteFolderDTO dto, NoteFolderEntity entity) {
		
		if(dto.getCreatedDate() != null) {
			entity.setCreatedDate(dto.getCreatedDate());			
		}
		if(dto.getId() != null) {
			entity.setId(dto.getId());			
		}
		if(dto.getName() != null) {
			entity.setName(dto.getName());			
		}
		if(dto.getStatus() != null) {
			entity.setStatus(dto.getStatus());			
		}
		
		return entity;
	}

	@Override
	public List<NoteFolderEntity> toEntityList(List<NoteFolderDTO> dtos) {
		return dtos.stream().map(item -> toEntity(item)).collect(Collectors.toList());
	}

	@Override
	public NoteFolderDTO toDTO(NoteFolderEntity entity) {
		NoteFolderDTO dto = new NoteFolderDTO();
		dto.setCreatedDate(entity.getCreatedDate());
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setStatus(entity.getStatus());
		dto.setUserId(entity.getUser().getId());
		return dto;
	}

	@Override
	public List<NoteFolderDTO> toDTOList(List<NoteFolderEntity> entities) {
		return entities.stream().map(item -> toDTO(item)).collect(Collectors.toList());
	}

}
