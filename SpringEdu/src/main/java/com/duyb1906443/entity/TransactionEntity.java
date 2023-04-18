package com.duyb1906443.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "`transaction`")
public class TransactionEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private Long fee;

	@OneToOne(mappedBy = "transaction")
	private ClassMemberEntity classMember;

	@Column(columnDefinition = "nvarchar(32)")
	private String code;

	public ClassMemberEntity getClassMember() {
		return classMember;
	}

	public void setClassMember(ClassMemberEntity classMember) {
		this.classMember = classMember;
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

	@Override
	public String toString() {
		return "TransactionEntity [id=" + id + ", fee=" + fee + ", classMember=" + classMember + ", code=" + code + "]";
	}
	
	
	
}
