package com.duyb1906443.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.duyb1906443.dto.ReviewDTO;
import com.duyb1906443.entity.ReviewEntity;

@Component
public class ReviewConverter implements IConverterToDTO<ReviewEntity, ReviewDTO>{

	@Override
	public ReviewDTO toDTO(ReviewEntity entity) {
		ReviewDTO reviewDTO = new ReviewDTO();
		//if(entity.getClassEntity() != null) reviewDTO.setClassId(entity.getClassEntity().getId());
		reviewDTO.setUserId(entity.getUser().getId());
		reviewDTO.setStars(entity.getStars());
		reviewDTO.setComment(entity.getComment());
		return reviewDTO;
	}

	@Override
	public List<ReviewDTO> toDTOList(List<ReviewEntity> entities) {
		List<ReviewDTO> dtos = new ArrayList<ReviewDTO>();
		
		for (ReviewEntity reviewEntity : entities) {
			dtos.add(toDTO(reviewEntity));
		}
		return dtos;
	}

}
