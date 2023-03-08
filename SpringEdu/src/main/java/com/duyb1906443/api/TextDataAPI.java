package com.duyb1906443.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.duyb1906443.annotation.CrossOriginsList;
import com.duyb1906443.dto.TextDataDTO;
import com.duyb1906443.service.TextDataService;

@RestController
public class TextDataAPI {

	@Autowired
	private TextDataService textDataService;

	@GetMapping("/api/text-data")
	@CrossOriginsList
	public ResponseEntity<TextDataDTO> getTextData(@RequestParam(name = "classLessonId", required = false) Long classLessonId,
			@RequestParam(name = "classId", required = false) Long classId) {
		TextDataDTO dto = null;
		if (classLessonId != null) {
			dto = textDataService.findOneByClassLessonId(classLessonId);
		} else if (classId != null) {
			dto = textDataService.findOneByClassId(classId);
		}

		if (dto != null) {
			return ResponseEntity.status(200).body(dto);
		}
		return ResponseEntity.status(500).build();
	}

	@PostMapping("/api/text-data")
	@CrossOriginsList
	public ResponseEntity<TextDataDTO> postTextData(@RequestParam(name = "classLessonId", required = false) Long classLessonId,
			@RequestParam(name = "classId", required = false) Long classId, @RequestBody TextDataDTO textDataDTO) {
		TextDataDTO dto = null;
		textDataDTO.setId(null);
		if (classLessonId != null) {
			dto = textDataService.saveOnClassLesson(textDataDTO, classLessonId);
		} else if (classId != null) {
			dto = textDataService.saveOnClassLesson(textDataDTO, classId);
		}

		if (dto != null) {
			return ResponseEntity.status(200).body(dto);
		}
		return ResponseEntity.status(500).build();
	}

	@PutMapping("/api/text-data")
	@CrossOriginsList
	public ResponseEntity<TextDataDTO> putTextData(@RequestParam(name = "classLessonId", required = false) Long classLessonId,
			@RequestParam(name = "classId", required = false) Long classId, @RequestBody TextDataDTO textDataDTO) {
		TextDataDTO dto = null;
		if (classLessonId != null) {
			dto = textDataService.saveOnClassLesson(textDataDTO, classLessonId);
		} else if (classId != null) {
			dto = textDataService.saveOnClassLesson(textDataDTO, classId);
		}

		if (dto != null) {
			return ResponseEntity.status(200).body(dto);
		}
		return ResponseEntity.status(500).build();
	}
	
}
