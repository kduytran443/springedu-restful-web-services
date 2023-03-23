package com.duyb1906443.service;

import com.duyb1906443.dto.ConstructedResponseTestDTO;

public interface ConstructedResponseTestService {
	ConstructedResponseTestDTO findOneById(Long id);
	ConstructedResponseTestDTO findOneByClassExcerciseId(Long classExcerciseId);
	ConstructedResponseTestDTO save(ConstructedResponseTestDTO constructedResponseTestDTO);
	void delete(ConstructedResponseTestDTO constructedResponseTestDTO);
}
