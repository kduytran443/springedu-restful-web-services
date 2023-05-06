package com.duyb1906443.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duyb1906443.converter.NoteConverter;
import com.duyb1906443.dto.NoteDTO;
import com.duyb1906443.entity.NoteEntity;
import com.duyb1906443.entity.NoteFolderEntity;
import com.duyb1906443.repository.NoteFolderRepository;
import com.duyb1906443.repository.NoteRepository;
import com.duyb1906443.service.NoteService;

@Service
public class NoteServiceImpl implements NoteService {
	
	@Autowired
	private NoteFolderRepository noteFolderRepository;
	
	@Autowired
	private NoteRepository noteRepository;
	
	@Autowired
	private NoteConverter noteConverter;
	
	@Override
	public List<NoteDTO> findAllByNoteFolderId(Long noteFolderId) {
		NoteFolderEntity noteFolderEntity = noteFolderRepository.findOne(noteFolderId);
		
		List<NoteEntity> noteEntities = noteFolderEntity.getNotes().stream().map(item -> {
			item.setContent("");
			return item;
		}).collect(Collectors.toList());
		
		if(noteEntities != null) {
			return noteConverter.toDTOList(noteEntities);
		}
		
		return null;
	}

	@Override
	public NoteDTO findOneById(Long id) {
		NoteEntity noteEntity = noteRepository.findOne(id);
		if(noteEntity != null) {
			return noteConverter.toDTO(noteEntity);
		}
		return null;
	}

	@Override
	public NoteDTO save(NoteDTO noteDTO) {
		NoteEntity noteEntity = null;
		
		if(noteDTO.getId() != null) {
			noteEntity = noteRepository.findOne(noteDTO.getId());
			noteEntity = noteConverter.toEntity(noteDTO, noteEntity);
			Date date = new Date();
			noteEntity.setModifiedDate(new Timestamp(date.getTime()));
		}
		else {
			noteEntity = noteConverter.toEntity(noteDTO);
			Date date = new Date();
			noteEntity.setCreatedDate(new Timestamp(date.getTime()));
			noteEntity.setPrivateMode(1);
			NoteFolderEntity noteFolderEntity = noteFolderRepository.findOne(noteDTO.getNoteFolder().getId());
			noteEntity.setNoteFolder(noteFolderEntity);
		}
		
		if(noteEntity != null) {
			noteEntity = noteRepository.save(noteEntity);
			NoteDTO dto = noteConverter.toDTO(noteEntity);
			dto.setContent("");
			return dto;
		}
		
		return null;
	}

	@Override
	public NoteDTO delete(Long id) {
		NoteEntity noteEntity = noteRepository.findOne(id);
		NoteDTO noteDTO = noteConverter.toDTO(noteEntity);
		noteDTO.setContent("");
		noteRepository.delete(noteEntity);
		return noteDTO;
	}

}
