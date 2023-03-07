package com.duyb1906443.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<ClassLessonDTO> uploadFileOnClassLesson(@RequestParam(name = "classLessonId") Long classLessonId,
			@RequestBody FileDTO fileDTO) {
		fileService.uploadFileOnClassLesson(fileDTO, classLessonId);
		return ResponseEntity.status(200).build();
	}

}
