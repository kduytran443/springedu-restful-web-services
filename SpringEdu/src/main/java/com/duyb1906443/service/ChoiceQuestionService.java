package com.duyb1906443.service;

import java.util.List;

import com.duyb1906443.dto.ChoiceQuestionDTO;

public interface ChoiceQuestionService {
	
	List<ChoiceQuestionDTO> findAllByQuestionBankId(Long questionBankId);
	ChoiceQuestionDTO findOneById(Long id);
	ChoiceQuestionDTO save(ChoiceQuestionDTO choiceQuestionDTO);
	void delete(ChoiceQuestionDTO choiceQuestionDTO);
	
}
