package com.duyb1906443.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duyb1906443.converter.ChoiceAnswerConverter;
import com.duyb1906443.dto.ChoiceAnswerDTO;
import com.duyb1906443.entity.ChoiceAnswerEntity;
import com.duyb1906443.entity.ChoiceQuestionEntity;
import com.duyb1906443.entity.DrawQuizEntity;
import com.duyb1906443.entity.FileEntity;
import com.duyb1906443.repository.ChoiceAnswerRepository;
import com.duyb1906443.repository.ChoiceQuestionRepository;
import com.duyb1906443.repository.DrawQuizRepository;
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

	@Autowired
	private DrawQuizRepository drawQuizRepository;

	@Override
	public List<ChoiceAnswerDTO> findAllByChoiceQuestionId(Long choiceQuestionId) {
		ChoiceQuestionEntity choiceQuestionEntity = choiceQuestionRepository.findOne(choiceQuestionId);
		if (choiceQuestionEntity != null) {
			List<ChoiceAnswerEntity> choiceAnswerEntities = choiceQuestionEntity.getChoiceAnswers().stream()
					.filter(choiceAnswer -> choiceAnswer.getStatus() == 1).collect(Collectors.toList());
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
		if (choiceAnswerDTO.getId() != null) {
			choiceAnswerEntity = choiceAnswerRepository.findOne(choiceAnswerDTO.getId());
			if(choiceAnswerDTO.getType() != null) choiceAnswerEntity.setType(choiceAnswerDTO.getType());

			if (choiceAnswerDTO.getType() != null)
				choiceAnswerEntity.setType(choiceAnswerDTO.getType());
			if (choiceAnswerDTO.getCorrect() != null)
				choiceAnswerEntity.setCorrect(choiceAnswerDTO.getCorrect());
			if (choiceAnswerDTO.getType().equals("text")) {
				choiceAnswerEntity.setContent(choiceAnswerDTO.getContent());
			} else if (choiceAnswerDTO.getType().equals("audio") || choiceAnswerDTO.getType().equals("image")) {
				FileEntity fileEntity = new FileEntity();
				fileEntity.setData(choiceAnswerDTO.getContent());
				
				fileEntity = fileRepository.save(fileEntity);
				
				choiceAnswerEntity.setFile(fileEntity);
			}
		} else {
			choiceAnswerEntity = choiceAnswerConverter.toEntity(choiceAnswerDTO);
			choiceAnswerEntity.setStatus(1);
			if (choiceAnswerDTO.getChoiceQuestionId() != null) {
				ChoiceQuestionEntity choiceQuestionEntity = choiceQuestionRepository
						.findOne(choiceAnswerDTO.getChoiceQuestionId());
				choiceAnswerEntity.setChoiceQuestion(choiceQuestionEntity);
			}
			if (choiceAnswerDTO.getType().equals("text")) {
				choiceAnswerEntity.setContent(choiceAnswerDTO.getContent());
			} else if (choiceAnswerDTO.getType().equals("audio")) {
				FileEntity fileEntity = new FileEntity();
				fileEntity.setData(choiceAnswerDTO.getContent());
				fileEntity = fileRepository.save(fileEntity);
				choiceAnswerEntity.setFile(fileEntity);
			} else if (choiceAnswerDTO.getType().equals("image")) {
				FileEntity fileEntity = new FileEntity();
				fileEntity.setData(choiceAnswerDTO.getContent());
				fileEntity = fileRepository.save(fileEntity);
				choiceAnswerEntity.setFile(fileEntity);
			}
		}

		if (choiceAnswerEntity != null) {
			choiceAnswerEntity = choiceAnswerRepository.save(choiceAnswerEntity);
			return choiceAnswerConverter.toDTO(choiceAnswerEntity);
		}

		return null;
	}

	@Override
	public void delete(ChoiceAnswerDTO choiceAnswerDTO) {
		ChoiceAnswerEntity choiceAnswerEntity = choiceAnswerRepository.findOne(choiceAnswerDTO.getId());
		choiceAnswerEntity.setStatus(0);
		choiceAnswerRepository.save(choiceAnswerEntity);
	}

	@Override
	public List<ChoiceAnswerDTO> findAllByDrawQuizId(Long drawQuizId) {

		DrawQuizEntity drawQuizEntity = drawQuizRepository.findOne(drawQuizId);

		if (drawQuizEntity != null) {
			List<ChoiceAnswerEntity> choiceAnswerEntities = drawQuizEntity.getChoiceAnswers();
			return choiceAnswerConverter.toDTOList(choiceAnswerEntities);
		}

		return null;
	}

}
