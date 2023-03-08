package com.duyb1906443.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "`file`")
public class FileEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(columnDefinition = "nvarchar(256)")
	private String name;

	@Column(columnDefinition = "TEXT")
	private String data;

	@Column
	private String type;

	@Column
	private float size;

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "file")
	private ChoiceQuestionEntity choiceQuestions;

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "file")
	private ChoiceAnswerEntity choiceAnswers;

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "backgroundImage")
	private ClassEntity classEntityWithBackgroundImage;

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "video")
	private ClassEntity classEntityWithVideo;

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

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public float getSize() {
		return size;
	}

	public void setSize(float size) {
		this.size = size;
	}

	public ChoiceQuestionEntity getChoiceQuestions() {
		return choiceQuestions;
	}

	public void setChoiceQuestions(ChoiceQuestionEntity choiceQuestions) {
		this.choiceQuestions = choiceQuestions;
	}

	public ChoiceAnswerEntity getChoiceAnswers() {
		return choiceAnswers;
	}

	public void setChoiceAnswers(ChoiceAnswerEntity choiceAnswers) {
		this.choiceAnswers = choiceAnswers;
	}

	public ClassEntity getClassEntityWithBackgroundImage() {
		return classEntityWithBackgroundImage;
	}

	public void setClassEntityWithBackgroundImage(ClassEntity classEntityWithBackgroundImage) {
		this.classEntityWithBackgroundImage = classEntityWithBackgroundImage;
	}

	public ClassEntity getClassEntityWithVideo() {
		return classEntityWithVideo;
	}

	public void setClassEntityWithVideo(ClassEntity classEntityWithVideo) {
		this.classEntityWithVideo = classEntityWithVideo;
	}

}
