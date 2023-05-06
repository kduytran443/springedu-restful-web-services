package com.duyb1906443.dto;

import java.sql.Timestamp;

public class NoteDTO {
	private Long id;
	private String content;
	private String name;
	private Timestamp createdDate;
	private NoteFolderDTO noteFolder;
	private Timestamp modifiedDate;
	private Integer privateMode;
	private Long userId;
	private String username;
	private String userAvatar;
	private String userFullname;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserAvatar() {
		return userAvatar;
	}

	public void setUserAvatar(String userAvatar) {
		this.userAvatar = userAvatar;
	}

	public String getUserFullname() {
		return userFullname;
	}

	public void setUserFullname(String userFullname) {
		this.userFullname = userFullname;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Integer getPrivateMode() {
		return privateMode;
	}

	public void setPrivateMode(Integer privateMode) {
		this.privateMode = privateMode;
	}

	public Timestamp getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public NoteFolderDTO getNoteFolder() {
		return noteFolder;
	}

	public void setNoteFolder(NoteFolderDTO noteFolder) {
		this.noteFolder = noteFolder;
	}

}
