package com.duyb1906443.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.duyb1906443.dto.CommentDTO;
import com.duyb1906443.entity.CommentEntity;

@Component
public class CommentConverter
		implements IConverterToDTO<CommentEntity, CommentDTO>, IConverterToEntity<CommentEntity, CommentDTO> {
	
	@Autowired
	private CommentConverter commentConverter;
	
	@Override
	public CommentDTO toDTO(CommentEntity entity) {
		CommentDTO dto = new CommentDTO();
		if (entity.getId() != null)
			dto.setId(entity.getId());
		if(entity.getParentComment() != null) {
			dto.setParentId(entity.getParentComment().getId());			
		}
		if(entity.getReplies() != null) {
			List<CommentEntity> replies = entity.getReplies();
			List<CommentDTO> commentDTOs = commentConverter.toDTOList(replies);
			dto.setReplies(commentDTOs);
		}
		if(entity.getClassLesson() != null) {
			dto.setLessonId(entity.getClassLesson().getId());
		}
		dto.setContent(entity.getContent());
		dto.setCreatedDate(entity.getCreatedDate());
		dto.setUserAvatar(entity.getUser().getAvatar());
		dto.setUserId(entity.getUser().getId());
		dto.setUserName(entity.getUser().getUsername());
		dto.setFullname(entity.getUser().getFullname());
		dto.setStatus(entity.getStatus());
		return dto;
	}

	@Override
	public List<CommentDTO> toDTOList(List<CommentEntity> entities) {
		return entities.stream().map(item -> toDTO(item)).collect(Collectors.toList());
	}

	@Override
	public CommentEntity toEntity(CommentDTO dto) {
		CommentEntity entity = new CommentEntity();
		if(dto.getContent() != null) entity.setContent(dto.getContent());
		if(dto.getId() != null) entity.setId(dto.getId());
		if(dto.getPrivateMode() != null) entity.setPrivateMode(dto.getPrivateMode());
		return entity;
	}
	
	public CommentEntity toEntity(CommentDTO dto, CommentEntity entity) {
		if(dto.getContent() != null) entity.setContent(dto.getContent());
		if(dto.getId() != null) entity.setId(dto.getId());
		if(dto.getPrivateMode() != null) entity.setPrivateMode(dto.getPrivateMode());
		return entity;
	}

	@Override
	public List<CommentEntity> toEntityList(List<CommentDTO> dtos) {
		return dtos.stream().map(item -> toEntity(item)).collect(Collectors.toList());
	}

}
