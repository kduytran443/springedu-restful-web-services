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
import com.duyb1906443.dto.ChoiceAnswerDTO;
import com.duyb1906443.dto.DrawQuizDTO;
import com.duyb1906443.service.ChoiceAnswerService;

@RestController
public class ChoiceAnswerAPI {
	
	@Autowired
	private ChoiceAnswerService choiceAnswerService;
	
	@GetMapping("/api/choice-answer/choice-question/{choiceQuestionId}")
	@CrossOriginsList
	public ResponseEntity<List<ChoiceAnswerDTO>> getChoiceAnswersByChoiceQuestion(@PathVariable("choiceQuestionId") Long choiceQuestionId) {
		List<ChoiceAnswerDTO> dtos = choiceAnswerService.findAllByChoiceQuestionId(choiceQuestionId);
		if (dtos != null) {
			return ResponseEntity.status(200).body(dtos);
		}
		return ResponseEntity.status(500).body(Collections.emptyList());
	}
	
	@GetMapping("/api/choice-answer/{choiceAnswerId}")
	@CrossOriginsList
	public ResponseEntity<ChoiceAnswerDTO> getChoiceAnswersById(@PathVariable("choiceAnswerId") Long choiceAnswerId) {
		ChoiceAnswerDTO dto = choiceAnswerService.findOneById(choiceAnswerId);
		if (dto != null) {
			return ResponseEntity.status(200).body(dto);
		}
		return ResponseEntity.status(500).body(new ChoiceAnswerDTO());
	}
	
	@PostMapping("/api/choice-answer")
	@CrossOriginsList
	public ResponseEntity<ChoiceAnswerDTO> postChoiceAnswer(@RequestBody ChoiceAnswerDTO choiceAnswerDTO) {
		choiceAnswerDTO.setId(null);
		ChoiceAnswerDTO dto = choiceAnswerService.save(choiceAnswerDTO);
		if (dto != null) {
			return ResponseEntity.status(200).body(dto);
		}
		
		return ResponseEntity.status(500).body(new ChoiceAnswerDTO());
	}
	
	@PutMapping("/api/choice-answer")
	@CrossOriginsList
	public ResponseEntity<ChoiceAnswerDTO> putChoiceAnswer(@RequestBody ChoiceAnswerDTO choiceAnswerDTO) {
		System.out.println("controller "+choiceAnswerDTO);
		ChoiceAnswerDTO dto = choiceAnswerService.save(choiceAnswerDTO);
		if (dto != null) {
			return ResponseEntity.status(200).body(dto);
		}
		return ResponseEntity.status(500).body(new ChoiceAnswerDTO());
	}
	
	@DeleteMapping("/api/choice-answer")
	@CrossOriginsList
	public ResponseEntity<ChoiceAnswerDTO> deleteChoiceAnswer(@RequestBody ChoiceAnswerDTO choiceAnswerDTO) {
		choiceAnswerService.delete(choiceAnswerDTO);
		return ResponseEntity.status(200).body(new ChoiceAnswerDTO());
	}
	
	@GetMapping("/api/choice-answer/draw-quiz/{drawQuizId}")
	@CrossOriginsList
	public ResponseEntity<List<ChoiceAnswerDTO>> getDrawQuizChoiceAnswers(@PathVariable("drawQuizId") Long drawQuizId) {
		List<ChoiceAnswerDTO> dtos = choiceAnswerService.findAllByDrawQuizId(drawQuizId);
		if (dtos != null) {
			return ResponseEntity.status(200).body(dtos);
		}
		return ResponseEntity.status(500).body(Collections.emptyList());
	}
	
}
