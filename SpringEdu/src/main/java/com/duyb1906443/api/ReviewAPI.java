package com.duyb1906443.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.duyb1906443.annotation.CrossOriginsList;
import com.duyb1906443.dto.ReviewDTO;
import com.duyb1906443.dto.TopicDTO;
import com.duyb1906443.entity.CustomUserDetails;
import com.duyb1906443.service.ReviewService;

@RestController
public class ReviewAPI {

	@Autowired
	private ReviewService reviewService;

	@GetMapping("/public/api/review/{classId}")
	@CrossOriginsList
	public ResponseEntity<List<ReviewDTO>> getClassReviewCardDTOs(@PathVariable("classId") Long classId) {
		return ResponseEntity.status(200).body(reviewService.findAllByClassId(classId));
	}

	@GetMapping("/api/review/user-class/{classId}")
	@CrossOriginsList
	public ResponseEntity<ReviewDTO> getReviewByUserAndClass(@PathVariable("classId") Long classId){
		ReviewDTO reviewDTO = new ReviewDTO();
		reviewDTO.setClassId(classId);
		Long userId = ((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser().getId();
		reviewDTO.setUserId(userId);
		ReviewDTO dto = reviewService.getReviewByUserAndClass(reviewDTO);
		if(dto != null) {
			return ResponseEntity.status(200).body(dto);
		}
		return ResponseEntity.status(500).body(dto);
	}

	@PostMapping("/api/review")
	@CrossOriginsList
	public ResponseEntity<ReviewDTO> createReview(@RequestBody ReviewDTO reviewDTO){
		Long userId = ((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser().getId();
		reviewDTO.setUserId(userId);
		ReviewDTO dto = reviewService.createReview(reviewDTO);
		if(dto != null) {
			return ResponseEntity.status(200).body(dto);
		}
		return ResponseEntity.status(500).body(dto);
	}

	@PutMapping("/api/review")
	@CrossOriginsList
	public ResponseEntity<ReviewDTO> putReview(@RequestBody ReviewDTO reviewDTO){
		ReviewDTO dto = reviewService.editReview(reviewDTO);
		if(dto != null) {
			return ResponseEntity.status(200).body(dto);
		}
		return ResponseEntity.status(500).body(dto);
	}
	
}
