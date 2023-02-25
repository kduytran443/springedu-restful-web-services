package com.duyb1906443.dto;

import java.util.List;

public class ChoiceQuestionDTO {
	private Long id;
	private String name;
	private List<Long> choiceAnswers;
	private Long questionBank;
	private List<Long> files;
	private List<Long> ChoiceQuestionOfClassExcercises;

	public ChoiceQuestionDTO() {
	}

	public ChoiceQuestionDTO(Long id, String name, List<Long> choiceAnswers, Long questionBank, List<Long> files,
			List<Long> choiceQuestionOfClassExcercises) {
		super();
		this.id = id;
		this.name = name;
		this.choiceAnswers = choiceAnswers;
		this.questionBank = questionBank;
		this.files = files;
		ChoiceQuestionOfClassExcercises = choiceQuestionOfClassExcercises;
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

	public List<Long> getFiles() {
		return files;
	}

	public void setFiles(List<Long> files) {
		this.files = files;
	}

	public List<Long> getChoiceQuestionOfClassExcercises() {
		return ChoiceQuestionOfClassExcercises;
	}

	public void setChoiceQuestionOfClassExcercises(List<Long> choiceQuestionOfClassExcercises) {
		ChoiceQuestionOfClassExcercises = choiceQuestionOfClassExcercises;
	}

	@Override
	public String toString() {
		return "ChoiceQuestionDTO [id=" + id + ", name=" + name + ", choiceAnswers=" + choiceAnswers + ", questionBank="
				+ questionBank + ", files=" + files + ", ChoiceQuestionOfClassExcercises="
				+ ChoiceQuestionOfClassExcercises + "]";
	}

}
