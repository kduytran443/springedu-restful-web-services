package com.duyb1906443.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.duyb1906443.annotation.CrossOriginsList;
import com.duyb1906443.dto.ClassScheduleDTO;
import com.duyb1906443.entity.CustomUserDetails;
import com.duyb1906443.service.ClassScheduleService;

@RestController
public class ClassScheduleAPI {
	
	@Autowired
	private ClassScheduleService classScheduleService;
	
	@GetMapping("/public/api/class-schedule/class/{classId}")
	@CrossOriginsList
	public ResponseEntity<List<ClassScheduleDTO>> getClassSchedules(@PathVariable("classId") Long classId){
		List<ClassScheduleDTO> dtos = classScheduleService.findAllByClassId(classId);
		if(dtos != null) {
			return ResponseEntity.status(200).body(dtos);
		}
		return ResponseEntity.status(500).body(dtos);
	}
	
	@GetMapping("/api/class-schedule/user")
	@CrossOriginsList
	public ResponseEntity<List<ClassScheduleDTO>> getClassSchedulesByUser(){
		Long userId = ((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser().getId();
		List<ClassScheduleDTO> dtos = classScheduleService.findAllByClassUserId(userId);
		if(dtos != null) {
			return ResponseEntity.status(200).body(dtos);
		}
		return ResponseEntity.status(500).body(dtos);
	}
	
	@GetMapping("/public/api/class-schedule/{classScheduleId}")
	@CrossOriginsList
	public ResponseEntity<ClassScheduleDTO> getClassSchedule(@PathVariable("classScheduleId") Long classScheduleId){
		ClassScheduleDTO dto = classScheduleService.findOneByClassScheduleId(classScheduleId);
		if(dto != null) {
			return ResponseEntity.status(200).body(dto);
		}
		return ResponseEntity.status(500).body(new ClassScheduleDTO());
	}
	
	@PostMapping("/api/class-schedule")
	@CrossOriginsList
	public ResponseEntity<ClassScheduleDTO> postClassSchedule(@RequestBody ClassScheduleDTO classScheduleDTO){
		classScheduleDTO.setId(null);
		ClassScheduleDTO dto = classScheduleService.save(classScheduleDTO);
		if(dto != null) {
			return ResponseEntity.status(200).body(dto);
		}
		return ResponseEntity.status(500).body(new ClassScheduleDTO());
	}
	
	@PutMapping("/api/class-schedule")
	@CrossOriginsList
	public ResponseEntity<ClassScheduleDTO> putClassSchedule(@RequestBody ClassScheduleDTO classScheduleDTO){
		ClassScheduleDTO dto = classScheduleService.save(classScheduleDTO);
		if(dto != null) {
			return ResponseEntity.status(200).body(dto);
		}
		return ResponseEntity.status(500).body(new ClassScheduleDTO());
	}
	
	@DeleteMapping("/api/class-schedule/{classScheduleId}")
	@CrossOriginsList
	public ResponseEntity<ClassScheduleDTO> putClassSchedule(@PathVariable("classScheduleId") Long classScheduleId){
		classScheduleService.delete(classScheduleId);
		return ResponseEntity.status(200).body(new ClassScheduleDTO());
	}
	
}
