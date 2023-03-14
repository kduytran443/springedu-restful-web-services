package com.duyb1906443.dto;

import java.sql.Timestamp;

public class ClassMemberDTO {
	private Long userId;
	private String username;
	private String fullname;
	private String avatar;
	private String email;
	private Long classId;
	private String classRole;
	private float fee;
	private Timestamp createdDate;
	private int memberAccepted;
	private int classAccepted;
	private int discount;
	private Long discountId;

	public Long getDiscountId() {
		return discountId;
	}

	public void setDiscountId(Long discountId) {
		this.discountId = discountId;
	}

	public float getFee() {
		return fee;
	}

	public void setFee(float fee) {
		this.fee = fee;
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

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
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
