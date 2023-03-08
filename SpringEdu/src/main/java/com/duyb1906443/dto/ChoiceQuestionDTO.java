package com.duyb1906443.dto;

import java.util.List;

public class ChoiceQuestionDTO {
	private Long id;
	private String name;
	private List<Long> choiceAnswers;
	private Long questionBank;
	private FileDTO file;

	public FileDTO getFile() {
		return file;
	}

	public void setFile(FileDTO file) {
		this.file = file;
	}

	public ChoiceQuestionDTO() {
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

	public List<Long> getChoiceAnswers() {
		return choiceAnswers;
	}

	public void setChoiceAnswers(List<Long> choiceAnswers) {
		this.choiceAnswers = choiceAnswers;
	}

	public Long getQuestionBank() {
		return questionBank;
	}

	public void setQuestionBank(Long questionBank) {
		this.questionBank = questionBank;
	}

}
