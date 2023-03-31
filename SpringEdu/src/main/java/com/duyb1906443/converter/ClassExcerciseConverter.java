package com.duyb1906443.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.duyb1906443.dto.ClassExcerciseDTO;
import com.duyb1906443.entity.ClassExcerciseEntity;

@Component
public class ClassExcerciseConverter implements IConverterToDTO<ClassExcerciseEntity, ClassExcerciseDTO>, IConverterToEntity<ClassExcerciseEntity, ClassExcerciseDTO> {

	@Override
	public ClassExcerciseEntity toEntity(ClassExcerciseDTO dto) {
		ClassExcerciseEntity entity = new ClassExcerciseEntity();
		
		entity.setEffective(dto.getEffective());
		entity.setStartTime(dto.getStartTime());
		entity.setEndTime(dto.getEndTime());
		entity.setMark(dto.getMark());
		entity.setName(dto.getName());
		entity.setTimeLimit(dto.getTimeLimit());
		
		return entity;
	}
	public ClassExcerciseEntity toEntity(ClassExcerciseDTO dto, ClassExcerciseEntity entity) {
		if(dto.getEffective() != null) entity.setEffective(dto.getEffective());
		if(dto.getStartTime() != null) entity.setStartTime(dto.getStartTime());
		if(dto.getEndTime() != null) entity.setEndTime(dto.getEndTime());
		if(dto.getMark() != null) entity.setMark(dto.getMark());
	 	if(dto.getName() != null) entity.setName(dto.getName());
		if(dto.getTimeLimit() != null) entity.setTimeLimit(dto.getTimeLimit());
		return entity;
	}

	@Override
	public List<ClassExcerciseEntity> toEntityList(List<ClassExcerciseDTO> dtos) {
		return dtos.stream().map(dto -> toEntity(dto)).collect(Collectors.toList());
	}

	@Override
	public ClassExcerciseDTO toDTO(ClassExcerciseEntity entity) {
		ClassExcerciseDTO dto = new ClassExcerciseDTO();
		
		dto.setClassId(entity.getClassEntity().getId());
		dto.setCreatedTime(entity.getCreatedTime());
		dto.setEffective(entity.getEffective());
		dto.setEndTime(entity.getEndTime());
		dto.setId(entity.getId());
		dto.setMark(entity.getMark());
		dto.setName(entity.getName());
		dto.setStartTime(entity.getStartTime());
		dto.setTimeLimit(entity.getTimeLimit());
		dto.setMark(entity.getMark());

		if(entity.getQuiz() != null) {
			dto.setIsQuizTest(1);
			dto.setQuestionBankId(entity.getQuestionBank().getId());
			dto.setQuizNumberOfQuestion(entity.getQuiz().getNumberOfQuestion());
		}
		if(entity.getConstructedResponseTests() != null) {
			dto.setIsConstructedResponseTest(1);
		}
		
		return dto;
	}

	@Override
	public List<ClassExcerciseDTO> toDTOList(List<ClassExcerciseEntity> entities) {
		return entities.stream().map(entity -> toDTO(entity)).collect(Collectors.toList());
	}

}
