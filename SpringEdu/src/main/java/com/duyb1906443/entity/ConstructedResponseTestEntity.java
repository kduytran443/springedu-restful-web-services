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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "`constructed_response_test`")
public class ConstructedResponseTestEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(columnDefinition = "nvarchar(256)")
	private String name;

	@Column(columnDefinition = "NTEXT")
	private String content;

	@OneToMany(mappedBy = "constructedResponseTest")
	private List<ConstructedResponseMarkEntity> constructedResponseMarks;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "constructed_response_test_file", joinColumns = @JoinColumn(name = "constructed_response_test_id"), inverseJoinColumns = @JoinColumn(name = "file_id"))
	private List<FileEntity> fileEntity;

	@ManyToOne
	@JoinColumn(name = "constructed_response_test_id")
	private QuestionBankEntity questionBank;

	public QuestionBankEntity getQuestionBank() {
		return questionBank;
	}

	public void setQuestionBank(QuestionBankEntity questionBank) {
		this.questionBank = questionBank;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<ConstructedResponseMarkEntity> getConstructedResponseMarks() {
		return constructedResponseMarks;
	}

	public void setConstructedResponseMarks(List<ConstructedResponseMarkEntity> constructedResponseMarks) {
		this.constructedResponseMarks = constructedResponseMarks;
	}

	public List<FileEntity> getFileEntity() {
		return fileEntity;
	}

	public void setFileEntity(List<FileEntity> fileEntity) {
		this.fileEntity = fileEntity;
	}

}
