package com.duyb1906443.dto;

import java.util.Date;
import java.util.List;

public class ClassDTO {
	private Long id;
	private String name;
	private Integer visiable;
	private Integer status;
	private Date createdDate;
	private String avatar;
	private Integer accepted;
	private String meeting;
	private Long classSchedule;
	private List<Long> topics;
	private List<Long> classExcercises;
	private List<Long> messages;
	private Long category;
	private Long textData;
	private Long backgroundImage;
	private Long video;
	private List<Long> reports;

	public ClassDTO() {
	}

	public ClassDTO(Long id, String name, Integer visiable, Integer status, Date createdDate, String avatar,
			Integer accepted, String meeting, Long classSchedule, List<Long> topics, List<Long> classExcercises,
			List<Long> messages, Long category, Long textData, Long backgroundImage, Long video, List<Long> reports) {
		super();
		this.id = id;
		this.name = name;
		this.visiable = visiable;
		this.status = status;
		this.createdDate = createdDate;
		this.avatar = avatar;
		this.accepted = accepted;
		this.meeting = meeting;
		this.classSchedule = classSchedule;
		this.topics = topics;
		this.classExcercises = classExcercises;
		this.messages = messages;
		this.category = category;
		this.textData = textData;
		this.backgroundImage = backgroundImage;
		this.video = video;
		this.reports = reports;
	}

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

	public Integer getVisiable() {
		return visiable;
	}

	public void setVisiable(Integer visiable) {
		this.visiable = visiable;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Integer getAccepted() {
		return accepted;
	}

	public void setAccepted(Integer accepted) {
		this.accepted = accepted;
	}

	public String getMeeting() {
		return meeting;
	}

	public void setMeeting(String meeting) {
		this.meeting = meeting;
	}

	public Long getClassSchedule() {
		return classSchedule;
	}

	public void setClassSchedule(Long classSchedule) {
		this.classSchedule = classSchedule;
	}

	public List<Long> getTopics() {
		return topics;
	}

	public void setTopics(List<Long> topics) {
		this.topics = topics;
	}

	public List<Long> getClassExcercises() {
		return classExcercises;
	}

	public void setClassExcercises(List<Long> classExcercises) {
		this.classExcercises = classExcercises;
	}

	public List<Long> getMessages() {
		return messages;
	}

	public void setMessages(List<Long> messages) {
		this.messages = messages;
	}

	public Long getCategory() {
		return category;
	}

	public void setCategory(Long category) {
		this.category = category;
	}

	public Long getTextData() {
		return textData;
	}

	public void setTextData(Long textData) {
		this.textData = textData;
	}

	public Long getBackgroundImage() {
		return backgroundImage;
	}

	public void setBackgroundImage(Long backgroundImage) {
		this.backgroundImage = backgroundImage;
	}

	public Long getVideo() {
		return video;
	}

	public void setVideo(Long video) {
		this.video = video;
	}

	public List<Long> getReports() {
		return reports;
	}

	public void setReports(List<Long> reports) {
		this.reports = reports;
	}

	@Override
	public String toString() {
		return "ClassDTO [id=" + id + ", name=" + name + ", visiable=" + visiable + ", status=" + status
				+ ", createdDate=" + createdDate + ", avatar=" + avatar + ", accepted=" + accepted + ", meeting="
				+ meeting + ", classSchedule=" + classSchedule + ", topics=" + topics + ", classExcercises="
				+ classExcercises + ", messages=" + messages + ", category=" + category + ", textData=" + textData
				+ ", backgroundImage=" + backgroundImage + ", video=" + video + ", reports=" + reports + "]";
	}

}
