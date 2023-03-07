package com.duyb1906443.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.duyb1906443.dto.ClassLessonDTO;
import com.duyb1906443.entity.ClassLessonEntity;

@Component
public class ClassLessonConverter implements IConverterToDTO<ClassLessonEntity, ClassLessonDTO>,
		IConverterToEntity<ClassLessonEntity, ClassLessonDTO> {

	@Autowired
	private FileConverter fileConverter;

	@Override
	public ClassLessonDTO toDTO(ClassLessonEntity entity) {
		ClassLessonDTO dto = new ClassLessonDTO();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setCreatedDate(entity.getCreatedDate());
		dto.setOrdinalNumber(entity.getOrdinalNumber());
		if(entity.getTextData() != null) dto.setTextData(entity.getTextData().getContent());
		dto.setTopicId(entity.getTopic().getId());
		dto.setTopicName(entity.getTopic().getName());
		if(entity.getFiles() != null) dto.setFiles(fileConverter.toDTOList(entity.getFiles()));
		return dto;
	}

	@Override
	public List<ClassLessonDTO> toDTOList(List<ClassLessonEntity> entities) {
		List<ClassLessonDTO> dtos = new ArrayList<>();

		for (ClassLessonEntity classLessonEntity : entities) {
			dtos.add(toDTO(classLessonEntity));
		}

		return dtos;
	}

	public ClassLessonEntity toEntity(ClassLessonDTO dto, ClassLessonEntity entity) {
		if (dto.getId() != null)
			entity.setId(dto.getId());
		entity.setName(dto.getName());
		return entity;
	}

	@Override
	public ClassLessonEntity toEntity(ClassLessonDTO dto) {
		ClassLessonEntity entity = new ClassLessonEntity();
		if (dto.getId() != null)
			entity.setId(dto.getId());
		entity.setName(dto.getName());
		return entity;
	}

	@Override
	public List<ClassLessonEntity> toEntityList(List<ClassLessonDTO> dtos) {
		List<ClassLessonEntity> entities = new ArrayList<>();
		for (ClassLessonDTO classLessonDTO : dtos) {
			entities.add(toEntity(classLessonDTO));
		}
		return entities;
	}

}
