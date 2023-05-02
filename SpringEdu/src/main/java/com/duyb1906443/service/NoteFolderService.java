package com.duyb1906443.service;

import java.util.List;

import com.duyb1906443.dto.NoteFolderDTO;

public interface NoteFolderService {
	
	List<NoteFolderDTO> findAllByUserId(Long userId);
	NoteFolderDTO findOneById(Long id);
	NoteFolderDTO save(NoteFolderDTO noteFolderDTO);
	NoteFolderDTO delete(Long id);
	
}
