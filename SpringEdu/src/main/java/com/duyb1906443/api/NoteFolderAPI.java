package com.duyb1906443.api;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.duyb1906443.annotation.CrossOriginsList;
import com.duyb1906443.dto.NoteFolderDTO;
import com.duyb1906443.entity.CustomUserDetails;
import com.duyb1906443.service.NoteFolderService;

@RestController
public class NoteFolderAPI {
	
	@Autowired
	private NoteFolderService noteFolderService;
	
	@GetMapping("/api/note-folder/user")
	@CrossOriginsList
	public ResponseEntity<List<NoteFolderDTO>> getAll() {
		Long userId = ((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal())
				.getUser().getId();
		
		List<NoteFolderDTO> dtos = noteFolderService.findAllByUserId(userId);
		
		if (dtos != null) {
			return ResponseEntity.status(200).body(dtos);
		}

		return ResponseEntity.status(500).body(Collections.emptyList());
	}

	@GetMapping("/api/note-folder/{noteFolderId}")
	@CrossOriginsList
	public ResponseEntity<?> getOneById(@PathVariable("noteFolderId") Long noteFolderId) {
		
		NoteFolderDTO dto = noteFolderService.findOneById(noteFolderId);
		
		if (dto != null) {
			return ResponseEntity.status(200).body(dto);
		}

		return ResponseEntity.status(500).body(new Object());
	}
	
	@PostMapping("/api/note-folder")
	@CrossOriginsList
	public ResponseEntity<?> post(@RequestBody NoteFolderDTO noteFolderDTO) {
		noteFolderDTO.setId(null);
		Long userId = ((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal())
				.getUser().getId();
		noteFolderDTO.setUserId(userId);
		
		NoteFolderDTO dto = noteFolderService.save(noteFolderDTO);
		if (dto != null) {
			return ResponseEntity.status(200).body(dto);
		}
		return ResponseEntity.status(500).body(new Object());
	}

	@PutMapping("/api/note-folder")
	@CrossOriginsList
	public ResponseEntity<?> put(@RequestBody NoteFolderDTO noteFolderDTO) {
		NoteFolderDTO dto = noteFolderService.save(noteFolderDTO);
		if (dto != null) {
			return ResponseEntity.status(200).body(dto);
		}
		return ResponseEntity.status(500).body(new Object());
	}

	@DeleteMapping("/api/note-folder/{noteFolderId}")
	@CrossOriginsList
	public ResponseEntity<?> delete(@PathVariable("noteFolderId") Long noteFolderId) {
		NoteFolderDTO dto = noteFolderService.delete(noteFolderId);
		if (dto != null) {
			return ResponseEntity.status(200).body(dto);
		}
		return ResponseEntity.status(500).body(new Object());
	}
}
