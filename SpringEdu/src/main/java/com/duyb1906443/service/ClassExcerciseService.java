package com.duyb1906443.service;

import java.util.List;

import com.duyb1906443.dto.ClassExcerciseDTO;

public interface ClassExcerciseService {

	List<ClassExcerciseDTO> findAllByClassId(Long classId);

	ClassExcerciseDTO findOneById(Long id);

	ClassExcerciseDTO save(ClassExcerciseDTO classExcerciseDTO);

	void delete(ClassExcerciseDTO classExcerciseDTO);
}
