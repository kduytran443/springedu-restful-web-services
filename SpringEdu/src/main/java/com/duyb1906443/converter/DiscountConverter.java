package com.duyb1906443.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.duyb1906443.dto.DiscountDTO;
import com.duyb1906443.entity.DiscountEntity;

@Component
public class DiscountConverter implements IConverterToDTO<DiscountEntity, DiscountDTO> {

	@Override
	public DiscountDTO toDTO(DiscountEntity entity) {
		DiscountDTO dto = new DiscountDTO();
		if(entity.getId() != null) dto.setId(entity.getId());
		dto.setDiscountPercent(entity.getDiscountPercent());
		dto.setStartDate(entity.getStartDate());
		dto.setEndDate(entity.getEndDate());
		return dto;
	}

	@Override
	public List<DiscountDTO> toDTOList(List<DiscountEntity> entities) {
		List<DiscountDTO> dtos = new ArrayList<>();
		for (DiscountEntity discountEntity : entities) {
			dtos.add(toDTO(discountEntity));
		}
		return dtos;
	}

}
