package com.duyb1906443.service;

import java.util.List;

import com.duyb1906443.dto.SubmittedExerciseDTO;

public interface SubmittedExerciseService {

	List<SubmittedExerciseDTO> findAllByClassExcercise(Long classExcerciseId);

	SubmittedExerciseDTO findOneById(Long id);

	SubmittedExerciseDTO save(SubmittedExerciseDTO submittedExerciseDTO);
	SubmittedExerciseDTO submit(SubmittedExerciseDTO submittedExerciseDTO);
	List<SubmittedExerciseDTO> findAllByClassExerciseIdAndUserId(Long classExerciseId, Long userId);

	void delete(SubmittedExerciseDTO submittedExerciseDTO);

}
