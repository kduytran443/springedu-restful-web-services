package com.duyb1906443.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duyb1906443.converter.SubmittedExerciseConverter;
import com.duyb1906443.dto.ScoreDTO;
import com.duyb1906443.dto.SubmittedExerciseDTO;
import com.duyb1906443.entity.ChoiceAnswerEntity;
import com.duyb1906443.entity.ChoiceQuestionEntity;
import com.duyb1906443.entity.ClassEntity;
import com.duyb1906443.entity.ClassExcerciseEntity;
import com.duyb1906443.entity.DrawQuizEntity;
import com.duyb1906443.entity.SubmittedExerciseEntity;
import com.duyb1906443.entity.UserEntity;
import com.duyb1906443.repository.ChoiceAnswerRepository;
import com.duyb1906443.repository.ClassExcerciseRepository;
import com.duyb1906443.repository.ClassRepository;
import com.duyb1906443.repository.DrawQuizRepository;
import com.duyb1906443.repository.SubmittedExerciseRepository;
import com.duyb1906443.repository.UserRepository;
import com.duyb1906443.service.SubmittedExerciseService;

@Service
public class SubmittedExerciseServiceImpl implements SubmittedExerciseService {

	@Autowired
	private SubmittedExerciseRepository submittedExerciseRepository;

	@Autowired
	private ClassExcerciseRepository classExcerciseRepository;

	@Autowired
	private SubmittedExerciseConverter submittedExerciseConverter;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private DrawQuizRepository drawQuizRepository;

	@Autowired
	private ChoiceAnswerRepository choiceAnswerRepository;

	@Autowired
	private ClassRepository classRepository;

	@Override
	public List<SubmittedExerciseDTO> findAllByClassExcercise(Long classExcerciseId) {
		ClassExcerciseEntity classExcerciseEntity = classExcerciseRepository.findOne(classExcerciseId);

		List<SubmittedExerciseEntity> submittedExerciseEntities = classExcerciseEntity.getSubmittedExercises();

		if (submittedExerciseEntities != null) {
			return submittedExerciseConverter.toDTOList(submittedExerciseEntities);
		}

		return null;
	}

	@Override
	public SubmittedExerciseDTO findOneById(Long id) {
		SubmittedExerciseEntity submittedExerciseEntity = submittedExerciseRepository.findOne(id);
		return submittedExerciseConverter.toDTO(submittedExerciseEntity);
	}

	@Override
	public SubmittedExerciseDTO save(SubmittedExerciseDTO submittedExerciseDTO) {
		SubmittedExerciseEntity submittedExerciseEntity = null;

		if (submittedExerciseDTO.getId() != null) {
			submittedExerciseEntity = submittedExerciseRepository.findOne(submittedExerciseDTO.getId());
			submittedExerciseEntity = submittedExerciseConverter.toEntity(submittedExerciseDTO,
					submittedExerciseEntity);
		} else {
			submittedExerciseEntity = submittedExerciseConverter.toEntity(submittedExerciseDTO);

			Date date = new Date();
			submittedExerciseEntity.setStartTime(new Timestamp(date.getTime()));

			ClassExcerciseEntity classExcerciseEntity = classExcerciseRepository
					.findOne(submittedExerciseDTO.getClassExcercise().getId());
			submittedExerciseEntity.setClassExcercise(classExcerciseEntity);

			submittedExerciseEntity.setFiles(null);

			UserEntity userEntity = userRepository.findOne(submittedExerciseDTO.getUserId());
			submittedExerciseEntity.setUser(userEntity);
		}

		if (submittedExerciseEntity != null) {
			submittedExerciseEntity = submittedExerciseRepository.save(submittedExerciseEntity);
			return submittedExerciseConverter.toDTO(submittedExerciseEntity);
		}

		return null;
	}

	@Override
	public void delete(SubmittedExerciseDTO submittedExerciseDTO) {
		SubmittedExerciseEntity submittedExerciseEntity = submittedExerciseRepository
				.findOne(submittedExerciseDTO.getId());
		submittedExerciseRepository.delete(submittedExerciseEntity);
	}

