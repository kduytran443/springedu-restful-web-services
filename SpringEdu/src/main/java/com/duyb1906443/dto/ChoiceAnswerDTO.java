package com.duyb1906443.dto;

import java.util.List;

public class ChoiceAnswerDTO {
	private Long id;
	private String content;
	private int correct;
	private Long choiceQuestion;
	private List<Long> files;
	private List<Long> answerChoiceQuestions;

	public ChoiceAnswerDTO() {
	}

	public ChoiceAnswerDTO(Long id, String content, int correct, Long choiceQuestion, List<Long> files,
			List<Long> answerChoiceQuestions) {
		super();
		this.id = id;
		this.content = content;
		this.correct = correct;
		this.choiceQuestion = choiceQuestion;
		this.files = files;
		this.answerChoiceQuestions = answerChoiceQuestions;
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

	public int getCorrect() {
		return correct;
	}

	public void setCorrect(int correct) {
		this.correct = correct;
	}

	public Long getChoiceQuestion() {
		return choiceQuestion;
	}

	public void setChoiceQuestion(Long choiceQuestion) {
		this.choiceQuestion = choiceQuestion;
	}

	public List<Long> getFiles() {
		return files;
	}

	public void setFiles(List<Long> files) {
		this.files = files;
	}

	public List<Long> getAnswerChoiceQuestions() {
		return answerChoiceQuestions;
	}

	public void setAnswerChoiceQuestions(List<Long> answerChoiceQuestions) {
		this.answerChoiceQuestions = answerChoiceQuestions;
	}

	@Override
	public String toString() {
		return "ChoiceAnswerDTO [id=" + id + ", content=" + content + ", correct=" + correct + ", choiceQuestion="
				+ choiceQuestion + ", files=" + files + ", answerChoiceQuestions=" + answerChoiceQuestions + "]";
	}

}
