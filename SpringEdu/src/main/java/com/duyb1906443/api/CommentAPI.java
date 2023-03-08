package com.duyb1906443.api;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.duyb1906443.annotation.CrossOriginsList;
import com.duyb1906443.dto.CommentDTO;
import com.duyb1906443.service.CommentService;

@RestController
public class CommentAPI {

	@Autowired
	private CommentService commentService;

	@GetMapping("/public/api/comment/{classId}")
	@CrossOriginsList
	public ResponseEntity<List<CommentDTO>> getClassReviewCards(@PathVariable("classId") Long classId) {

		List<CommentDTO> dtos = commentService.findAllByClassId(classId);
		if (dtos != null) {
			return ResponseEntity.status(200).body(dtos);
		}

		return ResponseEntity.status(500).body(Collections.emptyList());
	}

	@PostMapping("/api/comment")
	@CrossOriginsList
	public ResponseEntity<?> postComment(@RequestBody CommentDTO commentDTO) {
		commentDTO.setId(null);
		CommentDTO dto = commentService.save(commentDTO);

		if (dto != null) {
			return ResponseEntity.status(200).body(dto);
		}

		return ResponseEntity.status(500).build();
	}

	@PutMapping("/api/comment")
	@CrossOriginsList
	public ResponseEntity<?> putComment(@RequestBody CommentDTO commentDTO) {
		CommentDTO dto = commentService.save(commentDTO);

		if (dto != null) {
			return ResponseEntity.status(200).body(dto);
		}

		return ResponseEntity.status(500).build();
	}

}
