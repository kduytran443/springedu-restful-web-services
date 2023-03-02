package com.duyb1906443.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duyb1906443.converter.CommentConverter;
import com.duyb1906443.dto.CommentDTO;
import com.duyb1906443.entity.ClassEntity;
import com.duyb1906443.repository.ClassRepository;
import com.duyb1906443.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private ClassRepository classRepository;
	
	@Autowired
	private CommentConverter commentConverter;
	
	@Override
	public List<CommentDTO> findAllByClassId(Long classId) {
		ClassEntity classEntity = classRepository.findOne(classId);
		return commentConverter.toDTOList(classEntity.getComments());
	}

}
