package com.duyb1906443.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.duyb1906443.annotation.CrossOriginsList;
import com.duyb1906443.dto.ClassLessonReviewDTO;
import com.duyb1906443.service.ClassLessonReviewService;

@RestController
public class ClassLessonReviewAPI {

	@Autowired
	private ClassLessonReviewService classLessonReviewService;
	
	@GetMapping("/public/api/class-lesson-review/{classLessonId}")
	@CrossOriginsList
	public ResponseEntity<ClassLessonReviewDTO> getMove(@PathVariable("classLessonId") Long classLessonId, @RequestParam("move") String move){
		ClassLessonReviewDTO dto = null;
		if(move.equals("next")) {
			dto = classLessonReviewService.findNextOne(classLessonId);
		}
		else {
			dto = classLessonReviewService.findPreviousOne(classLessonId);
		}
		if(dto != null) {
			return ResponseEntity.status(200).body(dto);
		}
		return ResponseEntity.status(500).body(dto);
	}
	
	@GetMapping("/public/api/class-lesson-review")
	@CrossOriginsList
	public ResponseEntity<List<ClassLessonReviewDTO>> getList(@RequestParam("topicId") Long id){
		return ResponseEntity.status(500).body(new ArrayList<>());
	}
	
}
