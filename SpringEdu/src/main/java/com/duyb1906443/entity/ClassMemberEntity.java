package com.duyb1906443.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.duyb1906443.entity.id.ClassMemberId;

@Entity
@Table(name = "class_member")
public class ClassMemberEntity implements Serializable {
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
	private Timestamp createdDate;

	@Column(columnDefinition = "tinyint")
	private int memberAccepted;

	@Column(columnDefinition = "tinyint")
	private int classAccepted;

	@OneToOne
	@JoinColumn(name = "transaction_id", nullable = true)
	private TransactionEntity transaction;

	@OneToOne
	@JoinColumn(name = "certification_id", nullable = true)
	private CertificationEntity certification;

	@ManyToOne
	@JoinColumn(name = "class_role_id")
	private ClassRoleEntity classRole;

	public CertificationEntity getCertification() {
		return certification;
	}

	public void setCertification(CertificationEntity certification) {
		this.certification = certification;
	}

	@Column(nullable = true)
	private Integer discountPercent;

	public TransactionEntity getTransaction() {
		return transaction;
	}

	public void setTransaction(TransactionEntity transaction) {
		this.transaction = transaction;
	}

	public int getMemberAccepted() {
		return memberAccepted;
	}

	public void setMemberAccepted(int memberAccepted) {
		this.memberAccepted = memberAccepted;
	}

	public int getClassAccepted() {
		return classAccepted;
	}

	public void setClassAccepted(int classAccepted) {
		this.classAccepted = classAccepted;
	}

	public Integer getDiscountPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(Integer discountPercent) {
		this.discountPercent = discountPercent;
	}

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

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public ClassRoleEntity getClassRole() {
		return classRole;
	}

	public void setClassRole(ClassRoleEntity classRole) {
		this.classRole = classRole;
	}

}
