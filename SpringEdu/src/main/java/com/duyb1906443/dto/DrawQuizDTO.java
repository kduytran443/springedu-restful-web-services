package com.duyb1906443.dto;

import java.util.List;

public class DrawQuizDTO {
	private Long id;
	private Long quizId;
	private Integer quizNumberOfQuestion;
	private ChoiceQuestionDTO choiceQuestion;
	private Long submittedExerciseId;
	private String username;
	private Long classExerciseId;
	private List<Long> choiceAnswers;

	public List<Long> getChoiceAnswers() {
		return choiceAnswers;
	}

	public void setChoiceAnswers(List<Long> choiceAnswers) {
		this.choiceAnswers = choiceAnswers;
	}

	public Long getClassExerciseId() {
		return classExerciseId;
	}

	public void setClassExerciseId(Long classExerciseId) {
		this.classExerciseId = classExerciseId;
	}

	public Integer getQuizNumberOfQuestion() {
		return quizNumberOfQuestion;
	}

	public void setQuizNumberOfQuestion(Integer quizNumberOfQuestion) {
		this.quizNumberOfQuestion = quizNumberOfQuestion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getQuizId() {
		return quizId;
	}

	public void setQuizId(Long quizId) {
		this.quizId = quizId;
	}

	public ChoiceQuestionDTO getChoiceQuestion() {
		return choiceQuestion;
	}

	public void setChoiceQuestion(ChoiceQuestionDTO choiceQuestion) {
		this.choiceQuestion = choiceQuestion;
	}

	public Long getSubmittedExerciseId() {
		return submittedExerciseId;
	}

	public void setSubmittedExerciseId(Long submittedExerciseId) {
		this.submittedExerciseId = submittedExerciseId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
