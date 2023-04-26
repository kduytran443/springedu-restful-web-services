package com.duyb1906443.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "certification")
public class CertificationEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private Float avg;

	@Column(columnDefinition = "nvarchar(256)")
	private String comment;

	@Column
	private Timestamp date;

	@OneToOne(mappedBy = "certification")
	private ClassMemberEntity classMember;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Float getAvg() {
		return avg;
	}

	public void setAvg(Float avg) {
		this.avg = avg;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public ClassMemberEntity getClassMember() {
		return classMember;
	}

	public void setClassMember(ClassMemberEntity classMember) {
		this.classMember = classMember;
	}

}
