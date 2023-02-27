package com.duyb1906443.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.duyb1906443.dto.ClassScheduleWeeklyClassScheduleDTO;
import com.duyb1906443.entity.ClassScheduleWeeklyClassScheduleEntity;

@Component
public class ClassScheduleWeeklyClassScheduleConverter
		implements IConverterToDTO<ClassScheduleWeeklyClassScheduleEntity, ClassScheduleWeeklyClassScheduleDTO> {
	
	@Autowired
	private ClassScheduleConverter classScheduleConverter;

	@Autowired
	private WeeklyClassScheduleConverter weeklyClassScheduleConverter;
	
	@Override
	public ClassScheduleWeeklyClassScheduleDTO toDTO(ClassScheduleWeeklyClassScheduleEntity entity) {
		ClassScheduleWeeklyClassScheduleDTO dto = new ClassScheduleWeeklyClassScheduleDTO();
		dto.setClassSchedule(classScheduleConverter.toDTO(entity.getClassSchedule()));
		dto.setWeeklyClassSchedule(weeklyClassScheduleConverter.toDTO(entity.getWeeklyClassSchedule()));
		dto.setStartHours(entity.getStartHours());
		dto.setStartMinutes(entity.getStartMinutes());
		dto.setEndHours(entity.getEndHours());
		dto.setEndMinutes(entity.getEndMinutes());
		return dto;
	}

	@Override
	public List<ClassScheduleWeeklyClassScheduleDTO> toDTOList(List<ClassScheduleWeeklyClassScheduleEntity> entities) {
		List<ClassScheduleWeeklyClassScheduleDTO> dtos = new ArrayList<ClassScheduleWeeklyClassScheduleDTO>();
		
		for (ClassScheduleWeeklyClassScheduleEntity classScheduleWeeklyClassScheduleEntity : entities) {
			dtos.add(toDTO(classScheduleWeeklyClassScheduleEntity));
		}
		
		return dtos;
	}

}
