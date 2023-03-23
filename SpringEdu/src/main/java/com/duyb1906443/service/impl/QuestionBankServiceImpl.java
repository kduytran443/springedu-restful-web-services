package com.duyb1906443.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duyb1906443.converter.QuestionBankConverter;
import com.duyb1906443.dto.QuestionBankDTO;
import com.duyb1906443.entity.ClassEntity;
import com.duyb1906443.entity.QuestionBankEntity;
import com.duyb1906443.entity.UserEntity;
import com.duyb1906443.repository.ClassRepository;
import com.duyb1906443.repository.QuestionBankRepository;
import com.duyb1906443.repository.UserRepository;
import com.duyb1906443.service.QuestionBankService;

@Service
public class QuestionBankServiceImpl implements QuestionBankService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private QuestionBankConverter questionBankConverter;

	@Autowired
	private QuestionBankRepository questionBankRepository;

	@Autowired
	private ClassRepository classRepository;

	@Override
	public List<QuestionBankDTO> findAllByUserId(Long userId) {

		UserEntity userEntity = userRepository.findOne(userId);

		List<QuestionBankEntity> questionBankEntities = userEntity.getQuestionBanks();
		questionBankEntities.stream().filter(entity -> entity.getStatus() == 1).collect(Collectors.toList());

		return questionBankConverter.toDTOList(questionBankEntities);
	}

	@Override
	public QuestionBankDTO save(QuestionBankDTO dto, Long userId) {
		QuestionBankEntity questionBankEntity = null;

		if (dto.getId() != null) {
			questionBankEntity = questionBankRepository.findOne(dto.getId());
			questionBankEntity = questionBankConverter.toEntity(dto, questionBankEntity);
		} else {
			questionBankEntity = questionBankConverter.toEntity(dto);
			questionBankEntity.setUser(userRepository.findOne(userId));
			questionBankEntity.setStatus(1);
		}
		questionBankEntity = questionBankRepository.save(questionBankEntity);
		return questionBankConverter.toDTO(questionBankEntity);
	}

	@Override
	public void delete(Long id) {
		QuestionBankEntity questionBankEntity = questionBankRepository.findOne(id);
		questionBankEntity.setStatus(0);
		System.out.println("Question bank "+questionBankEntity.getName());
		questionBankEntity = questionBankRepository.save(questionBankEntity);
	}

	@Override
	public List<QuestionBankDTO> findAllByClassId(Long classId) {
		ClassEntity classEntity = classRepository.findOne(classId);

		List<QuestionBankEntity> questionBankEntities = classEntity.getQuestionBanks();

		return questionBankConverter.toDTOList(questionBankEntities);
	}

	@Override
	public QuestionBankDTO findOneById(Long questionBankId) {
		QuestionBankEntity questionBankEntity = questionBankRepository.findOne(questionBankId);
		if (questionBankEntity != null) {
			return questionBankConverter.toDTO(questionBankEntity);
		}
		return null;
	}

	@Override
	public QuestionBankDTO saveToClass(Long classId, QuestionBankDTO questionBankDTO) {
		ClassEntity classEntity = classRepository.findOne(classId);

		QuestionBankEntity questionBankEntity = questionBankRepository.findOne(questionBankDTO.getId());

		List<ClassEntity> classEntities = questionBankEntity.getClassEntities();
		boolean isExisted = classEntities.stream().anyMatch(entity -> entity.getId().equals(classId));
		if (!isExisted) {
			classEntities.add(classEntity);
			questionBankEntity.setClassEntities(classEntities);
			questionBankEntity = questionBankRepository.save(questionBankEntity);
			return questionBankConverter.toDTO(questionBankEntity);
		}
		return null;
	}

	@Override
	public void deleteFromClass(Long classId, QuestionBankDTO questionBankDTO) {
		QuestionBankEntity questionBankEntity = questionBankRepository.findOne(questionBankDTO.getId());
		List<ClassEntity> classEntities = questionBankEntity.getClassEntities().stream()
				.filter(classEntity -> !classEntity.getId().equals(classId)).collect(Collectors.toList());
		questionBankEntity.setClassEntities(classEntities);
		questionBankEntity = questionBankRepository.save(questionBankEntity);
	}

}
