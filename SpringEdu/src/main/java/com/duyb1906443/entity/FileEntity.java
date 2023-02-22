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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "file")
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
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "files")
	private List<ChoiceQuestionEntity> choiceQuestions;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "files")
	private List<ChoiceAnswerEntity> choiceAnswers;
	
	@ManyToOne
	@JoinTable(
			  name = "class_lesson_file", 
			  joinColumns = @JoinColumn(name = "file_id"), 
			  inverseJoinColumns = @JoinColumn(name = "class_lesson_id"))
	private ClassLessonEntity classLesson;

	@ManyToOne
	@JoinTable(
			  name = "class_excercise_file", 
			  joinColumns = @JoinColumn(name = "file_id"), 
			  inverseJoinColumns = @JoinColumn(name = "class_excercise_id"))
	private ClassLessonEntity classExcercise;

	@ManyToOne
	@JoinTable(
			  name = "submitted_exercise_file", 
			  joinColumns = @JoinColumn(name = "file_id"), 
			  inverseJoinColumns = @JoinColumn(name = "submitted_exercise_id"))
	private SubmittedExerciseEntity submittedExercise;
	
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

	public List<ChoiceQuestionEntity> getChoiceQuestions() {
		return choiceQuestions;
	}

	public void setChoiceQuestions(List<ChoiceQuestionEntity> choiceQuestions) {
		this.choiceQuestions = choiceQuestions;
	}

	public List<ChoiceAnswerEntity> getChoiceAnswers() {
		return choiceAnswers;
	}

	public void setChoiceAnswers(List<ChoiceAnswerEntity> choiceAnswers) {
		this.choiceAnswers = choiceAnswers;
	}

	public ClassLessonEntity getClassLesson() {
		return classLesson;
	}

	public void setClassLesson(ClassLessonEntity classLesson) {
		this.classLesson = classLesson;
	}

	public ClassLessonEntity getClassExcercise() {
		return classExcercise;
	}

	public void setClassExcercise(ClassLessonEntity classExcercise) {
		this.classExcercise = classExcercise;
	}

	public SubmittedExerciseEntity getSubmittedExercise() {
		return submittedExercise;
	}

	public void setSubmittedExercise(SubmittedExerciseEntity submittedExercise) {
		this.submittedExercise = submittedExercise;
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
