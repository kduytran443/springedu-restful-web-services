package com.duyb1906443.service;

import java.util.List;

import com.duyb1906443.dto.DrawQuizDTO;

public interface DrawQuizService {

	List<DrawQuizDTO> findAllByClassExcerciseId(Long classExcerciseId);

	List<DrawQuizDTO> findAllBySubmittedExerciseId(Long submittedExerciseId);

	List<DrawQuizDTO> findAllByQuizId(Long quizId);
	
	DrawQuizDTO answerChoice(DrawQuizDTO drawQuizDTO, Long choiceAnswerId);
	List<DrawQuizDTO> findAllChoiceAnswerByDrawQuizId(Long drawQuizId);

	DrawQuizDTO findOneById(Long drawQuizId);

	DrawQuizDTO save(DrawQuizDTO drawQuizDTO);

	void delete(DrawQuizDTO drawQuizDTO);
	
	List<DrawQuizDTO> drawRandom(DrawQuizDTO drawQuizDTO);

}
