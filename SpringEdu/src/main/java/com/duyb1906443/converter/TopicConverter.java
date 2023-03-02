package com.duyb1906443.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.duyb1906443.dto.TopicDTO;
import com.duyb1906443.entity.TopicEntity;

@Component
public class TopicConverter implements IConverterToDTO<TopicEntity, TopicDTO> {
	
	@Autowired
	private ClassLessonReviewConverter classLessonReviewConverter;
	
	@Override
	public TopicDTO toDTO(TopicEntity entity) {
		TopicDTO dto = new TopicDTO();
		if(entity.getId() != null) dto.setId(entity.getId());
		dto.setClassId(entity.getClassEntity().getId());
		dto.setClassLessonReviews(classLessonReviewConverter.toDTOList(entity.getClassLessons()));
		dto.setName(entity.getName());
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
	
	
	
}
