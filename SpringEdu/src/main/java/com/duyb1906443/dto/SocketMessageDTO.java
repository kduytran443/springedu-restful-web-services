package com.duyb1906443.dto;

import java.util.List;

public class SocketMessageDTO {
	private String content;
	private MessageType type;
	private List<Long> receivers;

	public List<Long> getReceivers() {
		return receivers;
	}

	public void setReceivers(List<Long> receivers) {
		this.receivers = receivers;
	}

	public enum MessageType {
		NOTIFICATION
	}

	public MessageType getType() {
		return type;
	}

	public void setType(MessageType type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
