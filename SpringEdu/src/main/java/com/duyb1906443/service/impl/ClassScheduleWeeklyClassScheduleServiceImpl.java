package com.duyb1906443.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duyb1906443.converter.ClassScheduleWeeklyClassScheduleConverter;
import com.duyb1906443.dto.ClassScheduleWeeklyClassScheduleDTO;
import com.duyb1906443.entity.ClassEntity;
import com.duyb1906443.entity.ClassScheduleWeeklyClassScheduleEntity;
import com.duyb1906443.repository.ClassRepository;
import com.duyb1906443.repository.ClassScheduleWeeklyClassScheduleRepository;
import com.duyb1906443.service.ClassScheduleWeeklyClassScheduleService;

@Service
public class ClassScheduleWeeklyClassScheduleServiceImpl implements ClassScheduleWeeklyClassScheduleService {

	@Autowired
	private ClassScheduleWeeklyClassScheduleRepository classScheduleWeeklyClassScheduleRepository;

	@Autowired
	private ClassRepository classRepository;

	@Autowired
	private ClassScheduleWeeklyClassScheduleConverter classScheduleWeeklyClassScheduleConverter;

	@Override
	public List<ClassScheduleWeeklyClassScheduleDTO> findAllByUserId(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClassScheduleWeeklyClassScheduleDTO> findAllByClassId(Long classId) {
		ClassEntity classEntity = classRepository.findOne(classId);
		List<ClassScheduleWeeklyClassScheduleEntity> classScheduleWeeklyClassScheduleEntities = classScheduleWeeklyClassScheduleRepository.findAllByClassSchedule(classEntity.getClassSchedule());
		
		List<ClassScheduleWeeklyClassScheduleDTO> dtos = classScheduleWeeklyClassScheduleConverter.toDTOList(classScheduleWeeklyClassScheduleEntities);
		
		return dtos;
	}

}
