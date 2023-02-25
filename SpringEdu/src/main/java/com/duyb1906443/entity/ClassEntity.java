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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "`class`")
public class ClassEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(columnDefinition = "NVARCHAR(128)")
	private String name;

	@Column(columnDefinition = "tinyint")
	private Integer visiable;

	@Column(columnDefinition = "tinyint")
	private Integer status;

	@Column
	private Date createdDate;

	@Column(columnDefinition = "TEXT")
	private String avatar;

	@Column(columnDefinition = "tinyint default 0")
	private Integer accepted;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "meeting_id")
	private MeetingEntity meeting;

	@OneToMany(mappedBy = "classEntity", fetch = FetchType.LAZY)
	private List<CommentEntity> comments;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "class_schedule_id")
	private ClassScheduleEntity classSchedule;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "classEntity")
	private List<TopicEntity> topics;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "classEntity")
	private List<ClassExcerciseEntity> classExcercises;

	@OneToMany(mappedBy = "classEntity", fetch = FetchType.LAZY)
	private List<MessageEntity> messages;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id")
	private CategoryEntity category;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "text_data_id")
	private TextDataEntity textData;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "background_id")
	private FileEntity backgroundImage;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "video_id")
	private FileEntity video;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "classEntity")
	private List<ReportEntity> reports;

	public List<ReportEntity> getReports() {
		return reports;
	}

	public void setReports(List<ReportEntity> reports) {
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

	public MeetingEntity getMeeting() {
		return meeting;
	}

	public void setMeeting(MeetingEntity meeting) {
		this.meeting = meeting;
	}

	public List<CommentEntity> getComments() {
		return comments;
	}

	public void setComments(List<CommentEntity> comments) {
		this.comments = comments;
	}

	public ClassScheduleEntity getClassSchedule() {
		return classSchedule;
	}

	public void setClassSchedule(ClassScheduleEntity classSchedule) {
		this.classSchedule = classSchedule;
	}

	public List<TopicEntity> getTopics() {
		return topics;
	}

	public void setTopics(List<TopicEntity> topics) {
		this.topics = topics;
	}

	public List<ClassExcerciseEntity> getClassExcercises() {
		return classExcercises;
	}

	public void setClassExcercises(List<ClassExcerciseEntity> classExcercises) {
		this.classExcercises = classExcercises;
	}

	public List<MessageEntity> getMessages() {
		return messages;
	}

	public void setMessages(List<MessageEntity> messages) {
		this.messages = messages;
	}

	public CategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
	}

	public TextDataEntity getTextData() {
		return textData;
	}

	public void setTextData(TextDataEntity textData) {
		this.textData = textData;
	}

	public FileEntity getBackgroundImage() {
		return backgroundImage;
	}

	public void setBackgroundImage(FileEntity backgroundImage) {
		this.backgroundImage = backgroundImage;
	}

	public FileEntity getVideo() {
		return video;
	}

	public void setVideo(FileEntity video) {
		this.video = video;
	}
	
}
