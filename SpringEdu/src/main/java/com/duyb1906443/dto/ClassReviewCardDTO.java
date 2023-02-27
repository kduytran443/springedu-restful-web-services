package com.duyb1906443.dto;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

public class ClassReviewCardDTO {
	private Long id;
	private String name;
	private String createdDate;
	private String avatar;
	private Integer accepted;
	private float stars;
	private String shortDescription;
	
	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Integer getAccepted() {
		return accepted;
	}

	public void setAccepted(Integer accepted) {
		this.accepted = accepted;
	}

	public float getStars() {
		return stars;
	}

	public void setStars(float stars) {
		this.stars = stars;
	}

	@Override
	public String toString() {
		return "ClassReviewCardDTO [id=" + id + ", name=" + name + ", createdDate=" + createdDate + ", avatar=" + avatar
				+ ", accepted=" + accepted +  ", stars=" + stars + "]";
	}

}
