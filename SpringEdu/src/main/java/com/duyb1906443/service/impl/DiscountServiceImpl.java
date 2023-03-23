package com.duyb1906443.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duyb1906443.converter.DiscountConverter;
import com.duyb1906443.dto.DiscountDTO;
import com.duyb1906443.entity.ClassEntity;
import com.duyb1906443.entity.DiscountEntity;
import com.duyb1906443.repository.ClassRepository;
import com.duyb1906443.repository.DiscountRepository;
import com.duyb1906443.service.DiscountService;

@Service
public class DiscountServiceImpl implements DiscountService {

	@Autowired
	private ClassRepository classRepository;

	@Autowired
	private DiscountConverter discountConverter;

	@Autowired
	private DiscountRepository discountRepository;

	@Override
	public List<DiscountDTO> getAllByClassId(Long classId) {
		ClassEntity classEntity = classRepository.findOne(classId);
		List<DiscountEntity> discountEntities = classEntity.getDiscounts().stream()
				.filter(entity -> entity.getStatus() == 1).collect(Collectors.toList());
		if (discountEntities != null) {
			return discountConverter.toDTOList(discountEntities);
		}
		return null;
	}

	@Override
	public DiscountDTO save(DiscountDTO discountDTO) {
		DiscountEntity discountEntity = null;

		if (discountDTO.getId() != null) {
			discountEntity = discountRepository.findOne(discountDTO.getId());
			discountEntity = discountConverter.toEntity(discountDTO, discountEntity);
		} else {
			discountEntity = discountConverter.toEntity(discountDTO);
			ClassEntity classEntity = classRepository.findOne(discountDTO.getClassId());
			discountEntity.setClassEntity(classEntity);
			discountEntity.setStatus(1);
		}
		
		if(discountEntity != null) {
			discountEntity = discountRepository.save(discountEntity);
			return discountConverter.toDTO(discountEntity);
		}

		return null;
	}

	@Override
	public void delete(Long disconutId) {
		DiscountEntity discountEntity = discountRepository.findOne(disconutId);
		discountEntity.setStatus(0);
		discountRepository.save(discountEntity);
	}

	@Override
	public DiscountDTO findOneById(Long id) {
		DiscountEntity discountEntity = discountRepository.findOne(id);
		
		if(discountEntity != null) {
			return discountConverter.toDTO(discountEntity);
		}
		
		return null;
	}

}
