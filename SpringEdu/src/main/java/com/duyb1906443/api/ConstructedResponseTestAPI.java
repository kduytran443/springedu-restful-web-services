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
import com.duyb1906443.dto.ConstructedResponseTestDTO;
import com.duyb1906443.service.ConstructedResponseTestService;

@RestController
public class ConstructedResponseTestAPI {

	@Autowired
	private ConstructedResponseTestService constructedResponseTestService;

	@GetMapping("/api/constructed-response-test/class-excercise/{classExcerciseId}")
	@CrossOriginsList
	public ResponseEntity<ConstructedResponseTestDTO> getConstructedResponseTestByClassExcerciseId(
			@PathVariable("classExcerciseId") Long classExcerciseId) {
		ConstructedResponseTestDTO dto = constructedResponseTestService.findOneByClassExcerciseId(classExcerciseId);
		if (dto != null) {
			return ResponseEntity.status(200).body(dto);
		}
		return ResponseEntity.status(500).body(new ConstructedResponseTestDTO());
	}

	@GetMapping("/api/constructed-response-test/{id}")
	@CrossOriginsList
	public ResponseEntity<ConstructedResponseTestDTO> getConstructedResponseTestById(@PathVariable("id") Long id) {
		ConstructedResponseTestDTO dto = constructedResponseTestService.findOneByClassExcerciseId(id);
		if (dto != null) {
			return ResponseEntity.status(200).body(dto);
		}
		return ResponseEntity.status(500).body(new ConstructedResponseTestDTO());
	}

	@PostMapping("/api/constructed-response-test")
	@CrossOriginsList
	public ResponseEntity<ConstructedResponseTestDTO> postConstructedResponseTest(
			@RequestBody ConstructedResponseTestDTO constructedResponseTestDTO) {
		ConstructedResponseTestDTO dto = constructedResponseTestService.save(constructedResponseTestDTO);

		if (dto != null) {
			return ResponseEntity.status(200).body(dto);
		}
		return ResponseEntity.status(500).body(new ConstructedResponseTestDTO());

	}

	@PutMapping("/api/constructed-response-test")
	@CrossOriginsList
	public ResponseEntity<ConstructedResponseTestDTO> putConstructedResponseTest(
			@RequestBody ConstructedResponseTestDTO constructedResponseTestDTO) {
		ConstructedResponseTestDTO dto = constructedResponseTestService.save(constructedResponseTestDTO);
		if (dto != null) {
			return ResponseEntity.status(200).body(dto);
		}
		return ResponseEntity.status(500).body(new ConstructedResponseTestDTO());
	}

	@DeleteMapping("/api/constructed-response-test")
	@CrossOriginsList
	public ResponseEntity<ConstructedResponseTestDTO> deleteConstructedResponseTest(
			@RequestBody ConstructedResponseTestDTO constructedResponseTestDTO) {
		constructedResponseTestService.delete(constructedResponseTestDTO);
		return ResponseEntity.status(200).body(new ConstructedResponseTestDTO());
	}

}
