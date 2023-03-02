package com.duyb1906443.converter;

import java.sql.Timestamp;

public class ClassLessonReviewDTO {
	private Long id;
	private String name;
	private Timestamp createdDate;
	private int ordinalNumber;

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

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public int getOrdinalNumber() {
		return ordinalNumber;
	}

	public void setOrdinalNumber(int ordinalNumber) {
		this.ordinalNumber = ordinalNumber;
	}

	@Override
	public String toString() {
		return "ClassLessonReviewDTO [id=" + id + ", name=" + name + ", createdDate=" + createdDate + ", ordinalNumber="
				+ ordinalNumber + "]";
	}

}
