package com.duyb1906443.dto;

import java.util.Date;

public class ClassDTO {
	private Long id;
	private String name;
	private Integer visiable;
	private Integer status;
	private Date createdDate;
	private String avatar;
	private Integer accepted;
	private CategoryDTO category;
	private Long backgroundImage;
	private Long video;
	private Long fee;
	private String shortDescription;
	private Long creatorId;

	public Long getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(Long creatorId) {
		this.creatorId = creatorId;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public Long getFee() {
		return fee;
	}

	public void setFee(Long fee) {
		this.fee = fee;
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

	public Integer getVisiable() {
		return visiable;
	}

	public void setVisiable(Integer visiable) {
		this.visiable = visiable;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
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

	public CategoryDTO getCategory() {
		return category;
	}

	public void setCategory(CategoryDTO category) {
		this.category = category;
	}

	public Long getBackgroundImage() {
		return backgroundImage;
	}

	public void setBackgroundImage(Long backgroundImage) {
		this.backgroundImage = backgroundImage;
	}

	public Long getVideo() {
		return video;
	}

	public void setVideo(Long video) {
		this.video = video;
	}

}
