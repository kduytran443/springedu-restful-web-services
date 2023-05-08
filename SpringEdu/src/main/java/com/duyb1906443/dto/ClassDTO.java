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
	private String background;
	private Long video;
	private Float fee;
	private String shortDescription;
	private Long creatorId;
	private String videoData;
	private String content;
	private String paypalAccount;
	private Integer minimumCompletionRate;

	public Integer getMinimumCompletionRate() {
		return minimumCompletionRate;
	}

	public void setMinimumCompletionRate(Integer minimumCompletionRate) {
		this.minimumCompletionRate = minimumCompletionRate;
	}

	public String getPaypalAccount() {
		return paypalAccount;
	}

	public void setPaypalAccount(String paypalAccount) {
		this.paypalAccount = paypalAccount;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getVideoData() {
		return videoData;
	}

	public void setVideoData(String videoData) {
		this.videoData = videoData;
	}

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

	public Float getFee() {
		return fee;
	}

	public void setFee(Float fee) {
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

	public String getBackground() {
		return background;
	}

	public void setBackground(String background) {
		this.background = background;
	}

	public Long getVideo() {
		return video;
	}

	public void setVideo(Long video) {
		this.video = video;
	}

}
