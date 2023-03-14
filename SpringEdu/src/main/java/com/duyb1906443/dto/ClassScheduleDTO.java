package com.duyb1906443.dto;

public class ClassScheduleDTO {
	private Long id;
	private int startHours;
	private int startMinutes;
	private int endHours;
	private int endMinutes;
	private String dateCode;
	private String dateName;

	public String getDateCode() {
		return dateCode;
	}

	public void setDateCode(String dateCode) {
		this.dateCode = dateCode;
	}

	public String getDateName() {
		return dateName;
	}

	public void setDateName(String dateName) {
		this.dateName = dateName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getStartHours() {
		return startHours;
	}

	public void setStartHours(int startHours) {
		this.startHours = startHours;
	}

	public int getStartMinutes() {
		return startMinutes;
	}

	public void setStartMinutes(int startMinutes) {
		this.startMinutes = startMinutes;
	}

	public int getEndHours() {
		return endHours;
	}

	public void setEndHours(int endHours) {
		this.endHours = endHours;
	}

	public int getEndMinutes() {
		return endMinutes;
	}

	public void setEndMinutes(int endMinutes) {
		this.endMinutes = endMinutes;
	}

}
