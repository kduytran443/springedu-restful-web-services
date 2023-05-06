package com.duyb1906443.api;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
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
import com.duyb1906443.dto.ClassExcerciseDTO;
import com.duyb1906443.dto.FileDTO;
import com.duyb1906443.entity.CustomUserDetails;
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

	@GetMapping("/api/class-excercise/user")
	@CrossOriginsList
	public ResponseEntity<List<ClassExcerciseDTO>> getExcercisesByUser() {
		Long userId = ((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal())
				.getUser().getId();
		List<ClassExcerciseDTO> dtos = classExcerciseService.findAllByUser(userId);
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

	@PostMapping(value = "/api/class-excercise/file/{classExcerciseId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@CrossOriginsList
    public ResponseEntity<FileDTO> uploadFile(@PathVariable("classExcerciseId") Long id, @RequestParam MultipartFile file) throws IOException {
        System.out.println(String.format("File name '%s' uploaded successfully.", file.getOriginalFilename()));
        //System.out.println(ByteToBase64.byteToBase64(file));
        FileDTO fileDTO = new FileDTO();
		String data = Base64.encodeBase64String(file.getBytes());
		fileDTO.setData(data);
		fileDTO.setName(file.getOriginalFilename());
		fileDTO.setSize(file.getSize());
		fileDTO.setType(file.getContentType());
		FileDTO dto = classExcerciseService.saveFile(id, fileDTO);
		fileDTO.setId(dto.getId());
		return ResponseEntity.status(200).body(fileDTO);
    }
	
	@GetMapping("/api/class-excercise/file/{classExcerciseId}")
	@CrossOriginsList
	public ResponseEntity<?> getFiles(@PathVariable("classExcerciseId") Long id) {
		List<FileDTO> dtos = classExcerciseService.getFileList(id);
		if (dtos != null) {
			return ResponseEntity.status(200).body(dtos);
		}
		return ResponseEntity.status(200).body(Collections.emptyList());
	}

	@DeleteMapping("/api/class-excercise/file/{classExcerciseId}/{fileId}")
	@CrossOriginsList
	public ResponseEntity<?> deleteQuestionBank(@PathVariable("classExcerciseId") Long submittedExerciseId, @PathVariable("fileId") Long fileId) {
		FileDTO dto = classExcerciseService.delete(submittedExerciseId, fileId);
		if(dto != null) {
			return ResponseEntity.status(200).body(dto);			
		}
		return ResponseEntity.status(500).body(new FileDTO());
	}
	
}
