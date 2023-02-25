package com.duyb1906443.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "comment")
public class CommentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(columnDefinition = "nvarchar(512)")
	private String content;

	@Column
	private Date createdDate;

	@Column(columnDefinition = "tinyint")
	private Integer privateMode;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parent_comment_id", nullable = true)
	private CommentEntity parentComment;

	@OneToOne(mappedBy = "parentComment")
	private CommentEntity comment;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "class_id")
	private ClassEntity classEntity;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private UserEntity user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Integer getPrivateMode() {
		return privateMode;
	}

	public void setPrivateMode(Integer privateMode) {
		this.privateMode = privateMode;
	}

	public CommentEntity getParentComment() {
		return parentComment;
	}

	public void setParentComment(CommentEntity parentComment) {
		this.parentComment = parentComment;
	}

	public CommentEntity getComment() {
		return comment;
	}

	public void setComment(CommentEntity comment) {
		this.comment = comment;
	}

	public ClassEntity getClassEntity() {
		return classEntity;
	}

	public void setClassEntity(ClassEntity classEntity) {
		this.classEntity = classEntity;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

}
