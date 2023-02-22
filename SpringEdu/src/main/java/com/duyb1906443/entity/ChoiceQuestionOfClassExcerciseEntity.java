package com.duyb1906443.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "choice_question_of_class_excercise")
public class ChoiceQuestionOfClassExcerciseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private float mark;
	
	@Column
	private int place;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "class_excercise_id")
	private ClassExcerciseEntity classExcercise;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "choice_question_id")
	private ChoiceQuestionEntity choiceQuestion;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "choiceQuestionOfClassExcercise")
	private List<AnswerChoiceQuestionEntity> answerChoiceQuestions;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public float getMark() {
		return mark;
	}

	public void setMark(float mark) {
		this.mark = mark;
	}

	public int getPlace() {
		return place;
	}

	public void setPlace(int place) {
		this.place = place;
	}

	public ClassExcerciseEntity getClassExcercise() {
		return classExcercise;
	}

	public void setClassExcercise(ClassExcerciseEntity classExcercise) {
		this.classExcercise = classExcercise;
	}

	public ChoiceQuestionEntity getChoiceQuestion() {
		return choiceQuestion;
	}

	public void setChoiceQuestion(ChoiceQuestionEntity choiceQuestion) {
		this.choiceQuestion = choiceQuestion;
	}

	public List<AnswerChoiceQuestionEntity> getAnswerChoiceQuestions() {
		return answerChoiceQuestions;
	}

	public void setAnswerChoiceQuestions(List<AnswerChoiceQuestionEntity> answerChoiceQuestions) {
		this.answerChoiceQuestions = answerChoiceQuestions;
	}
	
}
