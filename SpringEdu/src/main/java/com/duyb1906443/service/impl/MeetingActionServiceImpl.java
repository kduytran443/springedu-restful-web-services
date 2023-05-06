package com.duyb1906443.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duyb1906443.converter.MeetingActionConverter;
import com.duyb1906443.dto.MeetingActionDTO;
import com.duyb1906443.entity.ClassEntity;
import com.duyb1906443.entity.MeetingActionEntity;
import com.duyb1906443.entity.MeetingEntity;
import com.duyb1906443.entity.UserEntity;
import com.duyb1906443.repository.ClassRepository;
import com.duyb1906443.repository.MeetingActionRepository;
import com.duyb1906443.repository.MeetingRepository;
import com.duyb1906443.repository.UserRepository;
import com.duyb1906443.service.MeetingActionService;

@Service
public class MeetingActionServiceImpl implements MeetingActionService {
	
	@Autowired
	private ClassRepository classRepository;
	
	@Autowired
	private MeetingActionConverter meetingActionConverter;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private MeetingRepository meetingRepository;
	
	@Autowired
	private MeetingActionRepository meetingActionRepository;
	
	@Override
	public List<MeetingActionDTO> getAllByClassId(Long classId) {
		ClassEntity classEntity = classRepository.findOne(classId);
		MeetingEntity meetingEntity = classEntity.getMeeting();
		List<MeetingActionEntity> meetingActionEntities = meetingEntity.getMeetingActions();
		return meetingActionConverter.toDTOList(meetingActionEntities);
	}

	@Override
	public List<MeetingActionDTO> getAllByClassIdAndRange(Long classId, Timestamp startTime, Timestamp endTime) {
		ClassEntity classEntity = classRepository.findOne(classId);
		MeetingEntity meetingEntity = classEntity.getMeeting();
		List<MeetingActionEntity> meetingActionEntities = meetingEntity.getMeetingActions();
		meetingActionEntities = meetingActionEntities.stream().filter(item -> {
			return item.getTime().getTime() >= startTime.getTime() && item.getTime().getTime() <= endTime.getTime();
		}).collect(Collectors.toList());
		
		return meetingActionConverter.toDTOList(meetingActionEntities);
	}

	@Override
	public MeetingActionDTO save(MeetingActionDTO meetingActionDTO) {
		MeetingActionEntity meetingActionEntity = meetingActionConverter.toEntity(meetingActionDTO);
		
		Date date = new Date();
		meetingActionEntity.setTime(new Timestamp(date.getTime()));
		
		UserEntity userEntity = userRepository.findOne(meetingActionDTO.getUserId());
		meetingActionEntity.setUser(userEntity);
		
		MeetingEntity meetingEntity = null;
		if(meetingActionDTO.getClassId() != null) {
			ClassEntity classEntity = classRepository.findOne(meetingActionDTO.getClassId());
			meetingEntity = classEntity.getMeeting();
		}
		else {
			meetingEntity = meetingRepository.findOne(meetingActionDTO.getMeetingId());
		}
		meetingActionEntity.setMeeting(meetingEntity);
		
		meetingActionEntity = meetingActionRepository.save(meetingActionEntity);
		
		return meetingActionConverter.toDTO(meetingActionEntity);
	}

	@Override
	public MeetingActionDTO delete(Long id) {
		return null;
	}

}
