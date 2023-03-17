package com.duyb1906443.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duyb1906443.converter.ChoiceAnswerConverter;
import com.duyb1906443.dto.ChoiceAnswerDTO;
import com.duyb1906443.entity.ChoiceAnswerEntity;
import com.duyb1906443.entity.ChoiceQuestionEntity;
import com.duyb1906443.entity.FileEntity;
import com.duyb1906443.repository.ChoiceAnswerRepository;
import com.duyb1906443.repository.ChoiceQuestionRepository;
import com.duyb1906443.repository.FileRepository;
import com.duyb1906443.service.ChoiceAnswerService;

@Service
public class ChoiceAnswerServiceImpl implements ChoiceAnswerService {
	
	@Autowired
	private ChoiceAnswerRepository choiceAnswerRepository;
	
	@Autowired
	private ChoiceQuestionRepository choiceQuestionRepository;
	
	@Autowired
	private ChoiceAnswerConverter choiceAnswerConverter;
	
	@Autowired
	private FileRepository fileRepository;
	
	@Override
	public List<ChoiceAnswerDTO> findAllByChoiceQuestionId(Long choiceQuestionId) {
		ChoiceQuestionEntity choiceQuestionEntity = choiceQuestionRepository.findOne(choiceQuestionId);
		if(choiceQuestionEntity != null) {
			List<ChoiceAnswerEntity> choiceAnswerEntities = choiceQuestionEntity.getChoiceAnswers();
			return choiceAnswerConverter.toDTOList(choiceAnswerEntities);
		}
		return null;
	}

	@Override
	public ChoiceAnswerDTO findOneById(Long id) {
		ChoiceAnswerEntity choiceAnswerEntity = choiceAnswerRepository.findOne(id);
		return choiceAnswerConverter.toDTO(choiceAnswerEntity);
	}

	@Override
	public ChoiceAnswerDTO save(ChoiceAnswerDTO choiceAnswerDTO) {
		ChoiceAnswerEntity choiceAnswerEntity = null;
		
		if(choiceAnswerDTO.getId() != null) {
			choiceAnswerEntity = choiceAnswerRepository.findOne(choiceAnswerDTO.getId());
			if(choiceAnswerDTO.getContent() != null) choiceAnswerEntity.setContent(choiceAnswerDTO.getContent());
			if(choiceAnswerDTO.getType() != null) choiceAnswerEntity.setType(choiceAnswerDTO.getType());
			if(choiceAnswerDTO.getCorrect() != null) choiceAnswerEntity.setCorrect(choiceAnswerDTO.getCorrect());
		}
		else {
			choiceAnswerEntity = choiceAnswerConverter.toEntity(choiceAnswerDTO);
			
			if(choiceAnswerDTO.getChoiceQuestionId() != null) {
				ChoiceQuestionEntity choiceQuestionEntity = choiceQuestionRepository.findOne(choiceAnswerDTO.getChoiceQuestionId());
				choiceAnswerEntity.setChoiceQuestion(choiceQuestionEntity);				
			}
			if(choiceAnswerDTO.getType().equals("text")) {
				choiceAnswerEntity.setContent(choiceAnswerDTO.getContent());
			}
			else if(choiceAnswerDTO.getType().equals("audio")){
				FileEntity fileEntity = new FileEntity();
				fileEntity.setData(choiceAnswerDTO.getContent());
			}
			else if(choiceAnswerDTO.getType().equals("image")){
				FileEntity fileEntity = new FileEntity();
				fileEntity.setData(choiceAnswerDTO.getContent());
			}
		}
		
		if(choiceAnswerEntity != null) {
			choiceAnswerEntity = choiceAnswerRepository.save(choiceAnswerEntity);
			return choiceAnswerConverter.toDTO(choiceAnswerEntity);
		}
		
		return null;
	}

	@Override
	public void delete(ChoiceAnswerDTO choiceAnswerDTO) {
		ChoiceAnswerEntity choiceAnswerEntity = choiceAnswerRepository.findOne(choiceAnswerDTO.getId());
		choiceAnswerRepository.delete(choiceAnswerEntity);
	}

}
