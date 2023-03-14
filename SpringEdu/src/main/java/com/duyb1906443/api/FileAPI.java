package com.duyb1906443.api;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.duyb1906443.annotation.CrossOriginsList;
import com.duyb1906443.dto.ClassLessonDTO;
import com.duyb1906443.dto.FileDTO;
import com.duyb1906443.service.FileService;

@RestController
public class FileAPI {
	
	@Autowired
	private FileService fileService;

	@PostMapping("/api/file")
	@CrossOriginsList
	public ResponseEntity<?> uploadFileOnClassLesson(@RequestParam(name = "classLessonId") Long classLessonId,
			@RequestBody FileDTO fileDTO) {
		System.out.println("classLessonId "+classLessonId);
		fileService.uploadFileOnClassLesson(fileDTO, classLessonId);
		return ResponseEntity.status(200).build();
	}

	@GetMapping("/api/file")
	@CrossOriginsList
	public ResponseEntity<?> getFileOnClassLesson(@RequestParam(name = "classLessonId") Long classLessonId) {
		List<FileDTO> dtos = fileService.findAllByClassLessonId(classLessonId);
		if(dtos!=null) {
			return ResponseEntity.status(200).body(dtos);
		}
		return ResponseEntity.status(200).body(Collections.emptyList());
	}

}
