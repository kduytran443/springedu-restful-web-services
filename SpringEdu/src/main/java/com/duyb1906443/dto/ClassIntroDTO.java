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
	private Long fee;
	private ClassScheduleDTO classSchedule;
	private List<ClassScheduleWeeklyClassScheduleDTO> classScheduleWeeklyClassSchedule;
	private DiscountDTO discount;
	private String userRoleCode;

	public String getUserRoleCode() {
		return userRoleCode;
	}

	public void setUserRoleCode(String userRoleCode) {
		this.userRoleCode = userRoleCode;
	}

	public DiscountDTO getDiscount() {
		return discount;
	}

	public void setDiscount(DiscountDTO discount) {
		this.discount = discount;
	}

	public Long getFee() {
		return fee;
	}

	public void setFee(Long fee) {
		this.fee = fee;
	}

	public List<ClassScheduleWeeklyClassScheduleDTO> getClassScheduleWeeklyClassSchedule() {
		return classScheduleWeeklyClassSchedule;
	}

	public void setClassScheduleWeeklyClassSchedule(
			List<ClassScheduleWeeklyClassScheduleDTO> classScheduleWeeklyClassSchedule) {
		this.classScheduleWeeklyClassSchedule = classScheduleWeeklyClassSchedule;
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

	public ClassScheduleDTO getClassSchedule() {
		return classSchedule;
	}

	public void setClassSchedule(ClassScheduleDTO classSchedule) {
		this.classSchedule = classSchedule;
	}

}
