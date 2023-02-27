package com.duyb1906443.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duyb1906443.converter.ClassReviewCardConverter;
import com.duyb1906443.dto.ClassReviewCardDTO;
import com.duyb1906443.entity.CategoryEntity;
import com.duyb1906443.entity.ClassEntity;
import com.duyb1906443.repository.CategoryRepository;
import com.duyb1906443.repository.ClassRepository;
import com.duyb1906443.service.ClassReviewCardService;


@Service
public class ClassReviewCardServiceImpl implements ClassReviewCardService {

	@Autowired
	private ClassRepository classRepository;

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ClassReviewCardConverter classReviewCardConverter;
	
	@Override
	public List<ClassReviewCardDTO> findAll() {
		return classReviewCardConverter.toDTOList(classRepository.findAll());
	}

	@Override
	public List<ClassReviewCardDTO> findAllByCategoryCode(String categoryCode) {
		CategoryEntity categoryEntity = categoryRepository.findOneByCode(categoryCode);
		
		List<ClassEntity> classEntities = categoryEntity.getClasses();
		List<ClassReviewCardDTO> dtos = new ArrayList<ClassReviewCardDTO>();
		for (ClassEntity classEntity : classEntities) {
			ClassReviewCardDTO dto = classReviewCardConverter.toDTO(classEntity);
			
		}
		
		return classReviewCardConverter.toDTOList(classEntities);
	}
	
}
