package com.duyb1906443.dto;

public class MessageDTO {
	private String content;
	private MessageType type;

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
