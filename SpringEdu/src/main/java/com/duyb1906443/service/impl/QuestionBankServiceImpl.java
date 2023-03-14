package com.duyb1906443.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duyb1906443.converter.QuestionBankConverter;
import com.duyb1906443.dto.QuestionBankDTO;
import com.duyb1906443.entity.QuestionBankEntity;
import com.duyb1906443.entity.UserEntity;
import com.duyb1906443.repository.QuestionBankRepository;
import com.duyb1906443.repository.UserRepository;
import com.duyb1906443.service.QuestionBankService;

@Service
public class QuestionBankServiceImpl implements QuestionBankService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private QuestionBankConverter questionBankConverter;
	
	@Autowired
	private QuestionBankRepository questionBankRepository;
	
	@Override
	public List<QuestionBankDTO> findAllByUserId(Long userId) {
		
		UserEntity userEntity = userRepository.findOne(userId);
		
		List<QuestionBankEntity> questionBankEntities = userEntity.getQuestionBanks();
		
		return questionBankConverter.toDTOList(questionBankEntities);
	}

	@Override
	public QuestionBankDTO save(QuestionBankDTO dto, Long userId) {
		QuestionBankEntity questionBankEntity = null;
		
		if(dto.getId() != null) {
			questionBankEntity = questionBankRepository.findOne(dto.getId());
			questionBankEntity = questionBankConverter.toEntity(dto, questionBankEntity);
		}
		else {
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
		questionBankEntity = questionBankRepository.save(questionBankEntity);
	}
	
}
