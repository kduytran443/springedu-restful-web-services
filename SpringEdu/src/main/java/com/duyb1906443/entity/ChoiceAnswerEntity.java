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

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			  name = "choice_answer_file", 
			  joinColumns = @JoinColumn(name = "choice_answer_id"), 
			  inverseJoinColumns = @JoinColumn(name = "file_id"))
	private List<FileEntity> files;
	
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

	public List<FileEntity> getFiles() {
		return files;
	}

	public void setFiles(List<FileEntity> files) {
		this.files = files;
	}

	public List<AnswerChoiceQuestionEntity> getAnswerChoiceQuestions() {
		return answerChoiceQuestions;
	}

	public void setAnswerChoiceQuestions(List<AnswerChoiceQuestionEntity> answerChoiceQuestions) {
		this.answerChoiceQuestions = answerChoiceQuestions;
	}
	
}
