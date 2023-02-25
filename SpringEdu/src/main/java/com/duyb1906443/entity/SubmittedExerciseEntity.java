package com.duyb1906443.entity;

import java.util.Date;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "submitted_exercise")
public class SubmittedExerciseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private Date submitTime;
	
	@Column
	private float mark;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "text_data_id")
	private TextDataEntity textData;

	@OneToMany(mappedBy = "submittedExercise", fetch = FetchType.LAZY)
	private List<FileEntity> files;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private UserEntity user;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "class_excercise_id")
	private ClassExcerciseEntity classExcercise;
	
	@OneToMany(mappedBy = "submittedExercise", fetch = FetchType.LAZY)
	private List<AnswerChoiceQuestionEntity> answerChoiceQuestions;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getSubmitTime() {
		return submitTime;
	}

	public void setSubmitTime(Date submitTime) {
		this.submitTime = submitTime;
	}

	public float getMark() {
		return mark;
	}

	public void setMark(float mark) {
		this.mark = mark;
	}

	public TextDataEntity getTextData() {
		return textData;
	}

	public void setTextData(TextDataEntity textData) {
		this.textData = textData;
	}

	public List<FileEntity> getFiles() {
		return files;
	}

	public void setFiles(List<FileEntity> files) {
		this.files = files;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public ClassExcerciseEntity getClassExcercise() {
		return classExcercise;
	}

	public void setClassExcercise(ClassExcerciseEntity classExcercise) {
		this.classExcercise = classExcercise;
	}

	public List<AnswerChoiceQuestionEntity> getAnswerChoiceQuestions() {
		return answerChoiceQuestions;
	}

	public void setAnswerChoiceQuestions(List<AnswerChoiceQuestionEntity> answerChoiceQuestions) {
		this.answerChoiceQuestions = answerChoiceQuestions;
	}
	
}