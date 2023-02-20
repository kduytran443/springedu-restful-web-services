package com.duyb1906443.mail;


import com.duyb1906443.dto.UserDTO;

public class MailHolder {
	private UserDTO user;
	private String key;
	
	public MailHolder(UserDTO user) {
		this.user = user;
		this.key = "random-abc";
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
}
