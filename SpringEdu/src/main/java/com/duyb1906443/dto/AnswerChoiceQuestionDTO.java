package com.duyb1906443.dto;

public class AnswerChoiceQuestionDTO {
	private Long id;
	private Long submittedExercise;
	private Long choiceAnswer;
	private Long choiceQuestionOfClassExcercise;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSubmittedExercise() {
		return submittedExercise;
	}

	public void setSubmittedExercise(Long submittedExercise) {
		this.submittedExercise = submittedExercise;
	}

	public Long getChoiceAnswer() {
		return choiceAnswer;
	}

	public void setChoiceAnswer(Long choiceAnswer) {
		this.choiceAnswer = choiceAnswer;
	}

	public Long getChoiceQuestionOfClassExcercise() {
		return choiceQuestionOfClassExcercise;
	}

	public void setChoiceQuestionOfClassExcercise(Long choiceQuestionOfClassExcercise) {
		this.choiceQuestionOfClassExcercise = choiceQuestionOfClassExcercise;
	}

}
