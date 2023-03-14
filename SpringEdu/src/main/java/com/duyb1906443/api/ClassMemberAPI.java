package com.duyb1906443.api;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.duyb1906443.annotation.CrossOriginsList;
import com.duyb1906443.dto.ClassMemberDTO;
import com.duyb1906443.dto.TopicDTO;
import com.duyb1906443.entity.CustomUserDetails;
import com.duyb1906443.service.ClassMemberService;

@RestController
public class ClassMemberAPI {

	@Autowired
	private ClassMemberService classMemberService;

	@GetMapping("/public/api/class-member")
	@CrossOriginsList
	public ResponseEntity<List<ClassMemberDTO>> getClassMembersByClassId(
			@RequestParam(name = "classId", required = false) Long classId, @RequestParam(name = "username", required = false) String username) {
		List<ClassMemberDTO> classMembers = null;
		if(classId != null) { //tìm theo lớp
			classMembers = classMemberService.findAllByClassId(classId);
		}
		else { //tìm theo username
			classMembers = classMemberService.findAllByUsername(username);
		}
		
		if (classMembers != null) {
			return ResponseEntity.status(200).body(classMembers);
		}
		return ResponseEntity.status(200).body(Collections.emptyList());
	}

	@PostMapping("/api/class-member")
	@CrossOriginsList
	public ResponseEntity<ClassMemberDTO> postClassMember(@RequestBody ClassMemberDTO classMemberDTO) {
		Long userId = ((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser().getId();
		classMemberDTO.setUserId(userId);
		ClassMemberDTO dto = classMemberService.save(classMemberDTO);

		if (dto != null) {
			return ResponseEntity.status(200).body(dto);
		}

		return ResponseEntity.status(500).build();
	}

	@PutMapping("/api/class-member")
	@CrossOriginsList
	public ResponseEntity<ClassMemberDTO> putClassMember(@RequestBody ClassMemberDTO classMemberDTO) {

		ClassMemberDTO dto = classMemberService.save(classMemberDTO);

		if (dto != null) {
			return ResponseEntity.status(200).body(dto);
		}

		return ResponseEntity.status(500).build();
	}

	@DeleteMapping("/api/class-member")
	@CrossOriginsList
	public ResponseEntity<ClassMemberDTO> deleteClassMember(@RequestBody ClassMemberDTO classMemberDTO) {

		classMemberService.delete(classMemberDTO);

		return ResponseEntity.status(200).build();
	}

}
