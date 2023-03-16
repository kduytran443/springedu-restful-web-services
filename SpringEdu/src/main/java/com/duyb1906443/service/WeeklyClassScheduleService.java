package com.duyb1906443.service;

import java.util.List;

import com.duyb1906443.dto.WeeklyClassScheduleDTO;

public interface WeeklyClassScheduleService {
	
	List<WeeklyClassScheduleDTO> findAll();
	
}
