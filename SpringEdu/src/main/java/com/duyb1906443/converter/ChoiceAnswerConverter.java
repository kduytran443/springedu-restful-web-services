package com.duyb1906443.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.duyb1906443.dto.ChoiceAnswerDTO;
import com.duyb1906443.dto.FileDTO;
import com.duyb1906443.entity.ChoiceAnswerEntity;

@Component
public class ChoiceAnswerConverter implements IConverterToEntity<ChoiceAnswerEntity, ChoiceAnswerDTO>, IConverterToDTO<ChoiceAnswerEntity, ChoiceAnswerDTO> {

	@Autowired
	private FileConverter fileConverter;
	
	@Override
	public ChoiceAnswerDTO toDTO(ChoiceAnswerEntity entity) {
		ChoiceAnswerDTO dto = new ChoiceAnswerDTO();
		dto.setContent(entity.getContent());
		dto.setCorrect(entity.getCorrect());
		if(entity.getFile() != null) {
			FileDTO fileDTO = fileConverter.toDTO(entity.getFile());
			dto.setFile(fileDTO);
		}
		dto.setId(entity.getId());
		dto.setType(entity.getType());
		return dto;
	}

	@Override
	public List<ChoiceAnswerDTO> toDTOList(List<ChoiceAnswerEntity> entities) {
		return entities.stream().map(entity -> toDTO(entity)).collect(Collectors.toList());
	}

	@Override
	public ChoiceAnswerEntity toEntity(ChoiceAnswerDTO dto) {
		ChoiceAnswerEntity entity = new ChoiceAnswerEntity();
		entity.setCorrect(dto.getCorrect());
		if(dto.getId() != null) entity.setId(dto.getId());
		if(dto.getType() != null) entity.setType(dto.getType());
		return entity;
	}
	public ChoiceAnswerEntity toEntity(ChoiceAnswerDTO dto, ChoiceAnswerEntity entity) {
		entity.setContent(dto.getContent());
		entity.setCorrect(dto.getCorrect());
		if(dto.getId() != null) entity.setId(dto.getId());
		if(dto.getType() != null) entity.setType(dto.getType());
		return entity;
	}

	@Override
	public List<ChoiceAnswerEntity> toEntityList(List<ChoiceAnswerDTO> dtos) {
		return dtos.stream().map(dto -> toEntity(dto)).collect(Collectors.toList());
	}

}
