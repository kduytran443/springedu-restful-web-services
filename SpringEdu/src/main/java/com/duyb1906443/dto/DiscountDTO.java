package com.duyb1906443.dto;

import java.sql.Timestamp;

public class DiscountDTO {
	private Long id;
	private Integer discountPercent;
	private Timestamp startDate;
	private Timestamp endDate;
	private Long classId;
	private Integer status;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getClassId() {
		return classId;
	}

	public void setClassId(Long classId) {
		this.classId = classId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getDiscountPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(Integer discountPercent) {
		this.discountPercent = discountPercent;
	}

	public Timestamp getStartDate() {
		return startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public Timestamp getEndDate() {
		return endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "DiscountDTO [id=" + id + ", discountPercent=" + discountPercent + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", classId=" + classId + ", status=" + status + "]";
	}

}
