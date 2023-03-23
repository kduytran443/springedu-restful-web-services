package com.duyb1906443.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duyb1906443.converter.ConstructedResponseTestConverter;
import com.duyb1906443.dto.ConstructedResponseTestDTO;
import com.duyb1906443.entity.ClassExcerciseEntity;
import com.duyb1906443.entity.ConstructedResponseTestEntity;
import com.duyb1906443.repository.ClassExcerciseRepository;
import com.duyb1906443.repository.ConstructedResponseTestRepository;
import com.duyb1906443.service.ConstructedResponseTestService;

@Service
public class ConstructedResponseTestServiceImpl implements ConstructedResponseTestService {

	@Autowired
	private ConstructedResponseTestRepository constructedResponseTestRepository;

	@Autowired
	private ConstructedResponseTestConverter constructedResponseTestConverter;

	@Autowired
	private ClassExcerciseRepository classExcerciseRepository;

	@Override
	public ConstructedResponseTestDTO findOneById(Long id) {
		ConstructedResponseTestEntity constructedResponseTestEntity = constructedResponseTestRepository.findOne(id);
		return constructedResponseTestConverter.toDTO(constructedResponseTestEntity);
	}

	@Override
	public ConstructedResponseTestDTO findOneByClassExcerciseId(Long classExcerciseId) {
		ClassExcerciseEntity classExcerciseEntity = classExcerciseRepository.findOne(classExcerciseId);

		if (classExcerciseEntity != null) {
			ConstructedResponseTestEntity constructedResponseTestEntity = classExcerciseEntity
					.getConstructedResponseTests();
			return constructedResponseTestConverter.toDTO(constructedResponseTestEntity);
		}

		return null;
	}

	@Override
	public ConstructedResponseTestDTO save(ConstructedResponseTestDTO constructedResponseTestDTO) {
		ConstructedResponseTestEntity constructedResponseTestEntity = null;

		if (constructedResponseTestDTO.getId() != null) {
			constructedResponseTestEntity = constructedResponseTestRepository
					.findOne(constructedResponseTestDTO.getId());
			constructedResponseTestEntity = constructedResponseTestConverter.toEntity(constructedResponseTestDTO,
					constructedResponseTestEntity);
		} else {
			constructedResponseTestEntity = constructedResponseTestConverter.toEntity(constructedResponseTestDTO);
			ClassExcerciseEntity classExcerciseEntity = classExcerciseRepository
					.findOne(constructedResponseTestDTO.getClassExcerciseId());
			constructedResponseTestEntity.setClassExcercise(classExcerciseEntity);
		}

		if (constructedResponseTestEntity != null) {
			constructedResponseTestEntity = constructedResponseTestRepository.save(constructedResponseTestEntity);
			return constructedResponseTestConverter.toDTO(constructedResponseTestEntity);
		}

		return null;
	}

	@Override
	public void delete(ConstructedResponseTestDTO constructedResponseTestDTO) {
		constructedResponseTestRepository.delete(constructedResponseTestDTO.getId());
	}

}
