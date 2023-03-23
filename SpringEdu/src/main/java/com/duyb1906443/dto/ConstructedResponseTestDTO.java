package com.duyb1906443.dto;

import java.util.List;

public class ConstructedResponseTestDTO {
	private Long id;
	private String name;
	private String content;
	private List<FileDTO> files;
	private Float mark;
	private Long classExcerciseId;

	public Long getClassExcerciseId() {
		return classExcerciseId;
	}

	public void setClassExcerciseId(Long classExcerciseId) {
		this.classExcerciseId = classExcerciseId;
	}

	public Float getMark() {
		return mark;
	}

	public void setMark(Float mark) {
		this.mark = mark;
	}

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

	public List<FileDTO> getFiles() {
		return files;
	}

	public void setFiles(List<FileDTO> files) {
		this.files = files;
	}

}
