package com.duyb1906443.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.duyb1906443.dto.ClassScheduleDTO;
import com.duyb1906443.entity.ClassEntity;
import com.duyb1906443.entity.ClassScheduleEntity;

@Component
public class ClassScheduleConverter implements IConverterToDTO<ClassScheduleEntity, ClassScheduleDTO>,
		IConverterToEntity<ClassScheduleEntity, ClassScheduleDTO> {

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
		dto.setClassId(entity.getClassEntity().getId());
		if(entity.getWeeklyClassSchedule() != null) {
			dto.setWeeklyClassScheduleCode(entity.getWeeklyClassSchedule().getCode());
			dto.setWeeklyClassScheduleId(entity.getWeeklyClassSchedule().getId());
			dto.setWeeklyClassScheduleName(entity.getWeeklyClassSchedule().getName());
		}
		if(entity.getClassEntity() != null) {
			ClassEntity classEntity = entity.getClassEntity();
			dto.setStartTimeOfClass(classEntity.getStartTime());
			dto.setEndTimeOfClass(classEntity.getEndTime());
			dto.setClassAvatar(classEntity.getAvatar());
			dto.setClassId(classEntity.getId());
			dto.setClassName(classEntity.getName());
		}
		
		return dto;
	}

	@Override
	public List<ClassScheduleDTO> toDTOList(List<ClassScheduleEntity> entities) {
		return entities.stream().map(entity -> toDTO(entity)).collect(Collectors.toList());
	}

	@Override
	public ClassScheduleEntity toEntity(ClassScheduleDTO dto) {
		ClassScheduleEntity classScheduleEntity = new ClassScheduleEntity();

		if (dto.getEndHours() != null)
			classScheduleEntity.setEndHours(dto.getEndHours());
		if (dto.getEndHours() != null)
			classScheduleEntity.setEndMinutes(dto.getEndMinutes());
		if (dto.getId() != null)
			classScheduleEntity.setId(dto.getId());
		if (dto.getStartHours() != null)
			classScheduleEntity.setStartHours(dto.getStartHours());
		if (dto.getStartMinutes() != null)
			classScheduleEntity.setStartMinutes(dto.getStartMinutes());

		return classScheduleEntity;
	}
	public ClassScheduleEntity toEntity(ClassScheduleDTO dto, ClassScheduleEntity classScheduleEntity) {

		if (dto.getEndHours() != null)
			classScheduleEntity.setEndHours(dto.getEndHours());
		if (dto.getEndHours() != null)
			classScheduleEntity.setEndMinutes(dto.getEndMinutes());
		if (dto.getId() != null)
			classScheduleEntity.setId(dto.getId());
		if (dto.getStartHours() != null)
			classScheduleEntity.setStartHours(dto.getStartHours());
		if (dto.getStartMinutes() != null)
			classScheduleEntity.setStartMinutes(dto.getStartMinutes());

		return classScheduleEntity;
	}

	@Override
	public List<ClassScheduleEntity> toEntityList(List<ClassScheduleDTO> dtos) {
		return dtos.stream().map(dto -> toEntity(dto)).collect(Collectors.toList());
	}

}
