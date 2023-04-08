package com.duyb1906443.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.duyb1906443.dto.TopicDTO;
import com.duyb1906443.entity.TopicEntity;

@Component
public class TopicConverter implements IConverterToDTO<TopicEntity, TopicDTO>, IConverterToEntity<TopicEntity, TopicDTO> {
	
	@Autowired
	private ClassLessonReviewConverter classLessonReviewConverter;
	
	@Override
	public TopicDTO toDTO(TopicEntity entity) {
		TopicDTO dto = new TopicDTO();
		if(entity.getId() != null) dto.setId(entity.getId());
		dto.setClassId(entity.getClassEntity().getId());
		if(entity.getClassLessons() != null) dto.setClassLessonReviews(classLessonReviewConverter.toDTOList(entity.getClassLessons()));
		dto.setName(entity.getName());
		dto.setVisible(entity.getVisible());
		dto.setOrdinalNumber(entity.getOrdinalNumber());
		return dto;
	}

	@Override
	public List<TopicDTO> toDTOList(List<TopicEntity> entities) {
		List<TopicDTO> dtos = new ArrayList<>();
		for (TopicEntity topicEntity : entities) {
			dtos.add(toDTO(topicEntity));
		}
		return dtos;
	}
	
	public TopicEntity toEntity(TopicDTO dto, TopicEntity entity) {
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		return entity;
	}

	@Override
	public TopicEntity toEntity(TopicDTO dto) {
		TopicEntity entity = new TopicEntity();
		if(dto.getId() != null) entity.setId(dto.getId());
		if(dto.getName() != null) entity.setName(dto.getName());
		if(dto.getOrdinalNumber() != null) entity.setOrdinalNumber(dto.getOrdinalNumber());
		if(dto.getVisible() != null) entity.setVisible(dto.getVisible());
		return entity;
	}

	@Override
	public List<TopicEntity> toEntityList(List<TopicDTO> dtos) {
		List<TopicEntity> entities = new ArrayList<>();
		for (TopicDTO topicDTO : dtos) {
			entities.add(toEntity(topicDTO));
		}
		return entities;
	}
	
}
