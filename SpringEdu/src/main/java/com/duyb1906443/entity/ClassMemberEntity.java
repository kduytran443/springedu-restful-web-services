package com.duyb1906443.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.duyb1906443.entity.id.ClassMemberId;

@Entity
@Table(name = "class_member")
public class ClassMemberEntity implements Serializable{
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ClassMemberId classMemberId;

	@ManyToOne
	@MapsId("user_id")
	@JoinColumn(name = "user_id")
	private UserEntity user;

	@ManyToOne
	@MapsId("class_id")
	@JoinColumn(name = "class_id")
	private ClassEntity classEntity;

	@Column
	private Date createdDate;

	@Column(nullable = true)
	private float fee;

	@ManyToOne
	@JoinColumn(name = "class_role_id")
	private ClassRoleEntity classRole;

	public ClassMemberId getClassMemberId() {
		return classMemberId;
	}

	public void setClassMemberId(ClassMemberId classMemberId) {
		this.classMemberId = classMemberId;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public ClassEntity getClassEntity() {
		return classEntity;
	}

	public void setClassEntity(ClassEntity classEntity) {
		this.classEntity = classEntity;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public float getFee() {
		return fee;
	}

	public void setFee(float fee) {
		this.fee = fee;
	}

	public ClassRoleEntity getClassRole() {
		return classRole;
	}

	public void setClassRole(ClassRoleEntity classRole) {
		this.classRole = classRole;
	}

}
