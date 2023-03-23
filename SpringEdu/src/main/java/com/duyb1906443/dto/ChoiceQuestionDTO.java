package com.duyb1906443.dto;

import java.util.List;

public class ChoiceQuestionDTO {
	private Long id;
	private String name;
	private List<ChoiceAnswerDTO> choiceAnswers;
	private Long questionBank;
	private String questionBankName;
	private FileDTO file;
	private String content;
	private Integer status;
	private Integer answerQuantity;

	public Integer getAnswerQuantity() {
		return answerQuantity;
	}

	public void setAnswerQuantity(Integer answerQuantity) {
		this.answerQuantity = answerQuantity;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getQuestionBankName() {
		return questionBankName;
	}

	public void setQuestionBankName(String questionBankName) {
		this.questionBankName = questionBankName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

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

	public List<ChoiceAnswerDTO> getChoiceAnswers() {
		return choiceAnswers;
	}

	public void setChoiceAnswers(List<ChoiceAnswerDTO> choiceAnswers) {
		this.choiceAnswers = choiceAnswers;
	}

	public Long getQuestionBank() {
		return questionBank;
	}

	public void setQuestionBank(Long questionBank) {
		this.questionBank = questionBank;
	}

}
