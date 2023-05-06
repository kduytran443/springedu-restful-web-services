package com.duyb1906443.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duyb1906443.converter.DrawQuizConverter;
import com.duyb1906443.dto.DrawQuizDTO;
import com.duyb1906443.entity.ChoiceAnswerEntity;
import com.duyb1906443.entity.ChoiceQuestionEntity;
import com.duyb1906443.entity.ClassExcerciseEntity;
import com.duyb1906443.entity.DrawQuizEntity;
import com.duyb1906443.entity.QuestionBankEntity;
import com.duyb1906443.entity.QuizEntity;
import com.duyb1906443.entity.SubmittedExerciseEntity;
import com.duyb1906443.repository.ChoiceAnswerRepository;
import com.duyb1906443.repository.ChoiceQuestionRepository;
import com.duyb1906443.repository.ClassExcerciseRepository;
import com.duyb1906443.repository.DrawQuizRepository;
import com.duyb1906443.repository.QuizRepository;
import com.duyb1906443.repository.SubmittedExerciseRepository;
import com.duyb1906443.service.DrawQuizService;

@Service
public class DrawQuizServiceImpl implements DrawQuizService {

	@Autowired
	private DrawQuizRepository drawQuizRepository;

	@Autowired
	private DrawQuizConverter drawQuizConverter;

	@Autowired
	private ClassExcerciseRepository classExcerciseRepository;

	@Autowired
	private QuizRepository quizRepository;

	@Autowired
	private SubmittedExerciseRepository submittedExerciseRepository;

	@Autowired
	private ChoiceQuestionRepository choiceQuestionRepository;

	@Autowired
	private ChoiceAnswerRepository choiceAnswerRepository;

	@Override
	public DrawQuizDTO findOneById(Long drawQuizId) {
		DrawQuizEntity drawQuizEntity = drawQuizRepository.findOne(drawQuizId);
		return drawQuizConverter.toDTO(drawQuizEntity);
	}

	@Override
	public DrawQuizDTO save(DrawQuizDTO drawQuizDTO) {
		return null;
	}

	@Override
	public void delete(DrawQuizDTO drawQuizDTO) {

	}

	@Override
	public List<DrawQuizDTO> findAllByClassExcerciseId(Long classExcerciseId) {
		ClassExcerciseEntity classExcerciseEntity = classExcerciseRepository.findOne(classExcerciseId);
		List<DrawQuizEntity> drawQuizEntities = classExcerciseEntity.getQuiz().getDrawQuizzes();
		return drawQuizConverter.toDTOList(drawQuizEntities);
	}

	@Override
	public List<DrawQuizDTO> findAllByQuizId(Long quizId) {
		QuizEntity quizEntity = quizRepository.findOne(quizId);
		List<DrawQuizEntity> drawQuizEntities = quizEntity.getDrawQuizzes();
		return drawQuizConverter.toDTOList(drawQuizEntities);
	}

	@Override
	public List<DrawQuizDTO> findAllBySubmittedExerciseId(Long submittedExerciseId) {
		SubmittedExerciseEntity submittedExerciseEntity = submittedExerciseRepository.findOne(submittedExerciseId);
		List<DrawQuizEntity> drawQuizEntities = submittedExerciseEntity.getDrawQuizzes();
		return drawQuizConverter.toDTOList(drawQuizEntities);
	}

	private boolean checkExisted(List<Long> ids, Long id) {
		boolean result = false;

		for (Long l : ids) {
			if (l.equals(id)) {
				result = true;
				break;
			}
		}

		return result;
	}

