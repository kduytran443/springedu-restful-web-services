package com.duyb1906443.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.duyb1906443.dto.NoteDTO;
import com.duyb1906443.entity.NoteEntity;

@Component
public class NoteConverter implements IConverterToDTO<NoteEntity, NoteDTO>, IConverterToEntity<NoteEntity, NoteDTO> {
	
	@Autowired
	private NoteFolderConverter noteFolderConverter;
	
	@Override
	public NoteDTO toDTO(NoteEntity entity) {
		NoteDTO dto = new NoteDTO();
		
		dto.setContent(entity.getContent());
		dto.setCreatedDate(entity.getCreatedDate());
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		if(entity.getNoteFolder() != null) {
			dto.setNoteFolder(noteFolderConverter.toDTO(entity.getNoteFolder()));			
		}
		dto.setPrivateMode(entity.getPrivateMode());
		dto.setModifiedDate(entity.getModifiedDate());
		
		if(entity.getNoteFolder().getUser() != null) {
			dto.setUserAvatar(entity.getNoteFolder().getUser().getAvatar());
			dto.setUserFullname(entity.getNoteFolder().getUser().getFullname());
			dto.setUserId(entity.getNoteFolder().getUser().getId());
			dto.setUsername(entity.getNoteFolder().getUser().getUsername());
		}
		
		return dto;
	}

	@Override
	public List<NoteDTO> toDTOList(List<NoteEntity> entities) {
		return entities.stream().map(item -> toDTO(item)).collect(Collectors.toList());
	}

	@Override
	public NoteEntity toEntity(NoteDTO dto) {
		NoteEntity entity = new NoteEntity();
		
		if(dto.getContent() != null) {
			entity.setContent(dto.getContent());			
		}
		if(dto.getCreatedDate() != null) {
			entity.setCreatedDate(dto.getCreatedDate());			
		}
		if(dto.getId() != null) {
			entity.setId(dto.getId());			
		}
		if(dto.getName() != null) {
			entity.setName(dto.getName());			
		}
		if(dto.getPrivateMode() != null) {
			entity.setPrivateMode(dto.getPrivateMode());
		}
		
		return entity;
	}
	public NoteEntity toEntity(NoteDTO dto, NoteEntity entity) {
		
		if(dto.getContent() != null) {
			entity.setContent(dto.getContent());			
		}
		if(dto.getCreatedDate() != null) {
			entity.setCreatedDate(dto.getCreatedDate());			
		}
		if(dto.getId() != null) {
			entity.setId(dto.getId());			
		}
		if(dto.getName() != null) {
			entity.setName(dto.getName());			
		}
		if(dto.getPrivateMode() != null) {
			entity.setPrivateMode(dto.getPrivateMode());
		}
		
		return entity;
	}

	@Override
	public List<NoteEntity> toEntityList(List<NoteDTO> dtos) {
		return dtos.stream().map(item -> toEntity(item)).collect(Collectors.toList());
	}

}
