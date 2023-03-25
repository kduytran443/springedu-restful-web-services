package com.duyb1906443.entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "class_excercise")
public class ClassExcerciseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(columnDefinition = "nvarchar(256)")
	private String name;

	@Column
	private Timestamp createdTime;

	@Column
	private Timestamp startTime;

	@Column
	private Timestamp endTime;

	@Column
	private Float mark;

	@Column
	private Float requiredMark;

	@Column(columnDefinition = "tinyint")
	private Integer effective;

	@Column
	private Integer status;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "class_id")
	private ClassEntity classEntity;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "class_excercise_file", joinColumns = @JoinColumn(name = "class_excercise_id"), inverseJoinColumns = @JoinColumn(name = "file_id"))
	private List<FileEntity> files;

	@OneToMany(mappedBy = "classExcercise", fetch = FetchType.LAZY)
	private List<SubmittedExerciseEntity> submittedExercises;

	@ManyToOne
	@JoinColumn(name = "question_bank_id")
	private QuestionBankEntity questionBank;

	@Column(nullable = true)
	private Integer timeLimit;

	@OneToOne(mappedBy = "classExcercise")
	private QuizEntity quiz;

	@OneToOne(mappedBy = "classExcercise")
	private ConstructedResponseTestEntity constructedResponseTests;

	public Float getRequiredMark() {
		return requiredMark;
	}

	public void setRequiredMark(Float requiredMark) {
		this.requiredMark = requiredMark;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getTimeLimit() {
		return timeLimit;
	}

	public void setTimeLimit(Integer timeLimit) {
		this.timeLimit = timeLimit;
	}

	public ConstructedResponseTestEntity getConstructedResponseTests() {
		return constructedResponseTests;
	}

	public void setConstructedResponseTests(ConstructedResponseTestEntity constructedResponseTests) {
		this.constructedResponseTests = constructedResponseTests;
	}

	public Float getMark() {
		return mark;
	}

	public void setMark(Float mark) {
		this.mark = mark;
	}

	public void setEffective(Integer effective) {
		this.effective = effective;
	}

	public QuizEntity getQuiz() {
		return quiz;
	}

	public void setQuiz(QuizEntity quiz) {
		this.quiz = quiz;
	}

	public QuestionBankEntity getQuestionBank() {
		return questionBank;
	}

	public void setQuestionBank(QuestionBankEntity questionBank) {
		this.questionBank = questionBank;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Timestamp createdTime) {
		this.createdTime = createdTime;
	}

	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getEndTime() {
		return endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public Integer getEffective() {
		return effective;
	}

	public ClassEntity getClassEntity() {
		return classEntity;
	}

	public void setClassEntity(ClassEntity classEntity) {
		this.classEntity = classEntity;
	}

	public List<FileEntity> getFiles() {
		return files;
	}

	public void setFiles(List<FileEntity> files) {
		this.files = files;
	}

	public List<SubmittedExerciseEntity> getSubmittedExercises() {
		return submittedExercises;
	}

	public void setSubmittedExercises(List<SubmittedExerciseEntity> submittedExercises) {
		this.submittedExercises = submittedExercises;
	}

}
