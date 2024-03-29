package com.duyb1906443.service;

import java.util.List;

import com.duyb1906443.dto.FileDTO;
import com.duyb1906443.dto.ScoreDTO;
import com.duyb1906443.dto.SubmittedExerciseDTO;

public interface SubmittedExerciseService {

	List<SubmittedExerciseDTO> findAllByClassExcercise(Long classExcerciseId);

	SubmittedExerciseDTO findOneById(Long id);
	SubmittedExerciseDTO grade(ScoreDTO scoreDTO);

	SubmittedExerciseDTO save(SubmittedExerciseDTO submittedExerciseDTO);
	
	FileDTO saveFile(Long id, FileDTO fileDTO);
	List<FileDTO> getFileList(Long id);
	FileDTO delete(Long id, Long fileId);
	
	SubmittedExerciseDTO submit(SubmittedExerciseDTO submittedExerciseDTO);
	List<SubmittedExerciseDTO> findAllByClassExerciseIdAndUserId(Long classExerciseId, Long userId);
	List<SubmittedExerciseDTO> findAllByClassIdAndUserId(Long classId, Long userId);
	List<SubmittedExerciseDTO> findAllByUserId(Long userId);
	List<SubmittedExerciseDTO> findAllForTeacherByUserId(Long userId);

	void delete(SubmittedExerciseDTO submittedExerciseDTO);

}
