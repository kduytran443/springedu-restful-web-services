package com.duyb1906443.dto;

import java.sql.Timestamp;
import java.util.List;

public class ClassIntroDTO {
	private Long id;
	private String name;
	private Integer visiable;
	private Integer status;
	private Timestamp createdDate;
	private String categoryName;
	private String categoryCode;
	private String textData;
	private String backgroundImage;
	private String video;
	private String userAvatar;
	private String username;
	private String userFullname;
	private float stars;
	private float fee;
	private List<ClassScheduleDTO> classSchedules;
	private List<DiscountDTO> discounts;
	private String userRoleCode;
	private Timestamp startTime;
	private Timestamp endTime;
	private String avatar;
	private Long categoryId;
	private Long userId;
	private String paypalAccount;

	public String getPaypalAccount() {
		return paypalAccount;
	}

	public void setPaypalAccount(String paypalAccount) {
		this.paypalAccount = paypalAccount;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getEndTime() {
		return endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public String getUserRoleCode() {
		return userRoleCode;
	}

	public void setUserRoleCode(String userRoleCode) {
		this.userRoleCode = userRoleCode;
	}

	public List<DiscountDTO> getDiscount() {
		return discounts;
	}

	public void setDiscount(List<DiscountDTO> discounts) {
		this.discounts = discounts;
	}

	public float getFee() {
		return fee;
	}

	public void setFee(float fee) {
		this.fee = fee;
	}

	public List<ClassScheduleDTO> getClassSchedules() {
		return classSchedules;
	}

	public void setClassSchedules(List<ClassScheduleDTO> classSchedules) {
		this.classSchedules = classSchedules;
	}

	public List<DiscountDTO> getDiscounts() {
		return discounts;
	}

	public void setDiscounts(List<DiscountDTO> discounts) {
		this.discounts = discounts;
	}

	public String getUserFullname() {
		return userFullname;
	}

	public void setUserFullname(String userFullname) {
		this.userFullname = userFullname;
	}

	public float getStars() {
		return stars;
	}

	public void setStars(float stars) {
		this.stars = stars;
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

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getTextData() {
		return textData;
	}

	public void setTextData(String textData) {
		this.textData = textData;
	}

	public String getBackgroundImage() {
		return backgroundImage;
	}

	public void setBackgroundImage(String backgroundImage) {
		this.backgroundImage = backgroundImage;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public String getUserAvatar() {
		return userAvatar;
	}

	public void setUserAvatar(String userAvatar) {
		this.userAvatar = userAvatar;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
