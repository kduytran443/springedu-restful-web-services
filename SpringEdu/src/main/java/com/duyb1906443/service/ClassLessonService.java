package com.duyb1906443.service;

import com.duyb1906443.dto.ClassLessonDTO;

public interface ClassLessonService {
	
	ClassLessonDTO findOne(Long id);
	ClassLessonDTO save(ClassLessonDTO classLessonDTO);
	void delete(Long id);
	
}
