package com.duyb1906443.api;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.duyb1906443.annotation.CrossOriginsList;
import com.duyb1906443.dto.ClassLessonDTO;
import com.duyb1906443.dto.FileDTO;
import com.duyb1906443.service.FileService;
import com.duyb1906443.utils.ByteToBase64;

@RestController
public class FileAPI {
	
	@Autowired
	private FileService fileService;

	@PostMapping("/api/file")
	@CrossOriginsList
	public ResponseEntity<?> uploadFileOnClassLesson(@RequestParam(name = "classLessonId") Long classLessonId,
			@RequestParam MultipartFile file) throws IOException {
		FileDTO fileDTO = new FileDTO();
		String data = Base64.encodeBase64String(file.getBytes());
		fileDTO.setData(data);
		fileDTO.setName(file.getOriginalFilename());
		fileDTO.setSize(file.getSize());
		fileDTO.setType(file.getContentType());
		fileService.uploadFileOnClassLesson(fileDTO, classLessonId);
		return ResponseEntity.status(200).body(new FileDTO());
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
