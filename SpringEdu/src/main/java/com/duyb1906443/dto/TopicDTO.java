package com.duyb1906443.dto;

import java.util.List;

public class TopicDTO {
	private Long id;
	private String name;
	private int ordinalNumber;
	private int visible;
	private Long classId;
	private List<ClassLessonReviewDTO> classLessonReviews;

	public int getVisible() {
		return visible;
	}

	public void setVisible(int visible) {
		this.visible = visible;
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

	@Override
	public String toString() {
		return "TopicDTO [id=" + id + ", name=" + name + ", ordinalNumber=" + ordinalNumber + ", visible=" + visible
				+ ", classId=" + classId + ", classLessonReviews=" + classLessonReviews + "]";
	}

}
