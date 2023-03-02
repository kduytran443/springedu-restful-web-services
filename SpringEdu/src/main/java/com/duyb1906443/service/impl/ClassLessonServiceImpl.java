package com.duyb1906443.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duyb1906443.converter.ClassLessonConverter;
import com.duyb1906443.dto.ClassLessonDTO;
import com.duyb1906443.entity.ClassLessonEntity;
import com.duyb1906443.repository.ClassLessonRepository;
import com.duyb1906443.service.ClassLessonService;

@Service
public class ClassLessonServiceImpl implements ClassLessonService {
	
	@Autowired
	private ClassLessonRepository classLessonRepository;
	
	@Autowired
	private ClassLessonConverter classLessonConverter;
	
	@Override
	public ClassLessonDTO findOne(Long id) {
		ClassLessonEntity classLessonEntity = classLessonRepository.findOne(id);
		ClassLessonDTO classLessonDTO = classLessonConverter.toDTO(classLessonEntity);
		return classLessonDTO;
	}
	
}
