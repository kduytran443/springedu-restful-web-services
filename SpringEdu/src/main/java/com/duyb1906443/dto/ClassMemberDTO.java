package com.duyb1906443.dto;

import java.sql.Timestamp;

public class ClassMemberDTO {
	private Long userId;
	private String username;
	private String fullname;
	private String avatar;
	private String classAvatar;
	private String email;
	private Long classId;
	private String className;
	private String classRole;
	private Timestamp createdDate;
	private int memberAccepted;
	private int classAccepted;
	private Integer discount;
	private TransactionDTO transaction;

	public TransactionDTO getTransaction() {
		return transaction;
	}

	public void setTransaction(TransactionDTO transaction) {
		this.transaction = transaction;
	}

	public String getClassAvatar() {
		return classAvatar;
	}

	public void setClassAvatar(String classAvatar) {
		this.classAvatar = classAvatar;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public int getMemberAccepted() {
		return memberAccepted;
	}

	public void setMemberAccepted(int memberAccepted) {
		this.memberAccepted = memberAccepted;
	}

	public int getClassAccepted() {
		return classAccepted;
	}

	public void setClassAccepted(int classAccepted) {
		this.classAccepted = classAccepted;
	}

	public Integer getDiscount() {
		return discount;
	}

	public Long getClassId() {
		return classId;
	}

	public void setClassId(Long classId) {
		this.classId = classId;
	}

	public String getClassRole() {
		return classRole;
	}

	public void setClassRole(String classRole) {
		this.classRole = classRole;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
