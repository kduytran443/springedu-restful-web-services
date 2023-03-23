package com.duyb1906443.dto;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class ClassExcerciseDTO {
	private Long id;
	private String name;
	private Timestamp createdTime;
	private Timestamp startTime;
	private Timestamp endTime;
	private Integer effective;
	private Long classId;
	private Float mark;
	private Integer timeLimit;
	private Long questionBankId;
	private Integer isQuizTest;
	private Integer quizNumberOfQuestion;
	private Integer isConstructedResponseTest;

	public Integer getQuizNumberOfQuestion() {
		return quizNumberOfQuestion;
	}

	public void setQuizNumberOfQuestion(Integer quizNumberOfQuestion) {
		this.quizNumberOfQuestion = quizNumberOfQuestion;
	}

	public Integer getIsQuizTest() {
		return isQuizTest;
	}

	public void setIsQuizTest(Integer isQuizTest) {
		this.isQuizTest = isQuizTest;
	}

	public Integer getIsConstructedResponseTest() {
		return isConstructedResponseTest;
	}

	public void setIsConstructedResponseTest(Integer isConstructedResponseTest) {
		this.isConstructedResponseTest = isConstructedResponseTest;
	}

	public Long getQuestionBankId() {
		return questionBankId;
	}

	public void setQuestionBankId(Long questionBankId) {
		this.questionBankId = questionBankId;
	}

	public Integer getTimeLimit() {
		return timeLimit;
	}

	public void setTimeLimit(Integer timeLimit) {
		this.timeLimit = timeLimit;
	}

	public Float getMark() {
		return mark;
	}

	public void setMark(Float mark) {
		this.mark = mark;
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

	public void setEffective(Integer effective) {
		this.effective = effective;
	}

	public Long getClassId() {
		return classId;
	}

	public void setClassId(Long classId) {
		this.classId = classId;
	}

}
