package com.duyb1906443.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "`meeting`")
public class MeetingEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String url;
	
	@OneToMany(mappedBy = "meeting", fetch = FetchType.LAZY)
	private List<MeetingActionEntity> meetingActions;
	
	@OneToOne(mappedBy = "meeting")
	private ClassEntity classEntity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<MeetingActionEntity> getMeetingActions() {
		return meetingActions;
	}

	public void setMeetingActions(List<MeetingActionEntity> meetingActions) {
		this.meetingActions = meetingActions;
	}

	public ClassEntity getClassEntity() {
		return classEntity;
	}

	public void setClassEntity(ClassEntity classEntity) {
		this.classEntity = classEntity;
	}
	
}
