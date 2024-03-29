package com.duyb1906443.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "`user`")
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = true)
	private String username;

	@Column
	private String password;

	@Column(columnDefinition = "nvarchar(24)")
	private String fullname;

	@Column(nullable = false, unique = true)
	private String email;

	@Column(nullable = false, unique = true)
	private Integer phoneNumber;

	@Column
	private String gender;

	@Column
	private Integer birthYear;

	@Column(columnDefinition = "TEXT")
	private String avatar;

	@Column(columnDefinition = "tinyint default '1'")
	private Integer status;

	@Column(columnDefinition = "NTEXT")
	private String description;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private List<RoleEntity> roles;

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<MeetingActionEntity> meetingActions;

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<CommentEntity> comments;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private List<QuestionBankEntity> questionBanks;

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<SubmittedExerciseEntity> submittedExercises;

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<MessageEntity> messages;

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<ReadMessageEntity> readMessages;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private List<ReportEntity> reports;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "creator")
	private List<ClassEntity> createdClasses;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private List<NotificationEntity> notifications;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private List<UserNotificationEntity> userNotifications;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private List<NoteFolderEntity> noteFolders;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "favorite", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "class_id"))
	private List<ClassEntity> favoritedClassess;

	public List<ClassEntity> getFavoritedClassess() {
		return favoritedClassess;
	}

	public void setFavoritedClassess(List<ClassEntity> favoritedClassess) {
		this.favoritedClassess = favoritedClassess;
	}

	public List<NoteFolderEntity> getNoteFolders() {
		return noteFolders;
	}

	public void setNoteFolders(List<NoteFolderEntity> noteFolders) {
		this.noteFolders = noteFolders;
	}

	public List<ReadMessageEntity> getReadMessages() {
		return readMessages;
	}

	public void setReadMessages(List<ReadMessageEntity> readMessages) {
		this.readMessages = readMessages;
	}

	public List<NotificationEntity> getNotifications() {
		return notifications;
	}

	public void setNotifications(List<NotificationEntity> notifications) {
		this.notifications = notifications;
	}

	public List<UserNotificationEntity> getUserNotifications() {
		return userNotifications;
	}

	public void setUserNotifications(List<UserNotificationEntity> userNotifications) {
		this.userNotifications = userNotifications;
	}

	public Integer getPhoneNumber() {
		return phoneNumber;
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(Integer birthYear) {
		this.birthYear = birthYear;
	}

	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public List<RoleEntity> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleEntity> roles) {
		this.roles = roles;
	}

	public List<MeetingActionEntity> getMeetingActions() {
		return meetingActions;
	}

	public void setMeetingActions(List<MeetingActionEntity> meetingActions) {
		this.meetingActions = meetingActions;
	}

	public List<CommentEntity> getComments() {
		return comments;
	}

	public void setComments(List<CommentEntity> comments) {
		this.comments = comments;
	}

	public List<QuestionBankEntity> getQuestionBanks() {
		return questionBanks;
	}

	public void setQuestionBanks(List<QuestionBankEntity> questionBanks) {
		this.questionBanks = questionBanks;
	}

	public List<ClassEntity> getCreatedClasses() {
		return createdClasses;
	}

	public void setCreatedClasses(List<ClassEntity> createdClasses) {
		this.createdClasses = createdClasses;
	}

	public List<SubmittedExerciseEntity> getSubmittedExercises() {
		return submittedExercises;
	}

	public void setSubmittedExercises(List<SubmittedExerciseEntity> submittedExercises) {
		this.submittedExercises = submittedExercises;
	}

	public List<MessageEntity> getMessages() {
		return messages;
	}

	public void setMessages(List<MessageEntity> messages) {
		this.messages = messages;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
