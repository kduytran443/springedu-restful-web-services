package com.duyb1906443.api;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.duyb1906443.annotation.CrossOriginsList;
import com.duyb1906443.dto.NoteDTO;
import com.duyb1906443.service.NoteService;

@RestController
public class NoteAPI {
	
	@Autowired
	private NoteService noteService;
	
	@GetMapping("/api/note/note-folder/{noteFolderId}")
	@CrossOriginsList
	public ResponseEntity<List<NoteDTO>> getAllByNoteFolderId(@PathVariable("noteFolderId") Long noteFolderId) {
		List<NoteDTO> dtos = noteService.findAllByNoteFolderId(noteFolderId);
		if (dtos != null) {
			return ResponseEntity.status(200).body(dtos);
		}
		return ResponseEntity.status(500).body(Collections.emptyList());
	}
	
	@GetMapping("/api/note/{noteId}")
	@CrossOriginsList
	public ResponseEntity<?> getByNoteId(@PathVariable("noteId") Long noteId) {
		NoteDTO dto = noteService.findOneById(noteId);
		if (dto != null) {
			return ResponseEntity.status(200).body(dto);
		}
		return ResponseEntity.status(500).body(new Object());
	}
	
	@PostMapping("/api/note")
	@CrossOriginsList
	public ResponseEntity<?> post(@RequestBody NoteDTO noteDTO) {
		noteDTO.setId(null);
		NoteDTO dto = noteService.save(noteDTO);
		if (dto != null) {
			return ResponseEntity.status(200).body(dto);
		}
		return ResponseEntity.status(500).body(new Object());
	}
	
	@PutMapping("/api/note")
	@CrossOriginsList
	public ResponseEntity<?> put(@RequestBody NoteDTO noteDTO) {
		NoteDTO dto = noteService.save(noteDTO);
		if (dto != null) {
			return ResponseEntity.status(200).body(dto);
		}
		return ResponseEntity.status(500).body(new Object());
	}

	@DeleteMapping("/api/note/{noteId}")
	@CrossOriginsList
	public ResponseEntity<?> delete(@PathVariable("noteId") Long noteId) {
		NoteDTO dto = noteService.delete(noteId);
		if (dto != null) {
			return ResponseEntity.status(200).body(dto);
		}
		return ResponseEntity.status(500).body(new Object());
	}
	
}
