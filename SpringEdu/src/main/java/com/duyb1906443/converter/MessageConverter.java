package com.duyb1906443.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.duyb1906443.dto.MessageDTO;
import com.duyb1906443.entity.MessageEntity;

@Component
public class MessageConverter implements IConverterToDTO<MessageEntity, MessageDTO>, IConverterToEntity<MessageEntity, MessageDTO> {
	
	@Autowired
	private UserConverter userConverter;
	
	@Override
	public MessageEntity toEntity(MessageDTO dto) {
		MessageEntity entity = new MessageEntity();
		
		entity.setContent(dto.getContent());
		entity.setType(dto.getType());
		
		return entity;
	}

	@Override
	public List<MessageEntity> toEntityList(List<MessageDTO> dtos) {
		return dtos.stream().map(item -> toEntity(item)).collect(Collectors.toList());
	}

	@Override
	public MessageDTO toDTO(MessageEntity entity) {
		
		MessageDTO dto = new MessageDTO();
		dto.setClassId(entity.getClassEntity().getId());
		dto.setContent(entity.getContent());
		dto.setDate(entity.getDate());
		dto.setId(entity.getId());
		dto.setStatus(entity.getStatus());
		dto.setType(entity.getType());
		
		if(entity.getUser() != null) {
			dto.setUser(userConverter.toDTO(entity.getUser()));			
		}
		
		return dto;
	}

	@Override
	public List<MessageDTO> toDTOList(List<MessageEntity> entities) {
		return entities.stream().map(item -> toDTO(item)).collect(Collectors.toList());
	}

}
