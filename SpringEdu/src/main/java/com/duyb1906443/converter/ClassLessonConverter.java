package com.duyb1906443.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.duyb1906443.dto.ClassLessonDTO;
import com.duyb1906443.entity.ClassLessonEntity;

@Component
public class ClassLessonConverter implements IConverterToDTO<ClassLessonEntity, ClassLessonDTO> {
	
	@Autowired
	private FileConverter fileConverter;
	
	@Override
	public ClassLessonDTO toDTO(ClassLessonEntity entity) {
		ClassLessonDTO dto = new ClassLessonDTO();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setCreatedDate(entity.getCreatedDate());
		dto.setOrdinalNumber(entity.getOrdinalNumber());
		dto.setTextData(entity.getTextData().getContent());
		dto.setTopicId(entity.getTopic().getId());
		dto.setTopicName(entity.getTopic().getName());
		dto.setFiles(fileConverter.toDTOList(entity.getFiles()));
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
	
	
	
}
