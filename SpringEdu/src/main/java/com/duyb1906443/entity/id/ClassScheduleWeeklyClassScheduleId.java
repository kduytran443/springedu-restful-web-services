package com.duyb1906443.entity.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ClassScheduleWeeklyClassScheduleId implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Column(name = "class_schedule_id")
	private Long classScheduleId;
	
	@Column(name = "weekly_class_schedule_id")
	private Long weeklyClassSchedule;

	public Long getClassScheduleId() {
		return classScheduleId;
	}

	public void setClassScheduleId(Long classScheduleId) {
		this.classScheduleId = classScheduleId;
	}

	public Long getWeeklyClassSchedule() {
		return weeklyClassSchedule;
	}

	public void setWeeklyClassSchedule(Long weeklyClassSchedule) {
		this.weeklyClassSchedule = weeklyClassSchedule;
	}
	
}
