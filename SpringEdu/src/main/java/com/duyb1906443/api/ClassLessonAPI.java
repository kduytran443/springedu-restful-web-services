package com.duyb1906443.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.duyb1906443.annotation.CrossOriginsList;
import com.duyb1906443.dto.ClassLessonDTO;
import com.duyb1906443.service.ClassLessonService;

@RestController
public class ClassLessonAPI {
	
	@Autowired
	private ClassLessonService classLessonService;
	
	/* Nho xoa public vi day la API cho Hoc Vien */
	@GetMapping("/public/api/class-lesson/{classLessonId}")
	@CrossOriginsList
	public ResponseEntity<ClassLessonDTO> getTopics(@PathVariable("classLessonId") Long classLessonId){
		ClassLessonDTO dto = classLessonService.findOne(classLessonId);
		if(dto != null) {
			return ResponseEntity.status(200).body(dto);
		}
		return ResponseEntity.status(500).body(dto);
	}
	
}
