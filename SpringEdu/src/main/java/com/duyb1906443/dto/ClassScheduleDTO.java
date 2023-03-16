package com.duyb1906443.dto;

import java.sql.Timestamp;

public class ClassScheduleDTO {
	private Long id;
	private Integer startHours;
	private Integer startMinutes;
	private Integer endHours;
	private Integer endMinutes;
	private String dateCode;
	private String dateName;
	private String weeklyClassScheduleCode;
	private String weeklyClassScheduleName;
	private Long weeklyClassScheduleId;
	private Long classId;
	private Timestamp startTimeOfClass;
	private Timestamp endTimeOfClass;
	private String className;
	private String classAvatar;

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getClassAvatar() {
		return classAvatar;
	}

	public void setClassAvatar(String classAvatar) {
		this.classAvatar = classAvatar;
	}

	public Timestamp getStartTimeOfClass() {
		return startTimeOfClass;
	}

	public void setStartTimeOfClass(Timestamp startTimeOfClass) {
		this.startTimeOfClass = startTimeOfClass;
	}

	public Timestamp getEndTimeOfClass() {
		return endTimeOfClass;
	}

	public void setEndTimeOfClass(Timestamp endTimeOfClass) {
		this.endTimeOfClass = endTimeOfClass;
	}

	public Long getClassId() {
		return classId;
	}

	public void setClassId(Long classId) {
		this.classId = classId;
	}

	public String getWeeklyClassScheduleCode() {
		return weeklyClassScheduleCode;
	}

	public void setWeeklyClassScheduleCode(String weeklyClassScheduleCode) {
		this.weeklyClassScheduleCode = weeklyClassScheduleCode;
	}

	public String getWeeklyClassScheduleName() {
		return weeklyClassScheduleName;
	}

	public void setWeeklyClassScheduleName(String weeklyClassScheduleName) {
		this.weeklyClassScheduleName = weeklyClassScheduleName;
	}

	public Long getWeeklyClassScheduleId() {
		return weeklyClassScheduleId;
	}

	public void setWeeklyClassScheduleId(Long weeklyClassScheduleId) {
		this.weeklyClassScheduleId = weeklyClassScheduleId;
	}

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

	public Integer getStartHours() {
		return startHours;
	}

	public void setStartHours(Integer startHours) {
		this.startHours = startHours;
	}

	public Integer getStartMinutes() {
		return startMinutes;
	}

	public void setStartMinutes(Integer startMinutes) {
		this.startMinutes = startMinutes;
	}

	public Integer getEndHours() {
		return endHours;
	}

	public void setEndHours(Integer endHours) {
		this.endHours = endHours;
	}

	public Integer getEndMinutes() {
		return endMinutes;
	}

	public void setEndMinutes(Integer endMinutes) {
		this.endMinutes = endMinutes;
	}

	@Override
	public String toString() {
		return "ClassScheduleDTO [id=" + id + ", startHours=" + startHours + ", startMinutes=" + startMinutes
				+ ", endHours=" + endHours + ", endMinutes=" + endMinutes + ", dateCode=" + dateCode + ", dateName="
				+ dateName + ", weeklyClassScheduleCode=" + weeklyClassScheduleCode + ", weeklyClassScheduleName="
				+ weeklyClassScheduleName + ", weeklyClassScheduleId=" + weeklyClassScheduleId + "]";
	}

}
