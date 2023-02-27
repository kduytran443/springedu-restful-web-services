package com.duyb1906443.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.duyb1906443.entity.id.ClassScheduleWeeklyClassScheduleId;

@Entity
@Table(name = "`class_schedule_weekly_class_schedule`")
public class ClassScheduleWeeklyClassScheduleEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private ClassScheduleWeeklyClassScheduleId classScheduleWeeklyClassScheduleId;
	
	@ManyToOne
	@MapsId("class_schedule_id")
	@JoinColumn(name = "class_schedule_id")
	private ClassScheduleEntity classSchedule;
	
	@ManyToOne
	@MapsId("weekly_class_schedule_id")
	@JoinColumn(name = "weekly_class_schedule_id")
	private WeeklyClassScheduleEntity weeklyClassSchedule;
	
	@Column(columnDefinition = "tinyint default 0")
	private int startHours;

	@Column(columnDefinition = "tinyint default 0")
	private int startMinutes;
	
	@Column(columnDefinition = "tinyint default 0")
	private int endHours;

	@Column(columnDefinition = "tinyint default 0")
	private int endMinutes;

	public ClassScheduleWeeklyClassScheduleId getClassScheduleWeeklyClassScheduleId() {
		return classScheduleWeeklyClassScheduleId;
	}

	public void setClassScheduleWeeklyClassScheduleId(
			ClassScheduleWeeklyClassScheduleId classScheduleWeeklyClassScheduleId) {
		this.classScheduleWeeklyClassScheduleId = classScheduleWeeklyClassScheduleId;
	}

	public ClassScheduleEntity getClassSchedule() {
		return classSchedule;
	}

	public void setClassSchedule(ClassScheduleEntity classSchedule) {
		this.classSchedule = classSchedule;
	}

	public WeeklyClassScheduleEntity getWeeklyClassSchedule() {
		return weeklyClassSchedule;
	}

	public void setWeeklyClassSchedule(WeeklyClassScheduleEntity weeklyClassSchedule) {
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
