package com.duyb1906443.dto;

public class ChoiceAnswerDTO {
	private Long id;
	private String content;
	private Integer correct;
	private FileDTO file;
	private String type;
	private Long choiceQuestionId;
	private Integer status;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getChoiceQuestionId() {
		return choiceQuestionId;
	}

	public void setChoiceQuestionId(Long choiceQuestionId) {
		this.choiceQuestionId = choiceQuestionId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public FileDTO getFile() {
		return file;
	}

	public void setFile(FileDTO file) {
		this.file = file;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getCorrect() {
		return correct;
	}

	public void setCorrect(Integer correct) {
		this.correct = correct;
	}

}
