package com.duyb1906443.api;


import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.duyb1906443.annotation.CrossOriginsList;
import com.duyb1906443.dto.ClassLessonDTO;
import com.duyb1906443.dto.FileDTO;
import com.duyb1906443.service.ClassLessonService;
import com.duyb1906443.utils.ByteToBase64;

@RestController
public class ClassLessonAPI {

	@Autowired
	private ClassLessonService classLessonService;

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
		return ResponseEntity.status(200).body(new ClassLessonDTO());
	}

	@PostMapping(value = "/api/class-lesson/file/{classLessonId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@CrossOriginsList
    public ResponseEntity<FileDTO> uploadFile(@PathVariable("classLessonId") Long id, @RequestParam MultipartFile file) throws IOException {
        System.out.println(String.format("File name '%s' uploaded successfully.", file.getOriginalFilename()));
        //System.out.println(ByteToBase64.byteToBase64(file));
        FileDTO fileDTO = new FileDTO();
		
        String data = Base64.encodeBase64String(file.getBytes());
		fileDTO.setData(data);
		fileDTO.setName(file.getOriginalFilename());
		fileDTO.setSize(file.getSize());
		fileDTO.setType(file.getContentType());
		FileDTO dto = classLessonService.saveFile(id, fileDTO);
		fileDTO.setId(dto.getId());
		return ResponseEntity.status(200).body(fileDTO);
    }
	
	@GetMapping("/api/class-lesson/file/{classLessonId}")
	@CrossOriginsList
	public ResponseEntity<?> getFiles(@PathVariable("classLessonId") Long id) {
		List<FileDTO> dtos = classLessonService.getFileList(id);
		if (dtos != null) {
			return ResponseEntity.status(200).body(dtos);
		}
		return ResponseEntity.status(200).body(Collections.emptyList());
	}

	@DeleteMapping("/api/class-lesson/file/{classLessonId}/{fileId}")
	@CrossOriginsList
	public ResponseEntity<?> deleteQuestionBank(@PathVariable("classLessonId") Long submittedExerciseId, @PathVariable("fileId") Long fileId) {
		FileDTO dto = classLessonService.delete(submittedExerciseId, fileId);
		if(dto != null) {
			return ResponseEntity.status(200).body(dto);
		}
		return ResponseEntity.status(500).body(new FileDTO());
	}
	
}
