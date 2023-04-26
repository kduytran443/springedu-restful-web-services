package com.duyb1906443.dto;

import java.sql.Timestamp;
import java.util.List;

public class CommentDTO {
	private Long id;
	private Long userId;
	private String userName;
	private String userAvatar;
	private Long lessonId;
	private String content;
	private Timestamp createdDate;
	private String fullname;
	private Long parentId;
	private Integer status;
	private List<CommentDTO> replies;
	private Integer privateMode;

	public Integer getPrivateMode() {
		return privateMode;
	}

	public void setPrivateMode(Integer privateMode) {
		this.privateMode = privateMode;
	}

	public List<CommentDTO> getReplies() {
		return replies;
	}

	public void setReplies(List<CommentDTO> replies) {
		this.replies = replies;
	}

	public Long getLessonId() {
		return lessonId;
	}

	public void setLessonId(Long lessonId) {
		this.lessonId = lessonId;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserAvatar() {
		return userAvatar;
	}

	public void setUserAvatar(String userAvatar) {
		this.userAvatar = userAvatar;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

}
