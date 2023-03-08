package com.duyb1906443.service;

import java.util.List;

import com.duyb1906443.dto.QuestionBankDTO;

public interface QuestionBankService {

	List<QuestionBankDTO> findAllByUserId(Long userId);
	QuestionBankDTO save(QuestionBankDTO dto, Long userId);
	
}
