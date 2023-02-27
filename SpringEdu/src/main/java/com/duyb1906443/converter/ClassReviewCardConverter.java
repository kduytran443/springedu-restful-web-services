package com.duyb1906443.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.duyb1906443.dto.ClassReviewCardDTO;
import com.duyb1906443.entity.ClassEntity;

@Component
public class ClassReviewCardConverter implements IConverterToDTO<ClassEntity, ClassReviewCardDTO> {
//Long id, String name, Date createdDate, String avatar, Integer accepted, float stars

	@Override
	public ClassReviewCardDTO toDTO(ClassEntity entity) {
		ClassReviewCardDTO dto = new ClassReviewCardDTO();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setCreatedDate(entity.getCreatedDate().toString());
		dto.setAvatar(entity.getAvatar());
		dto.setAccepted(entity.getAccepted());
		dto.setShortDescription(entity.getShortDescription());
		return dto;
	}

	@Override
	public List<ClassReviewCardDTO> toDTOList(List<ClassEntity> entities) {
		List<ClassReviewCardDTO> dtos = new ArrayList<ClassReviewCardDTO>();
		for (ClassEntity classEntity : entities) {
			dtos.add(toDTO(classEntity));
		}
		return dtos;
	}

}
