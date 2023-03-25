package com.duyb1906443.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.duyb1906443.dto.QuizDTO;
import com.duyb1906443.entity.QuizEntity;

@Component
public class QuizConverter implements IConverterToDTO<QuizEntity, QuizDTO>, IConverterToEntity<QuizEntity, QuizDTO> {

	@Override
	public QuizEntity toEntity(QuizDTO dto) {
		QuizEntity entity = new QuizEntity();
		entity.setNumberOfQuestion(dto.getNumberOfQuestion());
		return entity;
	}
	public QuizEntity toEntity(QuizDTO dto, QuizEntity entity) {
		entity.setNumberOfQuestion(dto.getNumberOfQuestion());
		return entity;
	}

	@Override
	public List<QuizEntity> toEntityList(List<QuizDTO> dtos) {
		return dtos.stream().map(dto -> toEntity(dto)).collect(Collectors.toList());
	}

	@Override
	public QuizDTO toDTO(QuizEntity entity) {
		QuizDTO dto = new QuizDTO();
		
		dto.setClassExcerciseId(entity.getClassExcercise().getId());
		dto.setId(entity.getId());
		dto.setMark(entity.getClassExcercise().getMark());
		dto.setNumberOfQuestion(entity.getNumberOfQuestion());
		
		return dto;
	}

	@Override
	public List<QuizDTO> toDTOList(List<QuizEntity> entities) {
		return entities.stream().map(entity -> toDTO(entity)).collect(Collectors.toList());
	}

}
