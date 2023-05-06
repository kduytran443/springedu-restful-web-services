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
@Table(name = "choice_question")
public class ChoiceQuestionEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(columnDefinition = "nvarchar(2048)")
	private String name;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "choiceQuestion")
	private List<ChoiceAnswerEntity> choiceAnswers;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "question_bank_id")
	private QuestionBankEntity questionBank;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "file_id", nullable = true)
	private FileEntity file;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "choiceQuestion")
	private List<DrawQuizEntity> drawQuizzes;

	@Column(columnDefinition = "NTEXT")
	private String content;

	@Column(columnDefinition = "tinyint")
	private Integer status;

	@Column(columnDefinition = "tinyint")
	private Integer important;

	public Integer getImportant() {
		return important;
	}

	public void setImportant(Integer important) {
		this.important = important;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public List<ChoiceAnswerEntity> getChoiceAnswers() {
		return choiceAnswers;
	}

	public void setChoiceAnswers(List<ChoiceAnswerEntity> choiceAnswers) {
		this.choiceAnswers = choiceAnswers;
	}

	public QuestionBankEntity getQuestionBank() {
		return questionBank;
	}

	public void setQuestionBank(QuestionBankEntity questionBank) {
		this.questionBank = questionBank;
	}

	public FileEntity getFile() {
		return file;
	}

	public void setFile(FileEntity file) {
		this.file = file;
	}

	public List<DrawQuizEntity> getDrawQuizzes() {
		return drawQuizzes;
	}

	public void setDrawQuizzes(List<DrawQuizEntity> drawQuizzes) {
		this.drawQuizzes = drawQuizzes;
	}

}
