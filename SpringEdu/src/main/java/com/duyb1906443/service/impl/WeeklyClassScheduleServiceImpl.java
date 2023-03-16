package com.duyb1906443.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duyb1906443.converter.WeeklyClassScheduleConverter;
import com.duyb1906443.dto.WeeklyClassScheduleDTO;
import com.duyb1906443.repository.WeeklyClassScheduleRepository;
import com.duyb1906443.service.WeeklyClassScheduleService;

@Service
public class WeeklyClassScheduleServiceImpl implements WeeklyClassScheduleService {
	
	@Autowired
	private WeeklyClassScheduleRepository weeklyClassScheduleRepository;
	
	@Autowired
	private WeeklyClassScheduleConverter weeklyClassScheduleConverter;
	
	@Override
	public List<WeeklyClassScheduleDTO> findAll() {
		return weeklyClassScheduleConverter.toDTOList(weeklyClassScheduleRepository.findAll());
	}

}
