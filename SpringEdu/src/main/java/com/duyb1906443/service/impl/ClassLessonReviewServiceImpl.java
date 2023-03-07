package com.duyb1906443.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duyb1906443.converter.ClassLessonReviewConverter;
import com.duyb1906443.dto.ClassLessonReviewDTO;
import com.duyb1906443.entity.ClassLessonEntity;
import com.duyb1906443.repository.ClassLessonRepository;
import com.duyb1906443.repository.TopicRepository;
import com.duyb1906443.service.ClassLessonReviewService;

@Service
public class ClassLessonReviewServiceImpl implements ClassLessonReviewService {

	@Autowired
	private ClassLessonRepository classLessonRepository;
	
	@Autowired
	private TopicRepository topicRepository;
	
	@Autowired
	private ClassLessonReviewConverter classLessonReviewConverter;

	@Override
	public ClassLessonReviewDTO findPreviousOne(Long id) {
		ClassLessonEntity classLessonEntity = classLessonRepository.findOne(id);

		List<ClassLessonEntity> list = classLessonEntity.getTopic().getClassLessons();

		for (ClassLessonEntity classLessonItem : list) {
			if (classLessonItem.getOrdinalNumber() == classLessonEntity.getOrdinalNumber() - 1) {
				return classLessonReviewConverter.toDTO(classLessonItem);
			}
		}

		return null;
	}

	@Override
	public ClassLessonReviewDTO findNextOne(Long id) {
		ClassLessonEntity classLessonEntity = classLessonRepository.findOne(id);

		List<ClassLessonEntity> list = classLessonEntity.getTopic().getClassLessons();

		for (ClassLessonEntity classLessonItem : list) {
			if (classLessonItem.getOrdinalNumber() == classLessonEntity.getOrdinalNumber() + 1) {
				return classLessonReviewConverter.toDTO(classLessonItem);
			}
		}

		return null;
	}

	@Override
	public List<ClassLessonReviewDTO> findByTopicId(Long topicId) {
		List<ClassLessonReviewDTO> dtos = classLessonReviewConverter.toDTOList(topicRepository.findOne(topicId).getClassLessons());
		
		return null;
	}

}
