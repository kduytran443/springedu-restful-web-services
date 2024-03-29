package com.duyb1906443.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duyb1906443.converter.ChoiceQuestionConverter;
import com.duyb1906443.converter.FileConverter;
import com.duyb1906443.dto.ChoiceQuestionDTO;
import com.duyb1906443.entity.ChoiceQuestionEntity;
import com.duyb1906443.entity.FileEntity;
import com.duyb1906443.entity.QuestionBankEntity;
import com.duyb1906443.repository.ChoiceQuestionRepository;
import com.duyb1906443.repository.FileRepository;
import com.duyb1906443.repository.QuestionBankRepository;
import com.duyb1906443.service.ChoiceQuestionService;

@Service
public class ChoiceQuestionServiceImpl implements ChoiceQuestionService {

	@Autowired
	private ChoiceQuestionConverter choiceQuestionConverter;

	@Autowired
	private ChoiceQuestionRepository choiceQuestionRepository;

	@Autowired
	private QuestionBankRepository questionBankRepository;
	
	@Autowired
	private FileRepository fileRepository;
	
	@Autowired
	private FileConverter fileConverter;
	
	@Override
	public List<ChoiceQuestionDTO> findAllByQuestionBankId(Long questionBankId) {
		QuestionBankEntity questionBankEntity = questionBankRepository.findOne(questionBankId);

		List<ChoiceQuestionEntity> choiceQuestionEntities = questionBankEntity.getChoiceQuestions();

		if (choiceQuestionEntities != null) {
			choiceQuestionEntities = choiceQuestionEntities.stream()
					.filter(choiceQuestion -> choiceQuestion.getStatus() == 1).collect(Collectors.toList());
			return choiceQuestionConverter.toDTOList(choiceQuestionEntities);
		}

		return null;
	}

	@Override
	public ChoiceQuestionDTO findOneById(Long id) {
		ChoiceQuestionEntity choiceQuestionEntity = choiceQuestionRepository.findOne(id);

		if (choiceQuestionEntity != null) {
			return choiceQuestionConverter.toDTO(choiceQuestionEntity);
		}

		return null;
	}

	@Override
	public ChoiceQuestionDTO save(ChoiceQuestionDTO choiceQuestionDTO) {
		ChoiceQuestionEntity choiceQuestionEntity = null;
		if (choiceQuestionDTO.getId() != null) {
			choiceQuestionEntity = choiceQuestionRepository.findOne(choiceQuestionDTO.getId());
			if(choiceQuestionDTO.getName() != null) choiceQuestionEntity.setName(choiceQuestionDTO.getName());
			if(choiceQuestionDTO.getContent() != null) choiceQuestionEntity.setContent(choiceQuestionDTO.getContent());
			if(choiceQuestionDTO.getImportant() != null) {
				choiceQuestionEntity.setImportant(choiceQuestionDTO.getImportant());
			}
			if(choiceQuestionDTO.getFile() != null) {
				FileEntity fileEntity = fileConverter.toEntity(choiceQuestionDTO.getFile());
				fileEntity = fileRepository.save(fileEntity);
				choiceQuestionEntity.setFile(fileEntity);
			}
			
		} else {
			choiceQuestionEntity = choiceQuestionConverter.toEntity(choiceQuestionDTO);
			QuestionBankEntity questionBankEntity = questionBankRepository.findOne(choiceQuestionDTO.getQuestionBank());
			choiceQuestionEntity.setQuestionBank(questionBankEntity);
			choiceQuestionEntity.setStatus(1);
			if(choiceQuestionDTO.getImportant() == null) {
				choiceQuestionEntity.setImportant(0);
			}
			
			if(choiceQuestionDTO.getFile() != null) {
				FileEntity fileEntity = fileConverter.toEntity(choiceQuestionDTO.getFile());
				fileEntity = fileRepository.save(fileEntity);
				choiceQuestionEntity.setFile(fileEntity);
			}
			
		}

		if (choiceQuestionEntity != null) {
			choiceQuestionEntity = choiceQuestionRepository.save(choiceQuestionEntity);
			return choiceQuestionConverter.toDTO(choiceQuestionEntity);
		}

		return null;
	}

	@Override
	public void delete(ChoiceQuestionDTO choiceQuestionDTO) {
		ChoiceQuestionEntity choiceQuestionEntity = choiceQuestionRepository.findOne(choiceQuestionDTO.getId());
		choiceQuestionEntity.setStatus(0);
		choiceQuestionRepository.save(choiceQuestionEntity);
	}

}
