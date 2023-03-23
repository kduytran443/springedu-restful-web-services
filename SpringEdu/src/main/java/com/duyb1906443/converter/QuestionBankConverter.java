package com.duyb1906443.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.duyb1906443.dto.QuestionBankDTO;
import com.duyb1906443.entity.ChoiceQuestionEntity;
import com.duyb1906443.entity.QuestionBankEntity;

@Component
public class QuestionBankConverter implements IConverterToDTO<QuestionBankEntity, QuestionBankDTO>,
		IConverterToEntity<QuestionBankEntity, QuestionBankDTO> {

	@Override
	public QuestionBankEntity toEntity(QuestionBankDTO dto) {
		QuestionBankEntity entity = new QuestionBankEntity();
		if(dto.getId() != null) entity.setId(dto.getId());
		entity.setName(dto.getName());
		if(dto.getStatus() != null) entity.setStatus(dto.getStatus());
		return entity;
	}
	
	public QuestionBankEntity toEntity(QuestionBankDTO dto, QuestionBankEntity entity) {
		if(dto.getId() != null) entity.setId(dto.getId());
		entity.setName(dto.getName());
		if(dto.getStatus() != null) entity.setStatus(dto.getStatus());
		return entity;
	}

	@Override
	public List<QuestionBankEntity> toEntityList(List<QuestionBankDTO> dtos) {
		List<QuestionBankEntity> entities = new ArrayList<>();
		
		for (QuestionBankDTO questionBankDTO : dtos) {
			entities.add(toEntity(questionBankDTO));
		}
		
		return entities;
	}

	@Override
	public QuestionBankDTO toDTO(QuestionBankEntity entity) {
		QuestionBankDTO dto = new QuestionBankDTO();
		
		if(entity.getId() != null) dto.setId(entity.getId());
		dto.setName(entity.getName());
		if(entity.getStatus() != null) dto.setStatus(entity.getStatus());
		if(entity.getUser() != null) {
			dto.setUserId(entity.getUser().getId());
			dto.setUsername(entity.getUser().getUsername());
		}
		if(entity.getChoiceQuestions() != null) {
			List<ChoiceQuestionEntity> choiceQuestionEntities = entity.getChoiceQuestions().stream().filter(question -> question.getStatus() == 1).collect(Collectors.toList());
			dto.setQuestionQuantity(choiceQuestionEntities.size());
		}
		return dto;
	}

	@Override
	public List<QuestionBankDTO> toDTOList(List<QuestionBankEntity> entities) {
		List<QuestionBankDTO> dtos = new ArrayList<>();
		
		for (QuestionBankEntity questionBankEntity : entities) {
			dtos.add(toDTO(questionBankEntity));
		}
		
		return dtos;
	}

}
