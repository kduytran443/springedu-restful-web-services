package com.duyb1906443.api;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.duyb1906443.annotation.CrossOriginsList;
import com.duyb1906443.dto.DrawQuizDTO;
import com.duyb1906443.service.DrawQuizService;

@RestController
public class DrawQuizAPI {
	
	@Autowired
	private DrawQuizService drawQuizService;
	
	@GetMapping("/api/draw-quiz/{submittedExerciseId}")
	@CrossOriginsList
	public ResponseEntity<List<DrawQuizDTO>> getDrawQuiz(@PathVariable("submittedExerciseId") Long submittedExerciseId) {
		List<DrawQuizDTO> dtos = drawQuizService.findAllBySubmittedExerciseId(submittedExerciseId);
		if (dtos != null) {
			return ResponseEntity.status(200).body(dtos);
		}
		return ResponseEntity.status(500).body(Collections.emptyList());
	}
	
	@GetMapping("/api/draw-quiz/answer/{drawQuizId}")
	@CrossOriginsList
	public ResponseEntity<List<DrawQuizDTO>> getDrawQuizChoiceAnswers(@PathVariable("drawQuizId") Long drawQuizId) {
		List<DrawQuizDTO> dtos = drawQuizService.findAllChoiceAnswerByDrawQuizId(drawQuizId);
		if (dtos != null) {
			return ResponseEntity.status(200).body(dtos);
		}
		return ResponseEntity.status(500).body(Collections.emptyList());
	}
	
	@PostMapping("/api/draw-quiz/answer/{choiceAnswerId}")
	@CrossOriginsList
	public ResponseEntity<DrawQuizDTO> postDrawQuizChoiceAnswer(@PathVariable("choiceAnswerId") Long choiceAnswerId, @RequestBody DrawQuizDTO drawQuizDTO) {
		DrawQuizDTO dto = drawQuizService.answerChoice(drawQuizDTO, choiceAnswerId);
		if (dto != null) {
			return ResponseEntity.status(200).body(dto);
		}
		return ResponseEntity.status(500).body(new DrawQuizDTO());
	}

	@PostMapping("/api/draw-quiz")
	@CrossOriginsList
	public ResponseEntity<List<DrawQuizDTO>> randomDrawQuiz(@RequestBody DrawQuizDTO drawQuizDTO) {
		List<DrawQuizDTO> dtos = drawQuizService.drawRandom(drawQuizDTO);
		if (dtos != null) {
			return ResponseEntity.status(200).body(dtos);
		}
		return ResponseEntity.status(500).body(Collections.emptyList());
	}

}
