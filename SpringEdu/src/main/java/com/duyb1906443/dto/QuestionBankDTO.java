package com.duyb1906443.dto;

public class QuestionBankDTO {
	private Long id;
	private String name;
	private Integer status;
	private String username;
	private Long userId;
	private Integer questionQuantity;

	public Integer getQuestionQuantity() {
		return questionQuantity;
	}

	public void setQuestionQuantity(Integer questionQuantity) {
		this.questionQuantity = questionQuantity;
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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

}
