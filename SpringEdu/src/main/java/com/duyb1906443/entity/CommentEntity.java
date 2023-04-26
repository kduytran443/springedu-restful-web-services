package com.duyb1906443.entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	private Timestamp createdDate;

	@Column(columnDefinition = "tinyint default '0'")
	private Integer privateMode;

	@OneToMany(mappedBy = "parentComment")
	private List<CommentEntity> replies;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parent_id")
	private CommentEntity parentComment;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "class_lesson_id")
	private ClassLessonEntity classLesson;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private UserEntity user;

	@Column(columnDefinition = "tinyint")
	private Integer status;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

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

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Integer getPrivateMode() {
		return privateMode;
	}

	public void setPrivateMode(Integer privateMode) {
		this.privateMode = privateMode;
	}

	public List<CommentEntity> getReplies() {
		return replies;
	}

	public void setReplies(List<CommentEntity> replies) {
		this.replies = replies;
	}

	public ClassLessonEntity getClassLesson() {
		return classLesson;
	}

	public void setClassLesson(ClassLessonEntity classLesson) {
		this.classLesson = classLesson;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public CommentEntity getParentComment() {
		return parentComment;
	}

	public void setParentComment(CommentEntity parentComment) {
		this.parentComment = parentComment;
	}

}
