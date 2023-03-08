package com.duyb1906443.api;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.duyb1906443.annotation.CrossOriginsList;
import com.duyb1906443.dto.QuestionBankDTO;
import com.duyb1906443.entity.CustomUserDetails;
import com.duyb1906443.service.QuestionBankService;

@RestController
public class QuestionBankAPI {

	@Autowired
	private QuestionBankService questionBankService;

	@GetMapping("/api/question-bank")
	@CrossOriginsList
	public ResponseEntity<?> getQuestionBanks() {
		Long userId = ((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal())
				.getUser().getId();

		List<QuestionBankDTO> dtos = questionBankService.findAllByUserId(userId);

		if (dtos != null) {
			return ResponseEntity.status(200).body(dtos);
		}
		return ResponseEntity.status(200).body(Collections.emptyList());
	}

	@PostMapping("/api/question-bank")
	@CrossOriginsList
	public ResponseEntity<?> postQuestionBank(@RequestBody QuestionBankDTO questionBankDTO) {
		Long userId = ((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal())
				.getUser().getId();
		questionBankDTO.setId(null);
		QuestionBankDTO dto = questionBankService.save(questionBankDTO, userId);
		
		if (dto != null) {
			return ResponseEntity.status(200).body(dto);
		}
		return ResponseEntity.status(500).build();
	}

	@PutMapping("/api/question-bank")
	@CrossOriginsList
	public ResponseEntity<?> putQuestionBank(@RequestBody QuestionBankDTO questionBankDTO) {
		Long userId = ((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal())
				.getUser().getId();
		QuestionBankDTO dto = questionBankService.save(questionBankDTO, userId);
		
		if (dto != null) {
			return ResponseEntity.status(200).body(dto);
		}
		return ResponseEntity.status(500).build();
	}

}
