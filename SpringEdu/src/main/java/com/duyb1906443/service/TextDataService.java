package com.duyb1906443.service;

import com.duyb1906443.dto.TextDataDTO;

public interface TextDataService {
	
	public TextDataDTO findOneByClassLessonId(Long classLessonId);
	public TextDataDTO findOneByClassId(Long classId);
	public TextDataDTO save(TextDataDTO textDataDTO);
	public TextDataDTO saveOnClassLesson(TextDataDTO textDataDTO, Long classLessonId);
	public TextDataDTO saveOnClass(TextDataDTO textDataDTO, Long classId);
	
}
