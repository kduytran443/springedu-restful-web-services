package com.duyb1906443.service;

import java.util.List;

import com.duyb1906443.dto.ClassScheduleDTO;

public interface ClassScheduleService {

	List<ClassScheduleDTO> findAllByClassId(Long classId);
	ClassScheduleDTO findOneByClassScheduleId(Long classScheduleId);
	List<ClassScheduleDTO> findAllByClassUserId(Long userId);

	ClassScheduleDTO save(ClassScheduleDTO classScheduleDTO);

	void delete(Long id);

}
