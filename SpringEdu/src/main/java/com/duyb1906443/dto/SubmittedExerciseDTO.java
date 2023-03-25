package com.duyb1906443.dto;

import java.sql.Timestamp;
import java.util.List;

public class SubmittedExerciseDTO {
	private Long id;
	private Timestamp submitTime;
	private Timestamp startTime;
	private Float mark;
	private String content;
	private String username;
	private Long userId;
	private ClassExcerciseDTO classExcercise;
	private List<DrawQuizDTO> drawQuizzes;
	private Float quizMark;
	private Float constructedResponseMark;
	private String userAvatar;

	public String getUserAvatar() {
		return userAvatar;
	}

	public void setUserAvatar(String userAvatar) {
		this.userAvatar = userAvatar;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getSubmitTime() {
		return submitTime;
	}

	public void setSubmitTime(Timestamp submitTime) {
		this.submitTime = submitTime;
	}

	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Float getMark() {
		return mark;
	}

	public void setMark(Float mark) {
		this.mark = mark;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public ClassExcerciseDTO getClassExcercise() {
		return classExcercise;
	}

	public void setClassExcercise(ClassExcerciseDTO classExcercise) {
		this.classExcercise = classExcercise;
	}

	public List<DrawQuizDTO> getDrawQuizzes() {
		return drawQuizzes;
	}

	public void setDrawQuizzes(List<DrawQuizDTO> drawQuizzes) {
		this.drawQuizzes = drawQuizzes;
	}

	public Float getQuizMark() {
		return quizMark;
	}

	public void setQuizMark(Float quizMark) {
		this.quizMark = quizMark;
	}

	public Float getConstructedResponseMark() {
		return constructedResponseMark;
	}

	public void setConstructedResponseMark(Float constructedResponseMark) {
		this.constructedResponseMark = constructedResponseMark;
	}

}
