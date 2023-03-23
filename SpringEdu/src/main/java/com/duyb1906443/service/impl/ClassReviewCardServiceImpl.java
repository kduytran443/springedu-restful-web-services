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
				.filter(entity -> (entity.getAccepted() == 1 && entity.getVisiable() == 1 && entity.getStatus() == 1))
				.collect(Collectors.toList());
		List<ClassReviewCardDTO> dtos = new ArrayList<ClassReviewCardDTO>();
		for (ClassEntity classEntity : classEntities) {
			ClassReviewCardDTO dto = classReviewCardConverter.toDTO(classEntity);
			UserEntity user = classEntity.getCreator();
			dto.setUserAvatar(user.getAvatar());
			dto.setUsername(user.getUsername());
			dto.setUserFullname(user.getFullname());

			List<ReviewEntity> reviewEntities = reviewRepository.findAllByClassEntity(classEntity);

			if (reviewEntities != null) {
				if (dto.getId() != null) {
					Float stars = reviewService.getAvgReviewRatingByClassId(dto.getId());
					if (stars != null) {
						dto.setStars(stars);
					}
				}

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

	@Override
	public List<ClassReviewCardDTO> search(String value, String categoryCode, Float maxFee, Float rating) {
		List<ClassEntity> classEntities = null;

		if (categoryCode != null) {
			System.out.println("Search - categoryCode " + categoryCode);
			CategoryEntity categoryEntity = categoryRepository.findOneByCode(categoryCode);
			if (categoryEntity != null)
				classEntities = categoryEntity.getClasses();
		} else {
			System.out.println("Khong co category");
			classEntities = classRepository.findAll().stream().filter(entity -> entity.getStatus() == 1)
					.collect(Collectors.toList());
		}

		if (value != null && classEntities != null) {
			System.out.println("value - value " + value);
			classEntities = classEntities.stream()
					.filter(entity -> entity.getName().toLowerCase().contains(value.toLowerCase()))
					.collect(Collectors.toList());
		}

		if (maxFee != null) {
			System.out.println("maxFee - maxFee " + maxFee);
			classEntities = classEntities.stream().filter(entity -> entity.getFee() <= maxFee)
					.collect(Collectors.toList());
		}

		if (rating != null) {
			System.out.println("rating - rating " + rating);
			classEntities = classEntities.stream().filter(entity -> {
				Float stars = reviewService.getAvgReviewRatingByClassId(entity.getId());
				if(stars == null) {
					return false;
				}
				System.out.println("stars - " + stars);
				return stars >= rating;
			}).collect(Collectors.toList());
		}

		System.out.println("classEntity " + classEntities.size());

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

}
