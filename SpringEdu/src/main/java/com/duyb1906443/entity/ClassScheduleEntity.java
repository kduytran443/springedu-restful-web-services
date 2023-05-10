package com.duyb1906443.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "`class_schedule`")
public class ClassScheduleEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(columnDefinition = "tinyint default 0")
	private int startHours;

	@Column(columnDefinition = "tinyint default 0")
	private int startMinutes;

	@Column(columnDefinition = "tinyint default 0")
	private int endHours;

	@Column(columnDefinition = "tinyint default 0")
	private int endMinutes;

	@ManyToOne
	@JoinColumn(name = "class_id")
	private ClassEntity classEntity;

	@ManyToOne
	@JoinColumn(name = "weekly_class_schedule_id")
	private WeeklyClassScheduleEntity weeklyClassSchedule;

	public WeeklyClassScheduleEntity getWeeklyClassSchedule() {
		return weeklyClassSchedule;
	}

	public void setWeeklyClassSchedule(WeeklyClassScheduleEntity weeklyClassSchedule) {
		this.weeklyClassSchedule = weeklyClassSchedule;
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

	public ClassEntity getClassEntity() {
		return classEntity;
	}

	public void setClassEntity(ClassEntity classEntity) {
		this.classEntity = classEntity;
	}

}
