package com.duyb1906443.entity.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ClassMemberId implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Column(name = "user_id")
	private Long userId;

	@Column(name = "class_id")
	private Long classId;

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
	
}
