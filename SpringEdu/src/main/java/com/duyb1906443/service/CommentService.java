package com.duyb1906443.service;

import java.util.List;

import com.duyb1906443.dto.CommentDTO;

public interface CommentService {
	
	List<CommentDTO> findAllByLessonId(Long topicId);
	CommentDTO save(CommentDTO commentDTO);
	CommentDTO delete(Long id);
	
}
