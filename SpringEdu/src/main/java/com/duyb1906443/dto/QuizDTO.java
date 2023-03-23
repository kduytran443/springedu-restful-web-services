package com.duyb1906443.dto;

public class QuizDTO {
	private Long id;
	private Integer numberOfQuestion;
	private Float mark;
	private Long classExcerciseId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumberOfQuestion() {
		return numberOfQuestion;
	}

	public void setNumberOfQuestion(Integer numberOfQuestion) {
		this.numberOfQuestion = numberOfQuestion;
	}

	public Float getMark() {
		return mark;
	}

	public void setMark(Float mark) {
		this.mark = mark;
	}

	public Long getClassExcerciseId() {
		return classExcerciseId;
	}

	public void setClassExcerciseId(Long classExcerciseId) {
		this.classExcerciseId = classExcerciseId;
	}

}
