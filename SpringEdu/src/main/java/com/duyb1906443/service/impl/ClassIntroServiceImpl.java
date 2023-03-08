package com.duyb1906443.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duyb1906443.converter.ClassIntroConverter;
import com.duyb1906443.dto.ClassIntroDTO;
import com.duyb1906443.entity.ClassEntity;
import com.duyb1906443.entity.ClassMemberEntity;
import com.duyb1906443.entity.UserEntity;
import com.duyb1906443.repository.ClassMemberRepository;
import com.duyb1906443.repository.ClassRepository;
import com.duyb1906443.repository.ReviewRepository;
import com.duyb1906443.repository.UserRepository;
import com.duyb1906443.service.ClassIntroService;
import com.duyb1906443.service.ClassScheduleWeeklyClassScheduleService;

@Service
public class ClassIntroServiceImpl implements ClassIntroService {

	@Autowired
	private ClassRepository classRepository;

	@Autowired
	private ReviewRepository reviewRepository;

	@Autowired
	private ClassScheduleWeeklyClassScheduleService classScheduleWeeklyClassScheduleService;

	@Autowired
	private ClassIntroConverter classIntroConverter;
	
	@Autowired
	private ClassMemberRepository classMemberRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public ClassIntroDTO findOneByClassId(Long classId) {
		ClassEntity classEntity = classRepository.findOne(classId);
		ClassIntroDTO classIntroDTO = classIntroConverter.toDTO(classEntity);
		classIntroDTO.setStars(reviewRepository.getAvgReviewRatingByClassId(classId));
		classIntroDTO.setClassScheduleWeeklyClassSchedule(classScheduleWeeklyClassScheduleService.findAllByClassId(classId));
		return classIntroDTO;
	}

	@Override
	public ClassIntroDTO findOneByClassIdAndUserId(Long classId, Long userId) {
		ClassEntity classEntity = classRepository.findOne(classId);
		ClassIntroDTO classIntroDTO = classIntroConverter.toDTO(classEntity);
		classIntroDTO.setStars(reviewRepository.getAvgReviewRatingByClassId(classId));
		classIntroDTO.setClassScheduleWeeklyClassSchedule(classScheduleWeeklyClassScheduleService.findAllByClassId(classId));
		
		UserEntity userEntity = userRepository.findOne(userId);
		
		ClassMemberEntity classMemberEntity = classMemberRepository.findOneByClassEntityAndUser(classEntity, userEntity); 
		classIntroDTO.setUserRoleCode(classMemberEntity.getClassRole().getCode());
		
		return classIntroDTO;
	}

}
