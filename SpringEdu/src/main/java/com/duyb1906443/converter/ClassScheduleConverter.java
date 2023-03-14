package com.duyb1906443.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.duyb1906443.dto.ClassScheduleDTO;
import com.duyb1906443.dto.DateDTO;
import com.duyb1906443.dto.WeeklyClassScheduleDTO;
import com.duyb1906443.entity.ClassScheduleEntity;

@Component
public class ClassScheduleConverter implements IConverterToDTO<ClassScheduleEntity, ClassScheduleDTO> {

	@Override
	public ClassScheduleDTO toDTO(ClassScheduleEntity entity) {
		ClassScheduleDTO dto = new ClassScheduleDTO();
		if (entity.getId() != null)
			dto.setId(entity.getId());
		dto.setDateCode(entity.getWeeklyClassSchedule().getCode());
		dto.setDateName(entity.getWeeklyClassSchedule().getName());
		dto.setEndHours(entity.getEndHours());
		dto.setEndMinutes(entity.getEndMinutes());
		dto.setStartHours(entity.getStartHours());
		dto.setStartMinutes(entity.getStartMinutes());
		return dto;
	}

	@Override
	public List<ClassScheduleDTO> toDTOList(List<ClassScheduleEntity> entities) {
		return entities.stream().map(entity -> toDTO(entity)).collect(Collectors.toList());
	}

}
