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
import com.duyb1906443.dto.CommentDTO;
import com.duyb1906443.entity.CustomUserDetails;
import com.duyb1906443.service.CommentService;

@RestController
public class CommentAPI {

	@Autowired
	private CommentService commentService;

	@GetMapping("/public/api/comment/{classLessonId}")
	@CrossOriginsList
	public ResponseEntity<List<CommentDTO>> getCommentsByClassLessonId(@PathVariable("classLessonId") Long classLessonId) {

		List<CommentDTO> dtos = commentService.findAllByLessonId(classLessonId);
		
		for (CommentDTO commentDTO : dtos) {
			System.out.println(commentDTO.getContent());
		}
		
		if (dtos != null) {
			return ResponseEntity.status(200).body(dtos);
		}

		return ResponseEntity.status(500).body(Collections.emptyList());
	}

	@PostMapping("/api/comment")
	@CrossOriginsList
	public ResponseEntity<?> postComment(@RequestBody CommentDTO commentDTO) {
		commentDTO.setId(null);
		Long userId = ((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal())
				.getUser().getId();
		commentDTO.setUserId(userId);
		CommentDTO dto = commentService.save(commentDTO);

		if (dto != null) {
			return ResponseEntity.status(200).body(dto);
		}

		return ResponseEntity.status(500).body(new CommentDTO());
	}

	@PutMapping("/api/comment")
	@CrossOriginsList
	public ResponseEntity<?> putComment(@RequestBody CommentDTO commentDTO) {
		Long userId = ((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal())
				.getUser().getId();
		commentDTO.setUserId(userId);
		CommentDTO dto = commentService.save(commentDTO);

		if (dto != null) {
			return ResponseEntity.status(200).body(dto);
		}

		return ResponseEntity.status(500).body(new CommentDTO());
	}

	@DeleteMapping("/api/comment/{classLessonId}")
	@CrossOriginsList
	public ResponseEntity<?> delete(@PathVariable("classLessonId") Long classLessonId) {
		CommentDTO dto = commentService.delete(classLessonId);

		if (dto != null) {
			return ResponseEntity.status(200).body(dto);
		}

		return ResponseEntity.status(500).body(new CommentDTO());
	}

}
