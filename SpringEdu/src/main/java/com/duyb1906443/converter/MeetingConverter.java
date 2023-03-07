package com.duyb1906443.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.duyb1906443.dto.MeetingDTO;
import com.duyb1906443.entity.MeetingEntity;

@Component
public class MeetingConverter implements IConverterToDTO<MeetingEntity, MeetingDTO> {

	@Override
	public MeetingDTO toDTO(MeetingEntity entity) {
		MeetingDTO meetingDTO = new MeetingDTO();
		meetingDTO.setId(entity.getId());
		meetingDTO.setUrl(entity.getUrl());
		return meetingDTO;
	}

	@Override
	public List<MeetingDTO> toDTOList(List<MeetingEntity> entities) {
		List<MeetingDTO> dtos = new ArrayList<>();
		for (MeetingEntity meetingEntity : entities) {
			dtos.add(toDTO(meetingEntity));
		}

		return dtos;
	}

}
