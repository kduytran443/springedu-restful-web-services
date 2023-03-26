package com.duyb1906443.dto;

import java.sql.Timestamp;
import java.util.List;

public class NotificationDTO {
	private Long id;
	private String content;
	private Timestamp time;
	private String redirectUrl;
	private String senderUsername;
	private String senderAvatar;
	private String senderFullname;
	private String receiverUsername;
	private Long receiverId;
	private Integer read;
	private Long senderId;
	private List<Long> receiverIds;

	public Long getSenderId() {
		return senderId;
	}

	public void setSenderId(Long senderId) {
		this.senderId = senderId;
	}

	public List<Long> getReceiverIds() {
		return receiverIds;
	}

	public void setReceiverIds(List<Long> receiverIds) {
		this.receiverIds = receiverIds;
	}

	public String getSenderFullname() {
		return senderFullname;
	}

	public void setSenderFullname(String senderFullname) {
		this.senderFullname = senderFullname;
	}

	public Long getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(Long receiverId) {
		this.receiverId = receiverId;
	}

	public String getReceiverUsername() {
		return receiverUsername;
	}

	public void setReceiverUsername(String receiverUsername) {
		this.receiverUsername = receiverUsername;
	}

	public Integer getRead() {
		return read;
	}

	public void setRead(Integer read) {
		this.read = read;
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

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public String getRedirectUrl() {
		return redirectUrl;
	}

	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}

	public String getSenderUsername() {
		return senderUsername;
	}

	public void setSenderUsername(String senderUsername) {
		this.senderUsername = senderUsername;
	}

	public String getSenderAvatar() {
		return senderAvatar;
	}

	public void setSenderAvatar(String senderAvatar) {
		this.senderAvatar = senderAvatar;
	}

}
