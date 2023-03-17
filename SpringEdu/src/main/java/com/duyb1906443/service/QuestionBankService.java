package com.duyb1906443.service;

import java.util.List;

import com.duyb1906443.dto.QuestionBankDTO;

public interface QuestionBankService {

	QuestionBankDTO findOneById(Long questionBankId);
	List<QuestionBankDTO> findAllByUserId(Long userId);
	List<QuestionBankDTO> findAllByClassId(Long classId);
	QuestionBankDTO save(QuestionBankDTO dto, Long userId);
	void delete(Long id);
	
}
