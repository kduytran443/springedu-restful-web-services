package com.duyb1906443.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "`text_data`")
public class TextDataEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(columnDefinition = "NTEXT")
	private String content;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "textData")
	private ClassLessonEntity classLesson;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "textData")
	private SubmittedExerciseEntity submittedExercise;
	
	@OneToOne(mappedBy = "textData", fetch = FetchType.LAZY)
	private ClassEntity classEntity;

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

	public ClassLessonEntity getClassLesson() {
		return classLesson;
	}

	public void setClassLesson(ClassLessonEntity classLesson) {
		this.classLesson = classLesson;
	}

	public SubmittedExerciseEntity getSubmittedExercise() {
		return submittedExercise;
	}

	public void setSubmittedExercise(SubmittedExerciseEntity submittedExercise) {
		this.submittedExercise = submittedExercise;
	}

	public ClassEntity getClassEntity() {
		return classEntity;
	}

	public void setClassEntity(ClassEntity classEntity) {
		this.classEntity = classEntity;
	}
	
}
