package com.duyb1906443.dto;

public class ChoiceQuestionReviewDTO {
	private Long id;
	private String name;
	private Integer choiceAnswers;
	private Long questionBank;
	private String content;

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

	public Integer getChoiceAnswers() {
		return choiceAnswers;
	}

	public void setChoiceAnswers(Integer choiceAnswers) {
		this.choiceAnswers = choiceAnswers;
	}

	public Long getQuestionBank() {
		return questionBank;
	}

	public void setQuestionBank(Long questionBank) {
		this.questionBank = questionBank;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
