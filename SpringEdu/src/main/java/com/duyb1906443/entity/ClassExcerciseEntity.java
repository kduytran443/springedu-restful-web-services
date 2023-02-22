package com.duyb1906443.entity;

import java.util.Date;
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
@Table(name = "class_excercise")
public class ClassExcerciseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(columnDefinition = "nvarchar(256)")
	private String name;
	
	@Column
	private Date createdTime;
	
	@Column
	private Date startTime;

	@Column
	private Date endTime;

	@Column
	private float mark;

	@Column
	private int effective;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "class_id")
	private ClassEntity classEntity;
	
	@OneToMany(mappedBy = "classExcercise", fetch = FetchType.LAZY)
	private List<FileEntity> files;
	
	@OneToMany(mappedBy = "classExcercise", fetch = FetchType.LAZY)
	private List<SubmittedExerciseEntity> submittedExercises;
	
	@OneToMany(mappedBy = "classExcercise", fetch = FetchType.LAZY)
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

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public float getMark() {
		return mark;
	}

	public void setMark(float mark) {
		this.mark = mark;
	}

	public int getEffective() {
		return effective;
	}

	public void setEffective(int effective) {
		this.effective = effective;
	}

	public ClassEntity getClassEntity() {
		return classEntity;
	}

	public void setClassEntity(ClassEntity classEntity) {
		this.classEntity = classEntity;
	}

	public List<FileEntity> getFiles() {
		return files;
	}

	public void setFiles(List<FileEntity> files) {
		this.files = files;
	}

	public List<SubmittedExerciseEntity> getSubmittedExercises() {
		return submittedExercises;
	}

	public void setSubmittedExercises(List<SubmittedExerciseEntity> submittedExercises) {
		this.submittedExercises = submittedExercises;
	}

	public List<ChoiceQuestionOfClassExcerciseEntity> getChoiceQuestionOfClassExcercises() {
		return ChoiceQuestionOfClassExcercises;
	}

	public void setChoiceQuestionOfClassExcercises(
			List<ChoiceQuestionOfClassExcerciseEntity> choiceQuestionOfClassExcercises) {
		ChoiceQuestionOfClassExcercises = choiceQuestionOfClassExcercises;
	}
	
}
