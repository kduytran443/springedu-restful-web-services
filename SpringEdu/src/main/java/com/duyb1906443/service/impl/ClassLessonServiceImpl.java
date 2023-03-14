package com.duyb1906443.service.impl;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duyb1906443.converter.ClassLessonConverter;
import com.duyb1906443.dto.ClassLessonDTO;
import com.duyb1906443.entity.ClassLessonEntity;
import com.duyb1906443.repository.ClassLessonRepository;
import com.duyb1906443.repository.TopicRepository;
import com.duyb1906443.service.ClassLessonService;

@Service
public class ClassLessonServiceImpl implements ClassLessonService {

	@Autowired
	private ClassLessonRepository classLessonRepository;

	@Autowired
	private TopicRepository topicRepository;

	@Autowired
	private ClassLessonConverter classLessonConverter;

	@Override
	public ClassLessonDTO findOne(Long id) {
		ClassLessonEntity classLessonEntity = classLessonRepository.findOne(id);
		ClassLessonDTO classLessonDTO = classLessonConverter.toDTO(classLessonEntity);
		return classLessonDTO;
	}

	@Override
	public ClassLessonDTO save(ClassLessonDTO classLessonDTO) {
		ClassLessonEntity classLessonEntity = new ClassLessonEntity();

		if (classLessonDTO.getId() != null) {
			ClassLessonEntity oldClassLessonEntity = classLessonRepository.findOne(classLessonDTO.getId());
			classLessonEntity = classLessonConverter.toEntity(classLessonDTO, oldClassLessonEntity);
		} else {
			classLessonEntity = classLessonConverter.toEntity(classLessonDTO);
			Date date = new Date();
			classLessonEntity.setCreatedDate(new Timestamp(date.getTime()));
		}
		if(classLessonDTO.getTopicId() != null) {
			classLessonEntity.setTopic(topicRepository.findOne(classLessonDTO.getTopicId()));
		}
		classLessonEntity = classLessonRepository.save(classLessonEntity);

		return classLessonConverter.toDTO(classLessonEntity);
	}

	@Override
	public void delete(Long id) {
		classLessonRepository.delete(id);
	}

}
