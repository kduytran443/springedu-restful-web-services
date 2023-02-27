package com.duyb1906443.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.duyb1906443.dto.WeeklyClassScheduleDTO;
import com.duyb1906443.entity.WeeklyClassScheduleEntity;

@Component
public class WeeklyClassScheduleConverter
		implements IConverterToEntity<WeeklyClassScheduleEntity, WeeklyClassScheduleDTO>,
		IConverterToDTO<WeeklyClassScheduleEntity, WeeklyClassScheduleDTO> {

	@Override
	public WeeklyClassScheduleDTO toDTO(WeeklyClassScheduleEntity entity) {
		WeeklyClassScheduleDTO dto = new WeeklyClassScheduleDTO();
		if(entity.getId() != null) dto.setId(entity.getId());
		dto.setCode(entity.getCode());
		dto.setName(entity.getName());
		return dto;
	}

	@Override
	public List<WeeklyClassScheduleDTO> toDTOList(List<WeeklyClassScheduleEntity> entities) {
		List<WeeklyClassScheduleDTO> dtos = new ArrayList<WeeklyClassScheduleDTO>();
		for (WeeklyClassScheduleEntity weeklyClassScheduleEntity : entities) {
			dtos.add(toDTO(weeklyClassScheduleEntity));
		}
		return dtos;
	}

	@Override
	public WeeklyClassScheduleEntity toEntity(WeeklyClassScheduleDTO dto) {
		WeeklyClassScheduleEntity entity = new WeeklyClassScheduleEntity();
		if(dto.getId() != null) entity.setId(dto.getId());
		entity.setCode(dto.getCode());
		entity.setName(dto.getName());
		return entity;
	}

	@Override
	public List<WeeklyClassScheduleEntity> toEntityList(List<WeeklyClassScheduleDTO> dtos) {
		List<WeeklyClassScheduleEntity> entities = new ArrayList<WeeklyClassScheduleEntity>();
		for (WeeklyClassScheduleDTO weeklyClassScheduleDTO : dtos) {
			entities.add(toEntity(weeklyClassScheduleDTO));
		}
		return entities;
	}

}
