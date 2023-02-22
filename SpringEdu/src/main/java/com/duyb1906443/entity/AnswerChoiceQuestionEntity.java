package com.duyb1906443.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "answer_choice_question")
public class AnswerChoiceQuestionEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "submitted_exercise_id")
	private SubmittedExerciseEntity submittedExercise;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "choice_answer_id")
	private ChoiceAnswerEntity choiceAnswer;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "choice_question_of_class_excercise_id")
	private ChoiceQuestionOfClassExcerciseEntity choiceQuestionOfClassExcercise;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public SubmittedExerciseEntity getSubmittedExercise() {
		return submittedExercise;
	}

	public void setSubmittedExercise(SubmittedExerciseEntity submittedExercise) {
		this.submittedExercise = submittedExercise;
	}

	public ChoiceAnswerEntity getChoiceAnswer() {
		return choiceAnswer;
	}

	public void setChoiceAnswer(ChoiceAnswerEntity choiceAnswer) {
		this.choiceAnswer = choiceAnswer;
	}

	public ChoiceQuestionOfClassExcerciseEntity getChoiceQuestionOfClassExcercise() {
		return choiceQuestionOfClassExcercise;
	}

	public void setChoiceQuestionOfClassExcercise(ChoiceQuestionOfClassExcerciseEntity choiceQuestionOfClassExcercise) {
		this.choiceQuestionOfClassExcercise = choiceQuestionOfClassExcercise;
	}
	
}
