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
@Table(name = "`read_message`")
public class ReadMessageEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "message_id")
	private MessageEntity message;

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

	public MessageEntity getMessage() {
		return message;
	}

	public void setMessage(MessageEntity message) {
		this.message = message;
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
