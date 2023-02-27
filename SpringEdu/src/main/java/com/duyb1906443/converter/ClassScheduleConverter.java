package com.duyb1906443.converter;

import java.util.ArrayList;
import java.util.List;

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
		dto.setStartTime(entity.getStartTime());
		dto.setEndTime(entity.getEndTime());
		return dto;
	}

	@Override
	public List<ClassScheduleDTO> toDTOList(List<ClassScheduleEntity> entities) {
		List<ClassScheduleDTO> dtos = new ArrayList<ClassScheduleDTO>();

		for (ClassScheduleEntity classScheduleEntity : entities) {
			dtos.add(toDTO(classScheduleEntity));
		}

		return dtos;
	}

}
