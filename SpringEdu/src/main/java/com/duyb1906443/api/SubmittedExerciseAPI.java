package com.duyb1906443.api;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.Path;

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
import com.duyb1906443.dto.ScoreDTO;
import com.duyb1906443.dto.SubmittedExerciseDTO;
import com.duyb1906443.entity.CustomUserDetails;
import com.duyb1906443.service.SubmittedExerciseService;

@RestController
public class SubmittedExerciseAPI {

	@Autowired
	private SubmittedExerciseService submittedExerciseService;

	@GetMapping("/api/submitted-exercise/class-exercise/{classExerciseId}")
	@CrossOriginsList
	public ResponseEntity<?> getSubmittedExercisesByClassExerciseId(@PathVariable("classExerciseId") Long classExerciseId) {
		List<SubmittedExerciseDTO> dtos = submittedExerciseService.findAllByClassExcercise(classExerciseId);
		if (dtos != null) {
			return ResponseEntity.status(200).body(dtos);
		}
		return ResponseEntity.status(200).body(Collections.emptyList());
	}

	@GetMapping("/api/submitted-exercise/class/user/{classId}")
	@CrossOriginsList
	public ResponseEntity<?> getSubmittedExercisesByUserAndClassId(@PathVariable("classId") Long classExerciseId) {
		Long userId = ((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal())
				.getUser().getId();
		List<SubmittedExerciseDTO> dtos = submittedExerciseService.findAllByClassIdAndUserId(classExerciseId, userId);
		if (dtos != null) {
			return ResponseEntity.status(200).body(dtos);
		}
		return ResponseEntity.status(200).body(Collections.emptyList());
	}

	@GetMapping("/api/submitted-exercise/{submittedExerciseId}")
	@CrossOriginsList
	public ResponseEntity<?> getSubmittedExerciseById(@PathVariable("submittedExerciseId") Long id) {
		SubmittedExerciseDTO dto = submittedExerciseService.findOneById(id);
		if (dto != null) {
			return ResponseEntity.status(200).body(dto);
		}
		return ResponseEntity.status(200).body(new SubmittedExerciseDTO());
	}

	@GetMapping("/api/submitted-exercise/class-exercise/user/{classExerciseId}")
	@CrossOriginsList
	public ResponseEntity<?> getSubmittedExercisesByClassExerciseIdAndUserId(
			@PathVariable("classExerciseId") Long classExerciseId) {
		Long userId = ((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal())
				.getUser().getId();
		List<SubmittedExerciseDTO> dtos = submittedExerciseService.findAllByClassExerciseIdAndUserId(classExerciseId,
				userId);
		if (dtos != null) {
			return ResponseEntity.status(200).body(dtos);
		}
		return ResponseEntity.status(200).body(Collections.emptyList());
	}

	@PostMapping("/api/submitted-exercise")
	@CrossOriginsList
	public ResponseEntity<?> postSubmittedExercises(@RequestBody SubmittedExerciseDTO submittedExerciseDTO) {
		Long userId = ((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal())
				.getUser().getId();
		submittedExerciseDTO.setUserId(userId);
		SubmittedExerciseDTO dto = submittedExerciseService.save(submittedExerciseDTO);
		if (dto != null) {
			return ResponseEntity.status(200).body(dto);
		}
		return ResponseEntity.status(500).body(new SubmittedExerciseDTO());
	}

	@PostMapping("/api/submitted-exercise/submit")
	@CrossOriginsList
	public ResponseEntity<?> submit(@RequestBody SubmittedExerciseDTO submittedExerciseDTO) {
		SubmittedExerciseDTO dto = submittedExerciseService.submit(submittedExerciseDTO);
		if (dto != null) {
			return ResponseEntity.status(200).body(dto);
		}
		return ResponseEntity.status(500).body(new SubmittedExerciseDTO());
	}

	@PutMapping("/api/submitted-exercise")
	@CrossOriginsList
	public ResponseEntity<?> putSubmittedExercises(@RequestBody SubmittedExerciseDTO submittedExerciseDTO) {
		Long userId = ((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal())
				.getUser().getId();
		submittedExerciseDTO.setUserId(userId);
		SubmittedExerciseDTO dto = submittedExerciseService.save(submittedExerciseDTO);
		if (dto != null) {
			return ResponseEntity.status(200).body(dto);
		}
		return ResponseEntity.status(500).body(new SubmittedExerciseDTO());
	}

	@PutMapping("/api/submitted-exercise/grade")
	@CrossOriginsList
	public ResponseEntity<?> grade(@RequestBody ScoreDTO scoreDTO) {
		SubmittedExerciseDTO dto = submittedExerciseService.grade(scoreDTO);
		if (dto != null) {
			return ResponseEntity.status(200).body(dto);
		}
		return ResponseEntity.status(500).body(new SubmittedExerciseDTO());
	}

}
