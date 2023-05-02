package com.duyb1906443.service;

import java.util.List;

import com.duyb1906443.dto.NoteDTO;

public interface NoteService {
	List<NoteDTO> findAllByNoteFolderId(Long noteFolderId);
	NoteDTO findOneById(Long id);
	NoteDTO save(NoteDTO noteDTO);
	NoteDTO delete(Long id);
}
