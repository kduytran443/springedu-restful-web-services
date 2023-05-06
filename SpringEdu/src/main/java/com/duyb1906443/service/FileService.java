package com.duyb1906443.service;

import java.util.List;

import com.duyb1906443.dto.FileDTO;

public interface FileService {
	
	List<FileDTO> findAllByClassLessonId(Long classLessonId);
	void uploadFileOnClassLesson(FileDTO fileDTO, Long classId);
	FileDTO getById(Long id);
	
}
