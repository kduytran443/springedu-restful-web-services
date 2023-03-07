package com.duyb1906443.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.duyb1906443.dto.ClassLessonReviewDTO;
import com.duyb1906443.entity.ClassLessonEntity;

@Component
public class ClassLessonReviewConverter implements IConverterToDTO<ClassLessonEntity, ClassLessonReviewDTO> {

	@Override
	public ClassLessonReviewDTO toDTO(ClassLessonEntity entity) {
		ClassLessonReviewDTO dto = new ClassLessonReviewDTO();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setCreatedDate(entity.getCreatedDate());
		dto.setOrdinalNumber(entity.getOrdinalNumber());
		return dto;
	}

	@Override
	public List<ClassLessonReviewDTO> toDTOList(List<ClassLessonEntity> entities) {
		List<ClassLessonReviewDTO> dtos = new ArrayList<>();
		
		for (ClassLessonEntity classLessonEntity : entities) {
			ClassLessonReviewDTO dto = toDTO(classLessonEntity);
			dtos.add(dto);
		}
		
		return dtos;
	}

}
