package com.duyb1906443.service;

import java.util.List;

import com.duyb1906443.dto.ClassScheduleWeeklyClassScheduleDTO;

public interface ClassScheduleWeeklyClassScheduleService {
	
	List<ClassScheduleWeeklyClassScheduleDTO> findAllByClassId(Long classId);
	
	List<ClassScheduleWeeklyClassScheduleDTO> findAllByUserId(Long userId);
	
}
