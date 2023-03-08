package com.duyb1906443.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duyb1906443.converter.MeetingConverter;
import com.duyb1906443.dto.ClassMemberDTO;
import com.duyb1906443.dto.MeetingDTO;
import com.duyb1906443.entity.ClassEntity;
import com.duyb1906443.entity.MeetingEntity;
import com.duyb1906443.repository.ClassRepository;
import com.duyb1906443.repository.MeetingRepository;
import com.duyb1906443.service.ClassMemberService;
import com.duyb1906443.service.MeetingService;

@Service
public class MeetingServiceImpl implements MeetingService {

	@Autowired
	private ClassRepository classRepository;

	@Autowired
	private MeetingConverter meetingConverter;
	
	@Autowired
	private MeetingRepository meetingRepository;
	
	@Autowired
	private ClassMemberService classMemberService;

	@Override
	public MeetingDTO findOneByClassId(Long classId, Long userId) {

		ClassEntity classEntity = classRepository.findOne(classId);
		MeetingDTO dto = meetingConverter.toDTO(classEntity.getMeeting());
		List<ClassMemberDTO> members = classMemberService.findAllByClassId(classId);
		ClassMemberDTO memberDTO = null;
		
		for (ClassMemberDTO member : members) {
			if(member.getUserId().equals(userId)) {
				memberDTO = member;
			}
		}
		
		dto.setRole(memberDTO.getClassRole());
		return dto;
	}

	@Override
	public MeetingDTO findOneByClassIdAndUserId(Long classId, Long userId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public MeetingDTO save(MeetingDTO meetingDTO) {
		MeetingEntity meetingEntity = new MeetingEntity();
		if(meetingDTO.getId() != null) {
			meetingEntity = meetingRepository.findOne(meetingDTO.getId());
			if(meetingDTO.getUrl() != null) meetingEntity.setUrl(meetingDTO.getUrl());
		}
		else {
			int max = 50;
			int min = 40;
			int random = (int )(Math.random() * max + min);
			meetingEntity.setUrl("spring-edu-dhct-"+random);
		}
		meetingEntity = meetingRepository.save(meetingEntity);
		
		return meetingConverter.toDTO(meetingEntity);
	}

}
