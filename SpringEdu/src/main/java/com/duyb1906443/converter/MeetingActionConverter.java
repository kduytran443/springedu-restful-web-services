package com.duyb1906443.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.duyb1906443.dto.MeetingActionDTO;
import com.duyb1906443.entity.MeetingActionEntity;

@Component
public class MeetingActionConverter implements IConverterToDTO<MeetingActionEntity, MeetingActionDTO>, IConverterToEntity<MeetingActionEntity, MeetingActionDTO> {
	
	@Override
	public MeetingActionEntity toEntity(MeetingActionDTO dto) {
		MeetingActionEntity entity = new MeetingActionEntity();
		
		if(dto.getAction() != null) {
			entity.setAction(dto.getAction());			
		}
		if(dto.getId() != null) {
			entity.setId(dto.getId());			
		}
		if(dto.getTime() != null) {
			entity.setTime(dto.getTime());			
		}
		
		return entity;
	}

	@Override
	public List<MeetingActionEntity> toEntityList(List<MeetingActionDTO> dtos) {
		return dtos.stream().map(item -> toEntity(item)).collect(Collectors.toList());
	}

	@Override
	public MeetingActionDTO toDTO(MeetingActionEntity entity) {
		MeetingActionDTO dto = new MeetingActionDTO();
		
		dto.setAction(entity.getAction());
		dto.setClassId(entity.getMeeting().getId());
		dto.setFullname(entity.getUser().getFullname());
		dto.setId(entity.getId());
		dto.setMeetingId(entity.getMeeting().getId());
		dto.setTime(entity.getTime());
		dto.setUserAvatar(entity.getUser().getAvatar());
		dto.setUserId(entity.getUser().getId());
		dto.setUsername(entity.getUser().getUsername());
		
		return dto;
	}

	@Override
	public List<MeetingActionDTO> toDTOList(List<MeetingActionEntity> entities) {
		return entities.stream().map(item -> toDTO(item)).collect(Collectors.toList());
	}
	
}
