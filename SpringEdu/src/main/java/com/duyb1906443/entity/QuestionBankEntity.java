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
import javax.persistence.Table;

@Entity
@Table(name = "`question_bank`")
public class QuestionBankEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(columnDefinition = "NVARCHAR(128)", nullable = false)
	private String name;

	@Column(columnDefinition = "tinyint")
	private Integer status;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity user;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "questionBank")
	private List<ChoiceQuestionEntity> choiceQuestions;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "questionBank")
	private List<ConstructedResponseTestEntity> constructedResponseTest;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ConstructedResponseTestEntity> getConstructedResponseTest() {
		return constructedResponseTest;
	}

	public void setConstructedResponseTest(List<ConstructedResponseTestEntity> constructedResponseTest) {
		this.constructedResponseTest = constructedResponseTest;
	}

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
