package com.duyb1906443.service;

import java.util.List;

import com.duyb1906443.dto.ClassLessonDTO;
import com.duyb1906443.dto.FileDTO;

public interface ClassLessonService {
	
	ClassLessonDTO findOne(Long id);
	ClassLessonDTO save(ClassLessonDTO classLessonDTO);
	void delete(Long id);

	FileDTO saveFile(Long id, FileDTO fileDTO);
	List<FileDTO> getFileList(Long id);
	FileDTO delete(Long id, Long fileId);
}