	@Override
	public List<DrawQuizDTO> drawRandom(DrawQuizDTO drawQuizDTO) { // getClassExerciseId, QuizNumberOfQuestion, QuizId,
																	// SubmittedExerciseId
		ClassExcerciseEntity classExcerciseEntity = classExcerciseRepository.findOne(drawQuizDTO.getClassExerciseId());
		QuestionBankEntity questionBankEntity = classExcerciseEntity.getQuestionBank();

		if (questionBankEntity != null) {
			List<ChoiceQuestionEntity> choiceQuestionEntities = questionBankEntity.getChoiceQuestions();
			int numberOfQuestion = drawQuizDTO.getQuizNumberOfQuestion();
			Random rand = new Random();
			List<Long> choiceQuestionIds = new ArrayList<>();
			for (ChoiceQuestionEntity entity : choiceQuestionEntities) {
				choiceQuestionIds.add(entity.getId());
			}

			List<Long> randomChoiceQuestionIds = new ArrayList<>();
			while (randomChoiceQuestionIds.size() < numberOfQuestion) {
				int randomIndex = rand.nextInt(choiceQuestionIds.size());
				Long randomValue = choiceQuestionIds.get(randomIndex);

				if (!checkExisted(randomChoiceQuestionIds, randomValue)
						&& randomChoiceQuestionIds.size() < numberOfQuestion) {
					randomChoiceQuestionIds.add(randomValue);
				}
			}

			List<DrawQuizEntity> drawQuizEntities = new ArrayList<>();
			// note
			if (randomChoiceQuestionIds.size() == numberOfQuestion) {
				for (Long l : randomChoiceQuestionIds) {
					DrawQuizEntity drawQuizEntity = new DrawQuizEntity();
					ChoiceQuestionEntity choiceQuestionEntity = choiceQuestionRepository.findOne(l);
					drawQuizEntity.setChoiceQuestion(choiceQuestionEntity);

					QuizEntity quizEntity = classExcerciseEntity.getQuiz();
					drawQuizEntity.setQuiz(quizEntity);

					SubmittedExerciseEntity submittedExerciseEntity = submittedExerciseRepository
							.findOne(drawQuizDTO.getSubmittedExerciseId());
					drawQuizEntity.setSubmittedExercise(submittedExerciseEntity);

					drawQuizEntity = drawQuizRepository.save(drawQuizEntity);
					drawQuizEntities.add(drawQuizEntity);
				}
			}
			return drawQuizConverter.toDTOList(drawQuizEntities);

		}

		return null;
	}

	@Override
	public DrawQuizDTO answerChoice(DrawQuizDTO drawQuizDTO, Long choiceAnswerId) {
		DrawQuizEntity drawQuizEntity = drawQuizRepository.findOne(drawQuizDTO.getId());

		List<ChoiceAnswerEntity> choiceAnswerEntities = drawQuizEntity.getChoiceAnswers();
		boolean isChoice = choiceAnswerEntities.stream().anyMatch(entity -> entity.getId() == choiceAnswerId);
		if (!isChoice) {
			ChoiceAnswerEntity choiceAnswerEntity = choiceAnswerRepository.findOne(choiceAnswerId);
			choiceAnswerEntities.add(choiceAnswerEntity);
			drawQuizEntity.setChoiceAnswers(choiceAnswerEntities);
			drawQuizEntity = drawQuizRepository.save(drawQuizEntity);
			return drawQuizConverter.toDTO(drawQuizEntity);
		}
		else {
			ChoiceAnswerEntity choiceAnswerEntity = null;
			for (ChoiceAnswerEntity entity : choiceAnswerEntities) {
				if(entity.getId() == choiceAnswerId) {
					choiceAnswerEntity = entity;
					break;
				}
			}
			if(choiceAnswerEntity != null) {
				choiceAnswerEntities.remove(choiceAnswerEntity);
				drawQuizEntity.setChoiceAnswers(choiceAnswerEntities);
				drawQuizEntity = drawQuizRepository.save(drawQuizEntity);
				return drawQuizConverter.toDTO(drawQuizEntity);
			}
		}

		return null;
	}

	@Override
	public List<DrawQuizDTO> findAllChoiceAnswerByDrawQuizId(Long drawQuizId) {
		
		
		return null;
	}

}
