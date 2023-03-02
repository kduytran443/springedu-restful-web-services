package com.duyb1906443.dto;

import java.util.List;

import com.duyb1906443.converter.ClassLessonReviewDTO;

public class TopicDTO {
	private Long id;
	private String name;
	private int ordinalNumber;
	private Long classId;
	private List<ClassLessonReviewDTO> classLessonReviews;

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

	public int getOrdinalNumber() {
		return ordinalNumber;
	}

	public void setOrdinalNumber(int ordinalNumber) {
		this.ordinalNumber = ordinalNumber;
	}

	public Long getClassId() {
		return classId;
	}

	public void setClassId(Long classId) {
		this.classId = classId;
	}

	public List<ClassLessonReviewDTO> getClassLessonReviews() {
		return classLessonReviews;
	}

	public void setClassLessonReviews(List<ClassLessonReviewDTO> classLessonReviews) {
		this.classLessonReviews = classLessonReviews;
	}

}
