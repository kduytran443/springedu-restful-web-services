package com.duyb1906443.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duyb1906443.converter.CommentConverter;
import com.duyb1906443.dto.CommentDTO;
import com.duyb1906443.entity.ClassLessonEntity;
import com.duyb1906443.entity.CommentEntity;
import com.duyb1906443.repository.ClassLessonRepository;
import com.duyb1906443.repository.CommentRepository;
import com.duyb1906443.repository.UserRepository;
import com.duyb1906443.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private ClassLessonRepository classLessonRepository;

	@Autowired
	private CommentRepository commentRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CommentConverter commentConverter;

	@Override
	public List<CommentDTO> findAllByLessonId(Long topicId) {
		ClassLessonEntity classLessonEntity = classLessonRepository.findOne(topicId);
		return commentConverter.toDTOList(classLessonEntity.getComments().stream().filter(item -> item.getStatus() == 1).collect(Collectors.toList()));
	}

	@Override
	public CommentDTO save(CommentDTO commentDTO) {
		CommentEntity commentEntity = new CommentEntity();
		ClassLessonEntity classLessonEntity = classLessonRepository.findOne(commentDTO.getLessonId());
		
		commentEntity = commentConverter.toEntity(commentDTO);
		if(commentDTO.getParentId() != null) {
			CommentEntity parentCommentEntity = commentRepository.findOne(commentDTO.getParentId());
			commentEntity.setParentComment(parentCommentEntity);			
		}
		commentEntity.setStatus(1);
		commentEntity.setClassLesson(classLessonEntity);
		commentEntity.setUser(userRepository.findOne(commentDTO.getUserId()));
		
		Date date = new Date();
		Timestamp time = new Timestamp(date.getTime());
		
		commentEntity.setCreatedDate(time);
		if(commentEntity != null) {
			commentEntity = commentRepository.save(commentEntity);			
		}
		return commentConverter.toDTO(commentEntity);
	}

	@Override
	public CommentDTO delete(Long id) {
		CommentEntity commentEntity = commentRepository.findOne(id);
		commentEntity.setStatus(0);
		commentEntity = commentRepository.save(commentEntity);		
		CommentDTO dto = commentConverter.toDTO(commentEntity);
		return dto;
	}

}
