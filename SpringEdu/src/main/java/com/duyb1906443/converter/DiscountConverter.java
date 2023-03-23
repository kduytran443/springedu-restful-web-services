package com.duyb1906443.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.duyb1906443.dto.DiscountDTO;
import com.duyb1906443.entity.DiscountEntity;

@Component
public class DiscountConverter implements IConverterToDTO<DiscountEntity, DiscountDTO>, IConverterToEntity<DiscountEntity, DiscountDTO> {

	@Override
	public DiscountDTO toDTO(DiscountEntity entity) {
		DiscountDTO dto = new DiscountDTO();
		if(entity.getId() != null) dto.setId(entity.getId());
		if(entity.getDiscountPercent() != null) dto.setDiscountPercent(entity.getDiscountPercent());
		if(entity.getStartDate() != null) dto.setStartDate(entity.getStartDate());
		if(entity.getEndDate() != null) dto.setEndDate(entity.getEndDate());
		if(entity.getStatus() != null) dto.setStatus(entity.getStatus());
		dto.setClassId(entity.getClassEntity().getId());
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

	@Override
	public DiscountEntity toEntity(DiscountDTO dto) {
		DiscountEntity entity = new DiscountEntity();
		
		if(dto.getId() != null) entity.setId(dto.getId());
		if(dto.getDiscountPercent() != null) entity.setDiscountPercent(dto.getDiscountPercent());
		if(dto.getStartDate() != null) entity.setStartDate(dto.getStartDate());
		if(dto.getEndDate() != null) entity.setEndDate(dto.getEndDate());
		if(dto.getStatus() != null) entity.setStatus(dto.getStatus());
		
		return entity;
	}
	public DiscountEntity toEntity(DiscountDTO dto, DiscountEntity entity) {
		
		if(dto.getDiscountPercent() != null) entity.setDiscountPercent(dto.getDiscountPercent());
		if(dto.getStartDate() != null) entity.setStartDate(dto.getStartDate());
		if(dto.getEndDate() != null) entity.setEndDate(dto.getEndDate());
		
		return entity;
	}

	@Override
	public List<DiscountEntity> toEntityList(List<DiscountDTO> dtos) {
		return dtos.stream().map(dto -> toEntity(dto)).collect(Collectors.toList());
	}

}
