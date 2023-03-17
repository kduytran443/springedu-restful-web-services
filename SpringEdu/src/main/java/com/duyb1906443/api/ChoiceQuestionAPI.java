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
import com.duyb1906443.dto.ChoiceQuestionDTO;
import com.duyb1906443.service.ChoiceQuestionService;

@RestController
public class ChoiceQuestionAPI {

	@Autowired
	private ChoiceQuestionService choiceQuestionService;

	@GetMapping("/api/choice-question/question-bank/{questionBankId}")
	@CrossOriginsList
	public ResponseEntity<List<ChoiceQuestionDTO>> getChoiceQuestionsByQuestionBank(
			@PathVariable("questionBankId") Long questionBankId) {
		List<ChoiceQuestionDTO> dtos = choiceQuestionService.findAllByQuestionBankId(questionBankId);
		if (dtos != null) {
			return ResponseEntity.status(200).body(dtos);
		}
		return ResponseEntity.status(500).body(Collections.emptyList());
	}
	
	@GetMapping("/api/choice-question/{choiceQuestionId}")
	@CrossOriginsList
	public ResponseEntity<ChoiceQuestionDTO> getChoiceQuestionById(
			@PathVariable("choiceQuestionId") Long choiceQuestionId) {
		ChoiceQuestionDTO dto = choiceQuestionService.findOneById(choiceQuestionId);
		if (dto != null) {
			return ResponseEntity.status(200).body(dto);
		}
		return ResponseEntity.status(500).body(new ChoiceQuestionDTO());
	}

	@PostMapping("/api/choice-question")
	@CrossOriginsList
	public ResponseEntity<ChoiceQuestionDTO> postChoiceQuestion(@RequestBody ChoiceQuestionDTO choiceQuestionDTO) {
		choiceQuestionDTO.setId(null);
		ChoiceQuestionDTO dto = choiceQuestionService.save(choiceQuestionDTO);
		if (dto != null) {
			return ResponseEntity.status(200).body(dto);
		}
		return ResponseEntity.status(500).body(new ChoiceQuestionDTO());
	}

	@PutMapping("/api/choice-question")
	@CrossOriginsList
	public ResponseEntity<ChoiceQuestionDTO> putChoiceQuestion(@RequestBody ChoiceQuestionDTO choiceQuestionDTO) {
		ChoiceQuestionDTO dto = choiceQuestionService.save(choiceQuestionDTO);
		if (dto != null) {
			return ResponseEntity.status(200).body(dto);
		}
		return ResponseEntity.status(500).body(new ChoiceQuestionDTO());
	}

	@DeleteMapping("/api/choice-question")
	@CrossOriginsList
	public ResponseEntity<ChoiceQuestionDTO> deleteChoiceQuestion(@RequestBody ChoiceQuestionDTO choiceQuestionDTO) {
		choiceQuestionService.delete(choiceQuestionDTO);

		return ResponseEntity.status(200).body(new ChoiceQuestionDTO());
	}

}
