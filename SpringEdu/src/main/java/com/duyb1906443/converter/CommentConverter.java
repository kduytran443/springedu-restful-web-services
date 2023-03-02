package com.duyb1906443.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.duyb1906443.dto.CommentDTO;
import com.duyb1906443.entity.CommentEntity;

@Component
public class CommentConverter implements IConverterToDTO<CommentEntity, CommentDTO> {

	@Override
	public CommentDTO toDTO(CommentEntity entity) {
		CommentDTO dto = new CommentDTO();
		if(entity.getId() != null) dto.setId(entity.getId());
		dto.setClassId(entity.getClassEntity().getId());
		dto.setComment(entity.getContent());
		dto.setCreatedDate(entity.getCreatedDate());
		dto.setUserAvatar(entity.getUser().getAvatar());
		dto.setUserId(entity.getUser().getId());
		dto.setUserName(entity.getUser().getUsername());
		dto.setFullname(entity.getUser().getFullname());
		return dto;
	}

	@Override
	public List<CommentDTO> toDTOList(List<CommentEntity> entities) {
		List<CommentDTO> dtos = new ArrayList<>();
		
		for (CommentEntity commentEntity : entities) {
			dtos.add(toDTO(commentEntity));
		}
		
		return dtos;
	}

}
