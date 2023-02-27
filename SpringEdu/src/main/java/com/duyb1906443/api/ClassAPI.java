package com.duyb1906443.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.duyb1906443.annotation.CrossOriginsList;
import com.duyb1906443.dto.ClassIntroDTO;
import com.duyb1906443.dto.ClassReviewCardDTO;
import com.duyb1906443.service.ClassIntroService;
import com.duyb1906443.service.ClassReviewCardService;

@RestController
public class ClassAPI {
	
	@Autowired
	private ClassReviewCardService classReviewCardService;

	@Autowired
	private ClassIntroService classIntroService;
	
	@GetMapping("/public/api/class-review")
	@CrossOriginsList
	public ResponseEntity<List<ClassReviewCardDTO>> getClassReviewCards(){
		return ResponseEntity.status(200).body(classReviewCardService.findAll());
	}
	
	@GetMapping("/public/api/class-review/{categoryCode}")
	@CrossOriginsList
	public ResponseEntity<List<ClassReviewCardDTO>> getClassReviewCards(@PathVariable("categoryCode") String categoryCode){
		return ResponseEntity.status(200).body(classReviewCardService.findAllByCategoryCode(categoryCode));
	}
	
	@GetMapping("/public/api/class-intro/{classId}")
	@CrossOriginsList
	public ResponseEntity<ClassIntroDTO> getClassReviewCardDTOs(@PathVariable("classId") Long classId){
		return ResponseEntity.status(200).body(classIntroService.findOneByClassId(classId));
	}
	
}
