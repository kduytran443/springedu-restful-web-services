package com.duyb1906443.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duyb1906443.converter.ClassReviewCardConverter;
import com.duyb1906443.dto.ClassReviewCardDTO;
import com.duyb1906443.entity.CategoryEntity;
import com.duyb1906443.entity.ClassEntity;
import com.duyb1906443.entity.ClassMemberEntity;
import com.duyb1906443.entity.UserEntity;
import com.duyb1906443.repository.CategoryRepository;
import com.duyb1906443.repository.ClassMemberRepository;
import com.duyb1906443.repository.ClassRepository;
import com.duyb1906443.repository.UserRepository;
import com.duyb1906443.service.ClassMemberService;
import com.duyb1906443.service.ClassReviewCardService;
import com.duyb1906443.service.ReviewService;

@Service
public class ClassReviewCardServiceImpl implements ClassReviewCardService {

	@Autowired
	private ClassRepository classRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ClassReviewCardConverter classReviewCardConverter;

	@Autowired
	private ReviewService reviewService;

	@Autowired
	private ClassMemberService classMemberService;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ClassMemberRepository classMemberRepository;

	@Override
	public List<ClassReviewCardDTO> findAll() {
		return classReviewCardConverter.toDTOList(classRepository.findAll());
	}

	@Override
	public List<ClassReviewCardDTO> findAllByCategoryCode(String categoryCode) {
		CategoryEntity categoryEntity = categoryRepository.findOneByCode(categoryCode);

		List<ClassEntity> classEntities = categoryEntity.getClasses();
		classEntities = classEntities.stream()
				.filter(entity -> (entity.getAccepted() == 1 && entity.getVisiable() == 1 && entity.getStatus() == 1))
				.collect(Collectors.toList());
		List<ClassReviewCardDTO> dtos = new ArrayList<ClassReviewCardDTO>();
		for (ClassEntity classEntity : classEntities) {
			ClassReviewCardDTO dto = classReviewCardConverter.toDTO(classEntity);
			UserEntity user = classEntity.getCreator();
			dto.setUserAvatar(user.getAvatar());
			dto.setUsername(user.getUsername());
			dto.setUserFullname(user.getFullname());
			Float stars = reviewService.getAvgReviewRatingByClassId(dto.getId());
			if (stars != null) {
				dto.setStars(stars);
			}

			Integer countMember = classMemberService.countAllMember(dto.getId());
			if (countMember != null) {
				dto.setMemberCount(countMember);
			}

			dtos.add(dto);
		}

		return dtos;
	}

	@Override
	public List<ClassReviewCardDTO> findAllByUser(Long userId) {
		UserEntity userEntity = userRepository.findOne(userId);
		List<ClassMemberEntity> classMemberEntities = classMemberRepository.findAllByUser(userEntity);
		if (classMemberEntities != null) {
			List<ClassEntity> classEntities = classMemberEntities.stream()
					.filter(classMember -> (classMember.getClassAccepted() == 1 && classMember.getMemberAccepted() == 1
							&& classMember.getClassEntity().getStatus() == 1))
					.map(classMember -> classMember.getClassEntity()).collect(Collectors.toList());
			List<ClassReviewCardDTO> dtos = new ArrayList<ClassReviewCardDTO>();
			for (ClassEntity classEntity : classEntities) {
				ClassReviewCardDTO dto = classReviewCardConverter.toDTO(classEntity);
				UserEntity user = classEntity.getCreator();
				dto.setUserAvatar(user.getAvatar());
				dto.setUsername(user.getUsername());
				dto.setUserFullname(user.getFullname());
				Float stars = reviewService.getAvgReviewRatingByClassId(dto.getId());
				if (stars != null) {
					dto.setStars(stars);
				}

				Integer countMember = classMemberService.countAllMember(dto.getId());
				if (countMember != null) {
					dto.setMemberCount(countMember);
				}

				dtos.add(dto);
			}
			return dtos;
		}

		return null;
	}

}
