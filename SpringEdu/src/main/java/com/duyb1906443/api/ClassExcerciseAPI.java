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
import com.duyb1906443.dto.ClassExcerciseDTO;
import com.duyb1906443.service.ClassExcerciseService;

@RestController
public class ClassExcerciseAPI {

	@Autowired
	private ClassExcerciseService classExcerciseService;

	@GetMapping("/api/class-excercise/class/{classId}")
	@CrossOriginsList
	public ResponseEntity<List<ClassExcerciseDTO>> getExcercisesByClass(@PathVariable("classId") Long classId) {
		List<ClassExcerciseDTO> dtos = classExcerciseService.findAllByClassId(classId);
		if (dtos != null) {
			return ResponseEntity.status(200).body(dtos);
		}
		return ResponseEntity.status(500).body(Collections.emptyList());
	}

	@GetMapping("/api/class-excercise/{classExcerciseId}")
	@CrossOriginsList
	public ResponseEntity<ClassExcerciseDTO> getExcerciseById(@PathVariable("classExcerciseId") Long classExcerciseId) {
		ClassExcerciseDTO dto = classExcerciseService.findOneById(classExcerciseId);
		if (dto != null) {
			return ResponseEntity.status(200).body(dto);
		}
		return ResponseEntity.status(500).body(new ClassExcerciseDTO());
	}

	@PostMapping("/api/class-excercise")
	@CrossOriginsList
	public ResponseEntity<ClassExcerciseDTO> postExcercise(@RequestBody ClassExcerciseDTO classExcerciseDTO) {
		classExcerciseDTO.setId(null);
		ClassExcerciseDTO dto = classExcerciseService.save(classExcerciseDTO);
		if (dto != null) {
			return ResponseEntity.status(200).body(dto);
		}
		return ResponseEntity.status(500).body(new ClassExcerciseDTO());
	}

	@PutMapping("/api/class-excercise")
	@CrossOriginsList
	public ResponseEntity<ClassExcerciseDTO> putExcercise(@RequestBody ClassExcerciseDTO classExcerciseDTO) {
		ClassExcerciseDTO dto = classExcerciseService.save(classExcerciseDTO);
		if (dto != null) {
			return ResponseEntity.status(200).body(dto);
		}
		return ResponseEntity.status(500).body(new ClassExcerciseDTO());
	}

	@DeleteMapping("/api/class-excercise")
	@CrossOriginsList
	public ResponseEntity<ClassExcerciseDTO> deleteExcercise(@RequestBody ClassExcerciseDTO classExcerciseDTO) {
		classExcerciseService.delete(classExcerciseDTO);

		return ResponseEntity.status(200).body(new ClassExcerciseDTO());
	}

}
