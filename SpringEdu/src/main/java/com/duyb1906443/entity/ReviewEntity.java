package com.duyb1906443.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.duyb1906443.entity.id.ReviewId;

@Entity
@Table(name = "`review`")
public class ReviewEntity implements Serializable{
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ReviewId reviewId;
	
	@ManyToOne
	@MapsId("user_id")
	@JoinColumn(name = "user_id")
	private UserEntity users;

	@ManyToOne
	@MapsId("class_id")
	@JoinColumn(name = "class_id")
	private ClassEntity classEntity;
	
	@Column(columnDefinition = "tinyint default 0")
	private float stars;
	
	@Column(columnDefinition = "NVARCHAR(512)")
	private String comment;

	public ReviewId getReviewId() {
		return reviewId;
	}

	public void setReviewId(ReviewId reviewId) {
		this.reviewId = reviewId;
	}

	public UserEntity getUsers() {
		return users;
	}

	public void setUsers(UserEntity users) {
		this.users = users;
	}

	public ClassEntity getClassEntity() {
		return classEntity;
	}

	public void setClassEntity(ClassEntity classEntity) {
		this.classEntity = classEntity;
	}

	public float getStars() {
		return stars;
	}

	public void setStars(float stars) {
		this.stars = stars;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
	
}
