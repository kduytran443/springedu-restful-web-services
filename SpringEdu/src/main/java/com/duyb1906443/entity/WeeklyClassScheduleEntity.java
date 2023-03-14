package com.duyb1906443.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "`weekly_class_schedule`")
public class WeeklyClassScheduleEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String code;

	@Column(columnDefinition = "nvarchar(32)")
	private String name;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "weeklyClassSchedule")
	private List<ClassScheduleEntity> classSchedule;

	public List<ClassScheduleEntity> getClassSchedule() {
		return classSchedule;
	}

	public void setClassSchedule(List<ClassScheduleEntity> classSchedule) {
		this.classSchedule = classSchedule;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
