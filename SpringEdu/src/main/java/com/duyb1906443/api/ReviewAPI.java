package com.duyb1906443.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.duyb1906443.annotation.CrossOriginsList;
import com.duyb1906443.dto.ReviewDTO;
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

}
