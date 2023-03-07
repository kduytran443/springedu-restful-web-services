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
import com.duyb1906443.dto.ClassLessonDTO;
import com.duyb1906443.service.ClassLessonService;

@RestController
public class ClassLessonAPI {

	@Autowired
	private ClassLessonService classLessonService;

	/* Nho xoa public vi day la API cho Hoc Vien */
	@GetMapping("/api/class-lesson/{classLessonId}")
	@CrossOriginsList
	public ResponseEntity<ClassLessonDTO> getLessons(@PathVariable("classLessonId") Long classLessonId) {
		ClassLessonDTO dto = classLessonService.findOne(classLessonId);
		if (dto != null) {
			return ResponseEntity.status(200).body(dto);
		}
		return ResponseEntity.status(500).body(dto);
	}
	
	@PostMapping("/api/class-lesson")
	@CrossOriginsList
	public ResponseEntity<ClassLessonDTO> postLesson(@RequestBody ClassLessonDTO classLessonDTO){
		classLessonDTO.setId(null);
		ClassLessonDTO dto = classLessonService.save(classLessonDTO);
		if(dto != null) {
			return ResponseEntity.status(200).body(dto);
		}
		return ResponseEntity.status(500).body(dto);
	}
	
	@PutMapping("/api/class-lesson")
	@CrossOriginsList
	public ResponseEntity<ClassLessonDTO> putLesson(@RequestBody ClassLessonDTO classLessonDTO){
		ClassLessonDTO dto = classLessonService.save(classLessonDTO);
		if(dto != null) {
			return ResponseEntity.status(200).body(dto);
		}
		return ResponseEntity.status(500).body(dto);
	}
	
	@DeleteMapping("/api/class-lesson")
	@CrossOriginsList
	public ResponseEntity<?> deleteLesson(@RequestBody ClassLessonDTO classLessonDTO){
		classLessonService.delete(classLessonDTO.getId());
		return ResponseEntity.status(200).build();
	}

}
