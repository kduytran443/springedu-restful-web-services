package com.duyb1906443.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.duyb1906443.dto.NotificationDTO;
import com.duyb1906443.entity.NotificationEntity;

@Component
public class NotificationConverter implements IConverterToEntity<NotificationEntity, NotificationDTO>, IConverterToDTO<NotificationEntity, NotificationDTO> {

	@Override
	public NotificationEntity toEntity(NotificationDTO dto) {
		NotificationEntity entity = new NotificationEntity();
		
		entity.setContent(dto.getContent());
		if(dto.getId() != null) entity.setId(dto.getId());
		entity.setRedirectUrl(dto.getRedirectUrl());
		entity.setTime(dto.getTime());
		
		return entity;
	}

	public NotificationEntity toEntity(NotificationDTO dto, NotificationEntity entity) {		
		entity.setContent(dto.getContent());
		entity.setId(dto.getId());
		entity.setRedirectUrl(dto.getRedirectUrl());
		entity.setTime(dto.getTime());
		return entity;
	}

	@Override
	public List<NotificationEntity> toEntityList(List<NotificationDTO> dtos) {
		return dtos.stream().map(dto -> toEntity(dto)).collect(Collectors.toList());
	}

	@Override
	public NotificationDTO toDTO(NotificationEntity entity) {
		NotificationDTO dto = new NotificationDTO();
		
		dto.setContent(entity.getContent());
		dto.setSenderFullname(entity.getUser().getFullname());
		dto.setId(entity.getId());
		dto.setRedirectUrl(entity.getRedirectUrl());
		dto.setSenderAvatar(entity.getUser().getAvatar());
		dto.setSenderUsername(entity.getUser().getUsername());
		dto.setTime(entity.getTime());
		
		return dto;
	}

	@Override
	public List<NotificationDTO> toDTOList(List<NotificationEntity> entities) {
		return entities.stream().map(entity -> toDTO(entity)).collect(Collectors.toList());
	}

}
