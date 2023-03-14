package com.duyb1906443.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "`quiz`")
public class QuizEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private int numberOfQuestion;

	@Column
	private float mark;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "class_excercise_id")
	private ClassExcerciseEntity classExcercise;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "quiz")
	private List<DrawQuizEntity> drawQuizzes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNumberOfQuestion() {
		return numberOfQuestion;
	}

	public void setNumberOfQuestion(int numberOfQuestion) {
		this.numberOfQuestion = numberOfQuestion;
	}

	public float getMark() {
		return mark;
	}

	public void setMark(float mark) {
		this.mark = mark;
	}

	public ClassExcerciseEntity getClassExcercise() {
		return classExcercise;
	}

	public void setClassExcercise(ClassExcerciseEntity classExcercise) {
		this.classExcercise = classExcercise;
	}

	public List<DrawQuizEntity> getDrawQuizzes() {
		return drawQuizzes;
	}

	public void setDrawQuizzes(List<DrawQuizEntity> drawQuizzes) {
		this.drawQuizzes = drawQuizzes;
	}

}
