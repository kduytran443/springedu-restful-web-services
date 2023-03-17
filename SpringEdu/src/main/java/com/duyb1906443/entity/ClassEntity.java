package com.duyb1906443.entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
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
	private Timestamp createdDate;

	@Column(columnDefinition = "TEXT")
	private String avatar;

	@Column(columnDefinition = "tinyint default 0")
	private Integer accepted;

	@Column(columnDefinition = "NVARCHAR(256)")
	private String shortDescription;

	@Column
	private Timestamp startTime;

	@Column
	private Timestamp endTime;

	@Column
	private String background;

	@Column(nullable = true)
	private Float fee;

	@Column(columnDefinition = "NTEXT")
	private String content;

	@Column(columnDefinition = "nvarchar(512)")
	private String video;

	@Column(columnDefinition = "nvarchar(120)", nullable = true)
	private String paypalAccount;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "meeting_id")
	private MeetingEntity meeting;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "classEntity")
	private List<ClassScheduleEntity> classSchedules;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "classEntity")
	private List<TopicEntity> topics;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "classEntity")
	private List<ClassExcerciseEntity> classExcercises;

	@OneToMany(mappedBy = "classEntity", fetch = FetchType.LAZY)
	private List<MessageEntity> messages;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id")
	private CategoryEntity category;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "classEntity")
	private List<ReportEntity> reports;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "creator_id")
	private UserEntity creator;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "classEntity")
	private List<DiscountEntity> discounts;

	@ManyToMany(mappedBy = "classEntities")
	private List<QuestionBankEntity> questionBanks;

	@OneToMany(mappedBy = "classEntity", fetch = FetchType.LAZY)
	private List<CommentEntity> comments;

	public String getPaypalAccount() {
		return paypalAccount;
	}

	public void setPaypalAccount(String paypalAccount) {
		this.paypalAccount = paypalAccount;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public String getVideo() {
		return video;
	}

	public String getBackground() {
		return background;
	}

	public void setBackground(String background) {
		this.background = background;
	}

	public List<QuestionBankEntity> getQuestionBanks() {
		return questionBanks;
	}

	public void setQuestionBanks(List<QuestionBankEntity> questionBanks) {
		this.questionBanks = questionBanks;
	}

	public List<CommentEntity> getComments() {
		return comments;
	}

	public void setComments(List<CommentEntity> comments) {
		this.comments = comments;
	}

	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getEndTime() {
		return endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public List<DiscountEntity> getDiscounts() {
		return discounts;
	}

	public void setDiscounts(List<DiscountEntity> discounts) {
		this.discounts = discounts;
	}

	public UserEntity getCreator() {
		return creator;
	}

	public void setCreator(UserEntity creator) {
		this.creator = creator;
	}

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

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<ClassScheduleEntity> getClassSchedules() {
		return classSchedules;
	}

	public void setClassSchedules(List<ClassScheduleEntity> classSchedules) {
		this.classSchedules = classSchedules;
	}

	public void setFee(Float fee) {
		this.fee = fee;
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

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public Float getFee() {
		return fee;
	}

	public void setFee(float fee) {
		this.fee = fee;
	}

}
