package com.duyb1906443.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.duyb1906443.dto.SubmittedExerciseDTO;
import com.duyb1906443.entity.SubmittedExerciseEntity;

@Component
public class SubmittedExerciseConverter implements IConverterToDTO<SubmittedExerciseEntity, SubmittedExerciseDTO>,
		IConverterToEntity<SubmittedExerciseEntity, SubmittedExerciseDTO> {
	
	@Autowired
	private ClassExcerciseConverter classExcerciseConverter;
	
	@Override
	public SubmittedExerciseEntity toEntity(SubmittedExerciseDTO dto) {
		SubmittedExerciseEntity entity = new SubmittedExerciseEntity();
		
		if(dto.getMark() != null) entity.setMark(dto.getMark());
		if(dto.getContent() != null) entity.setContent(dto.getContent());
		if(dto.getStartTime() != null) entity.setStartTime(dto.getStartTime());
		if(dto.getSubmitTime() != null) entity.setSubmitTime(dto.getSubmitTime());
		
		return entity;
	}
	public SubmittedExerciseEntity toEntity(SubmittedExerciseDTO dto, SubmittedExerciseEntity entity) {

		if(dto.getMark() != null) entity.setMark(dto.getMark());
		if(dto.getContent() != null) entity.setContent(dto.getContent());
		if(dto.getStartTime() != null) entity.setStartTime(dto.getStartTime());
		if(dto.getSubmitTime() != null) entity.setSubmitTime(dto.getSubmitTime());
		
		return entity;
	}

	@Override
	public List<SubmittedExerciseEntity> toEntityList(List<SubmittedExerciseDTO> dtos) {
		return dtos.stream().map(dto -> toEntity(dto)).collect(Collectors.toList());
	}

	@Override
	public SubmittedExerciseDTO toDTO(SubmittedExerciseEntity entity) {
		SubmittedExerciseDTO dto = new SubmittedExerciseDTO();
		
		dto.setClassExcercise(classExcerciseConverter.toDTO(entity.getClassExcercise()));
		dto.setTeacherComment(entity.getTeacherComment());
		
		dto.setContent(entity.getContent());
		dto.setId(entity.getId());
		dto.setStartTime(entity.getStartTime());
		dto.setSubmitTime(entity.getSubmitTime());
		dto.setUserId(entity.getUser().getId());
		dto.setUsername(entity.getUser().getUsername());
		dto.setUserAvatar(entity.getUser().getAvatar());
		dto.setMark(entity.getMark());
		
		return dto;
	}

	@Override
	public List<SubmittedExerciseDTO> toDTOList(List<SubmittedExerciseEntity> entities) {
		return entities.stream().map(entity -> toDTO(entity)).collect(Collectors.toList());
	}

}
