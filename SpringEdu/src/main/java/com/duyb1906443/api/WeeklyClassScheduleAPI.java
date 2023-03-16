package com.duyb1906443.api;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duyb1906443.annotation.CrossOriginsList;
import com.duyb1906443.dto.WeeklyClassScheduleDTO;
import com.duyb1906443.service.WeeklyClassScheduleService;

@RestController
public class WeeklyClassScheduleAPI {
	
	@Autowired
	private WeeklyClassScheduleService weeklyClassScheduleService;
	
	@GetMapping("/public/api/weekly-class-schedule")
	@CrossOriginsList
	public ResponseEntity<List<WeeklyClassScheduleDTO>> getWeeklyClassSchedules(){
		List<WeeklyClassScheduleDTO> dtos = weeklyClassScheduleService.findAll();
		if(dtos != null) {
			return ResponseEntity.status(200).body(dtos);
		}
		return ResponseEntity.status(500).body(Collections.emptyList());
	}
	
}
