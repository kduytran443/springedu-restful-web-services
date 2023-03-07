package com.duyb1906443.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "choice_answer")
public class ChoiceAnswerEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(columnDefinition = "nvarchar(1024)")
	private String content;

	@Column(columnDefinition = "tinyint")
	private int correct;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "choice_question_id")
	private ChoiceQuestionEntity choiceQuestion;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "file_id", nullable = true)
	private FileEntity file;

	@OneToMany(mappedBy = "choiceAnswer", fetch = FetchType.LAZY)
	private List<AnswerChoiceQuestionEntity> answerChoiceQuestions;

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

	public ChoiceQuestionEntity getChoiceQuestion() {
		return choiceQuestion;
	}

	public void setChoiceQuestion(ChoiceQuestionEntity choiceQuestion) {
		this.choiceQuestion = choiceQuestion;
	}

	public FileEntity getFile() {
		return file;
	}

	public void setFile(FileEntity file) {
		this.file = file;
	}

	public List<AnswerChoiceQuestionEntity> getAnswerChoiceQuestions() {
		return answerChoiceQuestions;
	}

	public void setAnswerChoiceQuestions(List<AnswerChoiceQuestionEntity> answerChoiceQuestions) {
		this.answerChoiceQuestions = answerChoiceQuestions;
	}

}
