package com.duyb1906443.service;

import java.util.List;

import com.duyb1906443.dto.TransactionDTO;

public interface TransactionService {
	TransactionDTO save(TransactionDTO transactionDTO);
	List<TransactionDTO> findAllByUserId(Long userId);
	List<TransactionDTO> findAllByClassId(Long classId);
}
