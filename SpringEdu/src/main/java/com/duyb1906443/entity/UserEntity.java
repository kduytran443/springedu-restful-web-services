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
import javax.persistence.OneToOne;
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

	@Column
	private String email;

	@Column
	private int phoneNumber;

	@Column
	private String gender;

	@Column
	private int brithYear;
	
	@Column
	private String avatar;

	@Column(columnDefinition = "tinyint default '1'")
	private int status;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private List<RoleEntity> roles;

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<MeetingActionEntity> meetingActions;

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<CommentEntity> comments;

	@OneToOne
	@JoinColumn(name = "question_bank_id")
	private QuestionBankEntity questionBank;

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<SubmittedExerciseEntity> submittedExercises;

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<MessageEntity> messages;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private List<ReportEntity> reports;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "creator")
	private List<ClassEntity> createdClasses;

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

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getBrithYear() {
		return brithYear;
	}

	public void setBrithYear(int brithYear) {
		this.brithYear = brithYear;
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

	public QuestionBankEntity getQuestionBank() {
		return questionBank;
	}

	public void setQuestionBank(QuestionBankEntity questionBank) {
		this.questionBank = questionBank;
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

}
