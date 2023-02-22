package com.duyb1906443.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			  name = "choice_question_file", 
			  joinColumns = @JoinColumn(name = "choice_question_id"), 
			  inverseJoinColumns = @JoinColumn(name = "file_id"))
	private List<FileEntity> files;
	
	@OneToMany(mappedBy = "choiceQuestion", fetch = FetchType.LAZY)
	private List<ChoiceQuestionOfClassExcerciseEntity> ChoiceQuestionOfClassExcercises;

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

	public List<FileEntity> getFiles() {
		return files;
	}

	public void setFiles(List<FileEntity> files) {
		this.files = files;
	}

	public List<ChoiceQuestionOfClassExcerciseEntity> getChoiceQuestionOfClassExcercises() {
		return ChoiceQuestionOfClassExcercises;
	}

	public void setChoiceQuestionOfClassExcercises(
			List<ChoiceQuestionOfClassExcerciseEntity> choiceQuestionOfClassExcercises) {
		ChoiceQuestionOfClassExcercises = choiceQuestionOfClassExcercises;
	}
	
}
