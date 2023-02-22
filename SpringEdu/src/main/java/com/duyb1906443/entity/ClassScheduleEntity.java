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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "`class_schedule`")
public class ClassScheduleEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private Date startTime;
	
	@Column
	private Date endTime;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
	  name = "class_schedule_weekly_class_schedule", 
	  joinColumns = @JoinColumn(name = "class_schedule_id"), 
	  inverseJoinColumns = @JoinColumn(name = "weekly_class_schedule_id"))
	private List<WeeklyClassScheduleEntity> weeklyClassSchedules;
	
	@OneToOne(mappedBy = "classSchedule", fetch = FetchType.LAZY)
	private ClassEntity classEntity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public List<WeeklyClassScheduleEntity> getWeeklyClassSchedules() {
		return weeklyClassSchedules;
	}

	public void setWeeklyClassSchedules(List<WeeklyClassScheduleEntity> weeklyClassSchedules) {
		this.weeklyClassSchedules = weeklyClassSchedules;
	}

	public ClassEntity getClassEntity() {
		return classEntity;
	}

	public void setClassEntity(ClassEntity classEntity) {
		this.classEntity = classEntity;
	}
	
}
