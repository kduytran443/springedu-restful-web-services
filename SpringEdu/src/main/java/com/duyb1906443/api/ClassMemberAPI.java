package com.duyb1906443.api;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.duyb1906443.annotation.CrossOriginsList;
import com.duyb1906443.dto.ClassMemberDTO;
import com.duyb1906443.service.ClassMemberService;

@RestController
public class ClassMemberAPI {
	
	@Autowired
	private ClassMemberService classMemberService;
	
	@GetMapping("/public/api/class-member")
	@CrossOriginsList
	public ResponseEntity<List<ClassMemberDTO>> getClassMembersByClassId(@RequestParam("classId") Long classId){
		List<ClassMemberDTO> classMembers = classMemberService.findAllByClassId(classId);
		if(classMembers != null) {
			return ResponseEntity.status(200).body(classMembers);
		}
		return ResponseEntity.status(200).body(Collections.emptyList());
	}
	
}
