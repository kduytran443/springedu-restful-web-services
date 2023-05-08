package com.duyb1906443.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.duyb1906443.dto.ClassLessonDTO;
import com.duyb1906443.entity.ClassLessonEntity;

@Component
public class ClassLessonConverter implements IConverterToDTO<ClassLessonEntity, ClassLessonDTO>,
		IConverterToEntity<ClassLessonEntity, ClassLessonDTO> {


	@Override
	public ClassLessonDTO toDTO(ClassLessonEntity entity) {
		ClassLessonDTO dto = new ClassLessonDTO();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setCreatedDate(entity.getCreatedDate());
		dto.setOrdinalNumber(entity.getOrdinalNumber());
		if(entity.getContent() != null) {
			dto.setTextData(entity.getContent());
		}
		dto.setTopicId(entity.getTopic().getId());
		dto.setTopicName(entity.getTopic().getName());
		
		return dto;
	}

	@Override
	public List<ClassLessonDTO> toDTOList(List<ClassLessonEntity> entities) {
		return entities.stream().map(entity -> toDTO(entity)).collect(Collectors.toList());
	}

	public ClassLessonEntity toEntity(ClassLessonDTO dto, ClassLessonEntity entity) {
		if (dto.getId() != null)
			entity.setId(dto.getId());
		entity.setName(dto.getName());
		if(dto.getTextData() != null) {
			entity.setContent(dto.getTextData());
		}
		entity.setName(dto.getName());
		entity.setOrdinalNumber(dto.getOrdinalNumber());
		return entity;
	}

	@Override
	public ClassLessonEntity toEntity(ClassLessonDTO dto) {
		ClassLessonEntity entity = new ClassLessonEntity();
		if (dto.getId() != null)
			entity.setId(dto.getId());
		entity.setName(dto.getName());
		if(dto.getTextData() != null) {
			entity.setContent(dto.getTextData());
		}
		return entity;
	}

	@Override
	public List<ClassLessonEntity> toEntityList(List<ClassLessonDTO> dtos) {
		return dtos.stream().map(dto -> toEntity(dto)).collect(Collectors.toList());
	}

}
