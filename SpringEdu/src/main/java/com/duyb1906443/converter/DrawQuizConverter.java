package com.duyb1906443.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.duyb1906443.dto.DrawQuizDTO;
import com.duyb1906443.entity.DrawQuizEntity;

@Component
public class DrawQuizConverter implements IConverterToDTO<DrawQuizEntity, DrawQuizDTO> {

	@Autowired
	private ChoiceQuestionConverter choiceQuestionConverter;

	@Override
	public DrawQuizDTO toDTO(DrawQuizEntity entity) {

		DrawQuizDTO dto = new DrawQuizDTO();

		if (entity.getChoiceQuestion() != null) {
			dto.setChoiceQuestion(choiceQuestionConverter.toDTO(entity.getChoiceQuestion()));
		}

		dto.setId(entity.getId());
		dto.setQuizId(entity.getQuiz().getId());
		dto.setSubmittedExerciseId(entity.getSubmittedExercise().getId());
		dto.setUsername(entity.getSubmittedExercise().getUser().getUsername());

		return dto;
	}

	@Override
	public List<DrawQuizDTO> toDTOList(List<DrawQuizEntity> entities) {
		return entities.stream().map(entity -> toDTO(entity)).collect(Collectors.toList());
	}

}
