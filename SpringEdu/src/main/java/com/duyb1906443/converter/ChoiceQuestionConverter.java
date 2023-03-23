package com.duyb1906443.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.duyb1906443.dto.ChoiceQuestionDTO;
import com.duyb1906443.entity.ChoiceQuestionEntity;

@Component
public class ChoiceQuestionConverter implements IConverterToDTO<ChoiceQuestionEntity, ChoiceQuestionDTO>, IConverterToEntity<ChoiceQuestionEntity, ChoiceQuestionDTO> {

	@Override
	public ChoiceQuestionEntity toEntity(ChoiceQuestionDTO dto) {
		
		ChoiceQuestionEntity entity = new ChoiceQuestionEntity();
		entity.setName(dto.getName());
		entity.setContent(dto.getContent());
		
		return entity;
	}

	@Override
	public List<ChoiceQuestionEntity> toEntityList(List<ChoiceQuestionDTO> dtos) {
		return dtos.stream().map(dto -> toEntity(dto)).collect(Collectors.toList());
	}

	@Override
	public ChoiceQuestionDTO toDTO(ChoiceQuestionEntity entity) {
		ChoiceQuestionDTO dto = new ChoiceQuestionDTO();
		
		dto.setContent(entity.getContent());
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setQuestionBank(entity.getQuestionBank().getId());
		dto.setQuestionBankName(entity.getQuestionBank().getName());
		dto.setStatus(entity.getStatus());
		if(entity.getChoiceAnswers() != null) dto.setAnswerQuantity(entity.getChoiceAnswers().size());
		
		return dto;
	}

	@Override
	public List<ChoiceQuestionDTO> toDTOList(List<ChoiceQuestionEntity> entities) {
		return entities.stream().map(entity -> toDTO(entity)).collect(Collectors.toList());
	}

}
