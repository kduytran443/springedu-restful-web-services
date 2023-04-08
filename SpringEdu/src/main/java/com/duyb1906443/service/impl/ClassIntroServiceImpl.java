package com.duyb1906443.service.impl;

import java.util.List;
import java.util.stream.Collectors;

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

@Service
public class ClassIntroServiceImpl implements ClassIntroService {

	@Autowired
	private ClassRepository classRepository;

	@Autowired
	private ReviewRepository reviewRepository;

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
		if(reviewRepository.getAvgReviewRatingByClassId(classId) != null) {
			classIntroDTO.setStars(reviewRepository.getAvgReviewRatingByClassId(classId));			
		}
		return classIntroDTO;
	}

	@Override
	public ClassIntroDTO findOneByClassIdAndUserId(Long classId, Long userId) {
		ClassEntity classEntity = classRepository.findOne(classId);
		ClassIntroDTO classIntroDTO = classIntroConverter.toDTO(classEntity);
		if(reviewRepository.getAvgReviewRatingByClassId(classId) != null) {
			classIntroDTO.setStars(reviewRepository.getAvgReviewRatingByClassId(classId));			
		}
		
		UserEntity userEntity = userRepository.findOne(userId);

		ClassMemberEntity classMemberEntity = classMemberRepository.findOneByClassEntityAndUser(classEntity,
				userEntity);
		if (classMemberEntity != null && classMemberEntity.getClassAccepted() == 1
				&& classMemberEntity.getMemberAccepted() == 1)
			classIntroDTO.setUserRoleCode(classMemberEntity.getClassRole().getCode());

		return classIntroDTO;
	}

	@Override
	public ClassIntroDTO changeDateOfClass(ClassIntroDTO classIntroDTO) {
		ClassEntity classEntity = classRepository.findOne(classIntroDTO.getId());
		classEntity.setStartTime(classIntroDTO.getStartTime());
		classEntity.setEndTime(classIntroDTO.getEndTime());
		classEntity = classRepository.save(classEntity);
		return classIntroConverter.toDTO(classEntity);
	}

	@Override
	public ClassIntroDTO changeClassStatus(ClassIntroDTO classIntroDTO) {
		ClassEntity classEntity = classRepository.findOne(classIntroDTO.getId());
		classEntity.setStatus(classIntroDTO.getStatus());
		classEntity = classRepository.save(classEntity);
		return classIntroConverter.toDTO(classEntity);
	}

	@Override
	public ClassIntroDTO changeClassVisible(ClassIntroDTO classIntroDTO) {
		ClassEntity classEntity = classRepository.findOne(classIntroDTO.getId());
		classEntity.setVisiable(classIntroDTO.getVisiable());
		classEntity = classRepository.save(classEntity);
		return classIntroConverter.toDTO(classEntity);
	}

	@Override
	public List<ClassIntroDTO> findAll() {
		
		List<ClassEntity> classEntity = classRepository.findAll();
		
		if(classEntity != null) {
			return classEntity.stream().map(item -> {
				ClassIntroDTO classIntroDTO = classIntroConverter.toDTO(item);
				if(reviewRepository.getAvgReviewRatingByClassId(item.getId()) != null) {
					classIntroDTO.setStars(reviewRepository.getAvgReviewRatingByClassId(item.getId()));			
				}
				return classIntroDTO;
			}).collect(Collectors.toList());
		}
		
		return null;
	}

}
