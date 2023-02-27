package com.duyb1906443.dto;

public class ClassScheduleWeeklyClassScheduleDTO {
	private ClassScheduleDTO classSchedule;
	private WeeklyClassScheduleDTO weeklyClassSchedule;
	private int startHours;
	private int startMinutes;
	private int endHours;
	private int endMinutes;

	public ClassScheduleDTO getClassSchedule() {
		return classSchedule;
	}

	public void setClassSchedule(ClassScheduleDTO classSchedule) {
		this.classSchedule = classSchedule;
	}

	public WeeklyClassScheduleDTO getWeeklyClassSchedule() {
		return weeklyClassSchedule;
	}

	public void setWeeklyClassSchedule(WeeklyClassScheduleDTO weeklyClassSchedule) {
		this.weeklyClassSchedule = weeklyClassSchedule;
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
