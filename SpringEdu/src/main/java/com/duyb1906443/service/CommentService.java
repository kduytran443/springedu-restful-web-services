package com.duyb1906443.service;

import java.util.List;

import com.duyb1906443.dto.CommentDTO;

public interface CommentService {
	
	List<CommentDTO> findAllByClassId(Long classId);
	CommentDTO save(CommentDTO commentDTO);
	
}
