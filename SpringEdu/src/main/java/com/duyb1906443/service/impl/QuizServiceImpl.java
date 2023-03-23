package com.duyb1906443.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duyb1906443.converter.QuizConverter;
import com.duyb1906443.dto.QuizDTO;
import com.duyb1906443.entity.ClassExcerciseEntity;
import com.duyb1906443.entity.QuizEntity;
import com.duyb1906443.repository.ClassExcerciseRepository;
import com.duyb1906443.repository.QuizRepository;
import com.duyb1906443.service.QuizService;

@Service
public class QuizServiceImpl implements QuizService {

	@Autowired
	private ClassExcerciseRepository classExcerciseRepository;

	@Autowired
	private QuizConverter quizConverter;

	@Autowired
	private QuizRepository quizRepository;

	@Override
	public QuizDTO findOneByClassExcerciseId(Long exerciseId) {
		ClassExcerciseEntity classExcerciseEntity = classExcerciseRepository.findOne(exerciseId);

		if (classExcerciseEntity != null) {
			QuizEntity quizEntity = classExcerciseEntity.getQuiz();
			if (quizEntity != null) {
				return quizConverter.toDTO(quizEntity);
			}
		}

		return null;
	}

	@Override
	public QuizDTO findOneById(Long id) {
		QuizEntity quizEntity = quizRepository.findOne(id);
		if (quizEntity != null) {
			return quizConverter.toDTO(quizEntity);
		}
		return null;
	}

	@Override
	public QuizDTO save(QuizDTO quizDTO) {
		QuizEntity quizEntity = null;
		if (quizDTO.getId() != null) {
			quizEntity = quizRepository.findOne(quizDTO.getId());
			quizEntity = quizConverter.toEntity(quizDTO);
		} else {
			quizEntity = quizConverter.toEntity(quizDTO);
			ClassExcerciseEntity classExcerciseEntity = classExcerciseRepository.findOne(quizDTO.getClassExcerciseId());
			quizEntity.setClassExcercise(classExcerciseEntity);
		}

		if (quizEntity != null) {
			quizEntity = quizRepository.save(quizEntity);
			return quizConverter.toDTO(quizEntity);
		}

		return null;
	}

	@Override
	public void delete(QuizDTO quizDTO) {
		QuizEntity quizEntity = quizRepository.findOne(quizDTO.getId());
		quizRepository.delete(quizEntity);
	}

}
