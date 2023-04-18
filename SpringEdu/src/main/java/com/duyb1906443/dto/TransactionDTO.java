package com.duyb1906443.dto;

public class TransactionDTO {
	private Long id;
	private Long fee;
	private String code;
	private Long userId;
	private Long classId;
	
	

	@Override
	public String toString() {
		return "TransactionDTO [id=" + id + ", fee=" + fee + ", code=" + code + ", userId=" + userId + ", classId="
				+ classId + "]";
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getFee() {
		return fee;
	}

	public void setFee(Long fee) {
		this.fee = fee;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
