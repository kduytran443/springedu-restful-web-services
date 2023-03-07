package com.duyb1906443.service;

import java.util.List;

import com.duyb1906443.dto.ClassLessonReviewDTO;

public interface ClassLessonReviewService {
	
	ClassLessonReviewDTO findPreviousOne(Long id);
	ClassLessonReviewDTO findNextOne(Long id);
	List<ClassLessonReviewDTO> findByTopicId(Long topicId);
}
