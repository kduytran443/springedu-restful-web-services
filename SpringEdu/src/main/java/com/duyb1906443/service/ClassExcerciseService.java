package com.duyb1906443.service;

import java.util.List;

import com.duyb1906443.dto.ClassExcerciseDTO;
import com.duyb1906443.dto.FileDTO;

public interface ClassExcerciseService {

	List<ClassExcerciseDTO> findAllByClassId(Long classId);
	List<ClassExcerciseDTO> findAllByUser(Long userId);

	ClassExcerciseDTO findOneById(Long id);

	ClassExcerciseDTO save(ClassExcerciseDTO classExcerciseDTO);

	void delete(ClassExcerciseDTO classExcerciseDTO);
	
	FileDTO saveFile(Long id, FileDTO fileDTO);
	List<FileDTO> getFileList(Long id);
	FileDTO delete(Long id, Long fileId);
}
