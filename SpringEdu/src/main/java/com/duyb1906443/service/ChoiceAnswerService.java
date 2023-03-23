package com.duyb1906443.service;

import java.util.List;

import com.duyb1906443.dto.ChoiceAnswerDTO;

public interface ChoiceAnswerService {
	
	List<ChoiceAnswerDTO> findAllByChoiceQuestionId(Long choiceQuestionId);
	List<ChoiceAnswerDTO> findAllByDrawQuizId(Long drawQuizId);
	ChoiceAnswerDTO findOneById(Long id);
	ChoiceAnswerDTO save(ChoiceAnswerDTO choiceAnswerDTO);
	void delete(ChoiceAnswerDTO choiceAnswerDTO);
	
}
