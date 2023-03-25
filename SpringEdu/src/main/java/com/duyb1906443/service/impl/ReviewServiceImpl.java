package com.duyb1906443.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duyb1906443.converter.ReviewConverter;
import com.duyb1906443.dto.ReviewDTO;
import com.duyb1906443.entity.ClassEntity;
import com.duyb1906443.entity.ReviewEntity;
import com.duyb1906443.entity.UserEntity;
import com.duyb1906443.entity.id.ReviewId;
import com.duyb1906443.repository.ClassRepository;
import com.duyb1906443.repository.ReviewRepository;
import com.duyb1906443.repository.UserRepository;
import com.duyb1906443.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewRepository reviewRepository;

	@Autowired
	private ClassRepository classRepository;

	@Autowired
	private ReviewConverter reviewConverter;

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<ReviewDTO> findAllByClassId(Long classId) {
		ClassEntity classEntity = classRepository.findOne(classId);

		List<ReviewEntity> reviewEntities = reviewRepository.findAllByClassEntity(classEntity);
		List<ReviewDTO> reviewDTOs = new ArrayList<ReviewDTO>();

		for (ReviewEntity reviewEntity : reviewEntities) {
			ReviewDTO reviewDTO = reviewConverter.toDTO(reviewEntity);
			reviewDTO.setUserAvatar(reviewEntity.getUser().getAvatar());
			reviewDTO.setUserName(reviewEntity.getUser().getUsername());
			reviewDTOs.add(reviewDTO);
		}

		return reviewDTOs;
	}

	@Override
	public Float getAvgReviewRatingByClassId(Long classId) {
		Float avg = reviewRepository.getAvgReviewRatingByClassId(classId);
		if(avg != null) {
			return avg;
		}
		return null;
	}

	@Override
	public ReviewDTO createReview(ReviewDTO reviewDTO) {
		ClassEntity classEntity = classRepository.findOne(reviewDTO.getClassId());
		UserEntity userEntity = userRepository.findOne(reviewDTO.getUserId());
		
		System.out.println("reviewDTO.getClassId() "+reviewDTO.getClassId());
		System.out.println("reviewDTO.getUserId() "+reviewDTO.getUserId());
		ReviewEntity reviewEntity = reviewRepository.findOneByClassEntityAndUser(classEntity, userEntity);

		if (reviewEntity == null) {
			System.out.println("Create new!");
			reviewEntity = new ReviewEntity();
		}

		reviewEntity.setClassEntity(classEntity);
		reviewEntity.setUser(userEntity);
		reviewEntity.setComment(reviewDTO.getComment());
		Date date = new Date();
		reviewEntity.setDate(new Timestamp(date.getTime()));

		reviewEntity.setStars(reviewDTO.getStars());
		ReviewId reviewId = new ReviewId();
		reviewId.setClassId(classEntity.getId());
		reviewId.setUserId(userEntity.getId());
		reviewEntity.setReviewId(reviewId);

		reviewEntity = reviewRepository.save(reviewEntity);
		return reviewConverter.toDTO(reviewEntity);

	}

	@Override
	public ReviewDTO editReview(ReviewDTO reviewDTO) {
		ClassEntity classEntity = classRepository.findOne(reviewDTO.getClassId());
		UserEntity userEntity = userRepository.findOne(reviewDTO.getUserId());

		ReviewEntity reviewEntity = reviewRepository.findOneByClassEntityAndUser(classEntity, userEntity);

		if (reviewEntity != null) {
			reviewEntity = new ReviewEntity();
			reviewEntity.setComment(reviewDTO.getComment());
			Date date = new Date();
			reviewEntity.setDate(new Timestamp(date.getTime()));

			ReviewId reviewId = new ReviewId();
			reviewId.setClassId(classEntity.getId());
			reviewId.setUserId(userEntity.getId());
			reviewEntity.setReviewId(reviewId);
			reviewEntity = reviewRepository.save(reviewEntity);
			return reviewConverter.toDTO(reviewEntity);
		}

		return null;
	}

	@Override
	public ReviewDTO getReviewByUserAndClass(ReviewDTO reviewDTO) {

		ClassEntity classEntity = classRepository.findOne(reviewDTO.getClassId());
		UserEntity userEntity = userRepository.findOne(reviewDTO.getUserId());
		
		ReviewEntity reviewEntity = reviewRepository.findOneByClassEntityAndUser(classEntity, userEntity);
		
		if(reviewEntity != null) {
			return reviewConverter.toDTO(reviewEntity);			
		}
		
		return null;
	}

}
