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
import com.duyb1906443.entity.ReviewEntity;
import com.duyb1906443.entity.UserEntity;
import com.duyb1906443.repository.CategoryRepository;
import com.duyb1906443.repository.ClassMemberRepository;
import com.duyb1906443.repository.ClassRepository;
import com.duyb1906443.repository.ReviewRepository;
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

	@Autowired
	private ReviewRepository reviewRepository;

	@Override
	public List<ClassReviewCardDTO> findAll() {
		List<ClassEntity> classEntities = classRepository.findAll();
		classEntities = classEntities.stream()
				.filter(entity -> (entity.getAccepted() == 1 && entity.getVisiable() == 1 && entity.getStatus() == 1))
				.collect(Collectors.toList());
		return classReviewCardConverter.toDTOList(classEntities);
	}

	@Override
	public List<ClassReviewCardDTO> findAllByCategoryCode(String categoryCode) {
		CategoryEntity categoryEntity = categoryRepository.findOneByCode(categoryCode);

		List<ClassEntity> classEntities = categoryEntity.getClasses();
		classEntities = classEntities.stream()
				.filter(entity -> (entity.getVisiable() == 1 && entity.getStatus() == 1))
				.collect(Collectors.toList());
		List<ClassReviewCardDTO> dtos = new ArrayList<ClassReviewCardDTO>();
		for (ClassEntity classEntity : classEntities) {
			ClassReviewCardDTO dto = classReviewCardConverter.toDTO(classEntity);
			UserEntity user = classEntity.getCreator();
			dto.setUserAvatar(user.getAvatar());
			dto.setUsername(user.getUsername());
			dto.setUserFullname(user.getFullname());

			List<ReviewEntity> reviewEntities = reviewRepository.findAllByClassEntity(classEntity);
			Float avg = 0F;
			for (ReviewEntity reviewEntity : reviewEntities) {
				avg += reviewEntity.getStars();
			}
			if(reviewEntities != null && reviewEntities.size() > 0) avg = avg/reviewEntities.size();
			dto.setStars(avg);

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
			List<ClassReviewCardDTO> dtos = new ArrayList<ClassReviewCardDTO>();
			for (ClassMemberEntity classMember : classMemberEntities) {
				if(classMember.getClassAccepted() == 1 && classMember.getMemberAccepted() == 1 && classMember.getClassEntity().getStatus() == 1) {
					ClassEntity classEntity = classMember.getClassEntity();
					
					ClassReviewCardDTO dto = classReviewCardConverter.toDTO(classEntity);
					UserEntity user = classEntity.getCreator();
					dto.setUserAvatar(user.getAvatar());
					dto.setUsername(user.getUsername());
					dto.setUserFullname(user.getFullname());
					dto.setRole(classMember.getClassRole().getCode());
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
			}

			return dtos;
			
			/*
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
				dto.setRole(null);
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
			*/
		}

		return null;
	}

	@Override
	public List<ClassReviewCardDTO> search(String value, String categoryCode, Float maxFee, Float rating) {
		List<ClassEntity> classEntities = null;

		if (categoryCode != null) {
			CategoryEntity categoryEntity = categoryRepository.findOneByCode(categoryCode);
			if (categoryEntity != null)
				classEntities = categoryEntity.getClasses();
		} else {
			classEntities = classRepository.findAll().stream().filter(entity -> entity.getStatus() == 1)
					.collect(Collectors.toList());
		}

		if (value != null && classEntities != null) {
			classEntities = classEntities.stream()
					.filter(entity -> entity.getName().toLowerCase().contains(value.toLowerCase()))
					.collect(Collectors.toList());
		}

		if (maxFee != null) {
			classEntities = classEntities.stream().filter(entity -> entity.getFee() <= maxFee)
					.collect(Collectors.toList());
		}

		if (rating != null) {
			classEntities = classEntities.stream().filter(entity -> {
				Float stars = reviewService.getAvgReviewRatingByClassId(entity.getId());
				if(stars == null) {
					return false;
				}
				return stars >= rating;
			}).collect(Collectors.toList());
		}

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
	public Long getMember(Long classId) {
		
		return null;
	}

}
