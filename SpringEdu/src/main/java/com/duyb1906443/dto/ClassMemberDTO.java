package com.duyb1906443.dto;

public class ClassMemberDTO {
	private Long userId;
	private String username;
	private String fullname;
	private String avatar;
	private String email;
	private String classRole;

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
