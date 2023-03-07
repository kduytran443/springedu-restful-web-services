package com.duyb1906443.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "`constructed_response_mark`")
public class ConstructedResponseMarkEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private int mark;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "constructed_response_test_id")
	private ConstructedResponseTestEntity constructedResponseTest;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}

	public ConstructedResponseTestEntity getConstructedResponseTest() {
		return constructedResponseTest;
	}

	public void setConstructedResponseTest(ConstructedResponseTestEntity constructedResponseTest) {
		this.constructedResponseTest = constructedResponseTest;
	}

}
