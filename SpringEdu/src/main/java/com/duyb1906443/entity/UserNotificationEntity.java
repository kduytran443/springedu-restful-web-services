package com.duyb1906443.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "`user_notification`")
public class UserNotificationEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "notification_id")
	private NotificationEntity notification;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity user;

	@Column(columnDefinition = "tinyint")
	private Integer readed;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public NotificationEntity getNotification() {
		return notification;
	}

	public void setNotification(NotificationEntity notification) {
		this.notification = notification;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public Integer getReaded() {
		return readed;
	}

	public void setReaded(Integer readed) {
		this.readed = readed;
	}

}
