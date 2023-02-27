package com.duyb1906443.dto;

public class ReviewDTO {
	private float stars;
	private Long userId;
	private String userName;
	private String userAvatar;
	private Long classId;
	private String comment;

	public float getStars() {
		return stars;
	}

	public void setStars(float stars) {
		this.stars = stars;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getClassId() {
		return classId;
	}

	public void setClassId(Long classId) {
		this.classId = classId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
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

	@Override
	public String toString() {
		return "ReviewDTO [stars=" + stars + ", userId=" + userId + ", userName=" + userName + ", userAvatar="
				+ userAvatar + ", classId=" + classId + ", comment=" + comment + "]";
	}

}