	@Override
	public List<SubmittedExerciseDTO> findAllByClassExerciseIdAndUserId(Long classExerciseId, Long userId) {

		UserEntity userEntity = userRepository.findOne(userId);
		ClassExcerciseEntity classExcerciseEntity = classExcerciseRepository.findOne(classExerciseId);

		List<SubmittedExerciseEntity> submittedExerciseEntities = submittedExerciseRepository
				.findAllByUserAndClassExcercise(userEntity, classExcerciseEntity);

		return submittedExerciseConverter.toDTOList(submittedExerciseEntities);
	}

	@Override
	public SubmittedExerciseDTO submit(SubmittedExerciseDTO submittedExerciseDTO) {
		SubmittedExerciseEntity submittedExerciseEntity = submittedExerciseRepository
				.findOne(submittedExerciseDTO.getId());
		Date date = new Date();

		submittedExerciseEntity.setSubmitTime(new Timestamp(date.getTime()));

		if (submittedExerciseEntity.getClassExcercise().getQuiz() != null) { // is quiz
			int correctCounter = 0;
			List<DrawQuizEntity> drawQuizEntities = drawQuizRepository
					.findAllBySubmittedExercise(submittedExerciseEntity);
			for (DrawQuizEntity drawQuizEntity : drawQuizEntities) {
				ChoiceQuestionEntity choiceQuestionEntity = drawQuizEntity.getChoiceQuestion();

				List<ChoiceAnswerEntity> answerEntities = drawQuizEntity.getChoiceAnswers().stream()
						.filter(entity -> entity.getChoiceQuestion().getId() == choiceQuestionEntity.getId()
								&& entity.getStatus() == 1)
						.collect(Collectors.toList());

				if (answerEntities != null && answerEntities.size() > 0) {
					correctCounter += 1;
				}

				for (ChoiceAnswerEntity entity : answerEntities) {
					if (entity.getCorrect() == 0) {
						correctCounter -= 1;
						break;
					}
				}
			}

			int totalQuestion = submittedExerciseEntity.getClassExcercise().getQuiz().getNumberOfQuestion();

			float correctPercent = (float) correctCounter / totalQuestion;

			float obtainMark = correctPercent * submittedExerciseEntity.getClassExcercise().getMark();
			submittedExerciseEntity.setMark(obtainMark);
		} else {
			submittedExerciseEntity.setContent(submittedExerciseDTO.getContent());
		}

		submittedExerciseEntity = submittedExerciseRepository.save(submittedExerciseEntity);
		return submittedExerciseConverter.toDTO(submittedExerciseEntity);
	}

	@Override
	public SubmittedExerciseDTO grade(ScoreDTO scoreDTO) {
		SubmittedExerciseEntity submittedExerciseEntity = submittedExerciseRepository.findOne(scoreDTO.getSubmittedExerciseId());

		submittedExerciseEntity.setTeacherComment(scoreDTO.getTeacherComment());
		submittedExerciseEntity.setMark(scoreDTO.getMark());

		submittedExerciseEntity = submittedExerciseRepository.save(submittedExerciseEntity);
		return submittedExerciseConverter.toDTO(submittedExerciseEntity);
	}

	@Override
	public List<SubmittedExerciseDTO> findAllByClassIdAndUserId(Long classId, Long userId) {

		UserEntity userEntity = userRepository.findOne(userId);
		ClassEntity classEntity = classRepository.findOne(classId);
		List<ClassExcerciseEntity> classExcerciseEntities = classEntity.getClassExcercises().stream()
				.filter(entity -> entity.getStatus() == 1).collect(Collectors.toList());

		List<SubmittedExerciseEntity> submittedExerciseEntities = new ArrayList<>();

		for (ClassExcerciseEntity classExcerciseEntity : classExcerciseEntities) {
			List<SubmittedExerciseEntity> entities = submittedExerciseRepository
					.findAllByUserAndClassExcercise(userEntity, classExcerciseEntity);
			if (entities != null) {
				submittedExerciseEntities.addAll(entities);
			}
		}

		return submittedExerciseConverter.toDTOList(submittedExerciseEntities);
	}

}
