package com.duyb1906443.dto;

import java.util.List;

public class ConstructedResponseTestDTO {
	private Long id;
	private String name;
	private String content;
	private List<FileDTO> fileEntity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<FileDTO> getFileEntity() {
		return fileEntity;
	}

	public void setFileEntity(List<FileDTO> fileEntity) {
		this.fileEntity = fileEntity;
	}

}
