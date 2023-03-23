package com.duyb1906443.api;

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
import com.duyb1906443.dto.QuizDTO;
import com.duyb1906443.service.QuizService;

@RestController
public class QuizAPI {
	
	@Autowired
	private QuizService quizService;
	
	@GetMapping("/api/quiz/class-excercise/{classExcerciseId}")
	@CrossOriginsList
	public ResponseEntity<QuizDTO> getQuizByClassExcerciseId(@PathVariable("classExcerciseId") Long classExcerciseId) {
		QuizDTO dto = quizService.findOneByClassExcerciseId(classExcerciseId);
		if (dto != null) {
			return ResponseEntity.status(200).body(dto);
		}
		return ResponseEntity.status(500).body(new QuizDTO());
	}
	
	@GetMapping("/api/quiz/{id}")
	@CrossOriginsList
	public ResponseEntity<QuizDTO> getQuizById(@PathVariable("id") Long id) {
		QuizDTO dto = quizService.findOneById(id);
		if (dto != null) {
			return ResponseEntity.status(200).body(dto);
		}
		return ResponseEntity.status(500).body(new QuizDTO());
	}
	
	@PostMapping("/api/quiz")
	@CrossOriginsList
	public ResponseEntity<QuizDTO> postQuiz(@RequestBody QuizDTO quizDTO) {
		QuizDTO dto = quizService.save(quizDTO);
		if (dto != null) {
			return ResponseEntity.status(200).body(dto);
		}
		return ResponseEntity.status(500).body(new QuizDTO());
	}
	
	@PutMapping("/api/quiz")
	@CrossOriginsList
	public ResponseEntity<QuizDTO> putQuiz(@RequestBody QuizDTO quizDTO) {
		QuizDTO dto = quizService.save(quizDTO);
		if (dto != null) {
			return ResponseEntity.status(200).body(dto);
		}
		return ResponseEntity.status(500).body(new QuizDTO());
	}
	
	@DeleteMapping("/api/quiz")
	@CrossOriginsList
	public ResponseEntity<QuizDTO> deleteQuiz(@RequestBody QuizDTO quizDTO) {
		QuizDTO dto = quizService.save(quizDTO);
		if (dto != null) {
			return ResponseEntity.status(200).body(dto);
		}
		return ResponseEntity.status(500).body(new QuizDTO());
	}
	
}
