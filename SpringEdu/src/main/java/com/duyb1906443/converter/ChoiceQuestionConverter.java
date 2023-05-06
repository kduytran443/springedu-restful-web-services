package com.duyb1906443.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.duyb1906443.dto.ChoiceQuestionDTO;
import com.duyb1906443.dto.FileDTO;
import com.duyb1906443.entity.ChoiceQuestionEntity;

@Component
public class ChoiceQuestionConverter implements IConverterToDTO<ChoiceQuestionEntity, ChoiceQuestionDTO>, IConverterToEntity<ChoiceQuestionEntity, ChoiceQuestionDTO> {
	
	@Autowired
	private FileConverter fileConverter;
	
	@Override
	public ChoiceQuestionEntity toEntity(ChoiceQuestionDTO dto) {
		
		ChoiceQuestionEntity entity = new ChoiceQuestionEntity();
		if(dto.getName() != null){
			entity.setName(dto.getName());			
		}
		if(dto.getContent() != null) {
			entity.setContent(dto.getContent());			
		}
		if(dto.getImportant() != null) {
			entity.setImportant(dto.getImportant());
		}
		
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
		dto.setImportant(entity.getImportant());
		
		if(entity.getFile() != null) {
			FileDTO fileDTO = fileConverter.toDTO(entity.getFile());
			dto.setFile(fileDTO);
		}
		
		return dto;
	}

	@Override
	public List<ChoiceQuestionDTO> toDTOList(List<ChoiceQuestionEntity> entities) {
		return entities.stream().map(entity -> toDTO(entity)).collect(Collectors.toList());
	}

}
