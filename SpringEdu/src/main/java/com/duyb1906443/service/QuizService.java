package com.duyb1906443.service;

import com.duyb1906443.dto.QuizDTO;

public interface QuizService {
	
	QuizDTO findOneByClassExcerciseId(Long exerciseId);
	QuizDTO findOneById(Long id);
	QuizDTO save(QuizDTO quizDTO);
	void delete(QuizDTO quizDTO);
	
}
