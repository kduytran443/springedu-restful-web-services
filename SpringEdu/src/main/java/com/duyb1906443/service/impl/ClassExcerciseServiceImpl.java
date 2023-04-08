package com.duyb1906443.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duyb1906443.converter.ClassExcerciseConverter;
import com.duyb1906443.dto.ClassExcerciseDTO;
import com.duyb1906443.entity.ClassEntity;
import com.duyb1906443.entity.ClassExcerciseEntity;
import com.duyb1906443.entity.QuestionBankEntity;
import com.duyb1906443.repository.ClassExcerciseRepository;
import com.duyb1906443.repository.ClassRepository;
import com.duyb1906443.repository.QuestionBankRepository;
import com.duyb1906443.service.ClassExcerciseService;

@Service
public class ClassExcerciseServiceImpl implements ClassExcerciseService {

	@Autowired
	private ClassExcerciseRepository classExcerciseRepository;

	@Autowired
	private ClassRepository classRepository;

	@Autowired
	private ClassExcerciseConverter classExcerciseConverter;

	@Autowired
	private QuestionBankRepository questionBankRepository;

	@Override
	public List<ClassExcerciseDTO> findAllByClassId(Long classId) {
		ClassEntity classEntity = classRepository.findOne(classId);

		List<ClassExcerciseEntity> classExcerciseEntities = classExcerciseRepository
				.findByClassEntityOrderByIdDesc(classEntity).stream()
				 .filter(classExcercise -> classExcercise.getStatus() == 1)
				 .collect(Collectors.toList());

		/*
		 * classExcerciseEntities = classExcerciseEntities.stream()
		 * .filter(classExcercise -> classExcercise.getStatus() == 1)
		 * .collect(Collectors.toList());
		 */

		return classExcerciseConverter.toDTOList(classExcerciseEntities);
	}

	@Override
	public ClassExcerciseDTO findOneById(Long id) {

		ClassExcerciseEntity classExcerciseEntity = classExcerciseRepository.findOne(id);

		if (classExcerciseEntity.getStatus() == 1) {
			ClassExcerciseDTO classExcerciseDTO = classExcerciseConverter.toDTO(classExcerciseEntity);
			return classExcerciseDTO;
		}

		return null;
	}

	@Override
	public ClassExcerciseDTO save(ClassExcerciseDTO classExcerciseDTO) {
		ClassExcerciseEntity classExcerciseEntity = null;

		if (classExcerciseDTO.getId() != null) {
			classExcerciseEntity = classExcerciseRepository.findOne(classExcerciseDTO.getId());
			classExcerciseEntity = classExcerciseConverter.toEntity(classExcerciseDTO, classExcerciseEntity);
		} else {
			classExcerciseEntity = classExcerciseConverter.toEntity(classExcerciseDTO);

			ClassEntity classEntity = classRepository.findOne(classExcerciseDTO.getClassId());
			classExcerciseEntity.setClassEntity(classEntity);

			Date date = new Date();
			classExcerciseEntity.setCreatedTime(new Timestamp(date.getTime()));
			classExcerciseEntity.setStatus(1);
			if (classExcerciseDTO.getQuestionBankId() != null) {
				QuestionBankEntity questionBankEntity = questionBankRepository
						.findOne(classExcerciseDTO.getQuestionBankId());
				classExcerciseEntity.setQuestionBank(questionBankEntity);
			}
		}

		if (classExcerciseEntity != null) {
			classExcerciseEntity = classExcerciseRepository.save(classExcerciseEntity);
			return classExcerciseConverter.toDTO(classExcerciseEntity);
		}

		return null;
	}

	@Override
	public void delete(ClassExcerciseDTO classExcerciseDTO) {
		ClassExcerciseEntity classExcerciseEntity = classExcerciseRepository.findOne(classExcerciseDTO.getId());
		classExcerciseEntity.setStatus(0);
		classExcerciseRepository.save(classExcerciseEntity);
	}

}
