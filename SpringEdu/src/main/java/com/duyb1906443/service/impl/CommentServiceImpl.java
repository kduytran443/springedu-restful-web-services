package com.duyb1906443.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duyb1906443.converter.CommentConverter;
import com.duyb1906443.dto.CommentDTO;
import com.duyb1906443.entity.ClassEntity;
import com.duyb1906443.entity.CommentEntity;
import com.duyb1906443.repository.ClassRepository;
import com.duyb1906443.repository.CommentRepository;
import com.duyb1906443.repository.UserRepository;
import com.duyb1906443.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private ClassRepository classRepository;

	@Autowired
	private CommentRepository commentRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CommentConverter commentConverter;

	@Override
	public List<CommentDTO> findAllByClassId(Long classId) {
		ClassEntity classEntity = classRepository.findOne(classId);
		return commentConverter.toDTOList(classEntity.getComments());
	}

	@Override
	public CommentDTO save(CommentDTO commentDTO) {
		CommentEntity commentEntity = new CommentEntity();
		if (commentDTO.getId() != null) {
			CommentEntity oldCommentEntity = commentRepository.findOne(commentDTO.getId());
			commentEntity = commentConverter.toEntity(commentDTO, oldCommentEntity);
		} else {
			commentEntity.setClassEntity(classRepository.findOne(commentDTO.getClassId()));
			commentEntity.setUser(userRepository.findOne(commentDTO.getUserId()));
			
			Date date = new Date();
			Timestamp time = new Timestamp(date.getTime());
			
			commentEntity.setCreatedDate(time);
		}
		commentEntity = commentRepository.save(commentEntity);
		return commentConverter.toDTO(commentEntity);
	}

}
