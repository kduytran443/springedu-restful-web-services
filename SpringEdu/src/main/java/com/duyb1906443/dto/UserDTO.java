package com.duyb1906443.dto;

import java.util.List;

public class UserDTO {
	private Long id;
	private String username;
	private String fullname;
	private String email;
	private int phoneNumber;
	private String gender;
	private int brithYear;
	private String password;
	private List<Long> roles;

	public UserDTO() {
	}

	public UserDTO(Long id, String username, String fullname, String email, int phoneNumber, String gender,
			int brithYear, String password, List<Long> roles) {
		super();
		this.id = id;
		this.username = username;
		this.fullname = fullname;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.gender = gender;
		this.brithYear = brithYear;
		this.password = password;
		this.roles = roles;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public List<Long> getRoles() {
		return roles;
	}

	public void setRoles(List<Long> roles) {
		this.roles = roles;
	}

}
