package com.duyb1906443.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "`question_bank`")
public class QuestionBankEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(columnDefinition = "NVARCHAR(128)", nullable = false)
	private String name;
	
	@OneToOne(mappedBy = "questionBank")
	private UserEntity user;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "questionBank")
	private List<ChoiceQuestionEntity> choiceQuestions;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public List<ChoiceQuestionEntity> getChoiceQuestions() {
		return choiceQuestions;
	}

	public void setChoiceQuestions(List<ChoiceQuestionEntity> choiceQuestions) {
		this.choiceQuestions = choiceQuestions;
	}
	
}
