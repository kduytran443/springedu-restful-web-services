package com.duyb1906443.service.impl;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duyb1906443.converter.ClassConverter;
import com.duyb1906443.dto.ClassDTO;
import com.duyb1906443.dto.MeetingDTO;
import com.duyb1906443.entity.CategoryEntity;
import com.duyb1906443.entity.ClassEntity;
import com.duyb1906443.entity.FileEntity;
import com.duyb1906443.entity.MeetingEntity;
import com.duyb1906443.entity.UserEntity;
import com.duyb1906443.repository.CategoryRepository;
import com.duyb1906443.repository.ClassRepository;
import com.duyb1906443.repository.FileRepository;
import com.duyb1906443.repository.MeetingRepository;
import com.duyb1906443.repository.UserRepository;
import com.duyb1906443.service.ClassService;
import com.duyb1906443.service.MeetingService;


@Service
public class ClassServiceImpl implements ClassService {

	@Autowired
	private ClassConverter classConverter;

	@Autowired
	private ClassRepository classRepository;
	
	@Autowired
	private FileRepository fileRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private MeetingRepository meetingRepository;
	
	@Autowired
	private MeetingService meetingService;

	@Override
	public ClassDTO save(ClassDTO classDTO) {
		ClassEntity classEntity = new ClassEntity();

		if (classDTO.getId() != null) {

			ClassEntity oldClassEntity = classRepository.findOne(classDTO.getId());
			
			classEntity = classConverter.toEntity(classDTO, oldClassEntity);
		} else {
			classEntity = classConverter.toEntity(classDTO);
			
			FileEntity backgroundImage = fileRepository.findOne(1L);
			FileEntity video = fileRepository.findOne(2L);
			
			classEntity.setBackgroundImage(backgroundImage);
			classEntity.setVideo(video);
			
			CategoryEntity category = categoryRepository.findOne(classDTO.getCategory().getId());
			classEntity.setCategory(category);
			
			Date date = new Date();
			classEntity.setCreatedDate(new Timestamp(date.getTime()));
			
			UserEntity user = userRepository.findOne(classDTO.getCreatorId());
			classEntity.setCreator(user);
			
			MeetingDTO meetingDTO = meetingService.save(new MeetingDTO());
			MeetingEntity meetingEntity = meetingRepository.findOne(meetingDTO.getId());
			classEntity.setMeeting(meetingEntity);
		}
		classEntity = classRepository.save(classEntity);
		return classConverter.toDTO(classEntity);
	}

}
