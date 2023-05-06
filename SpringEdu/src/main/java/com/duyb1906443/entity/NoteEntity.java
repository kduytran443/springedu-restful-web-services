package com.duyb1906443.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "`note`")
public class NoteEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(columnDefinition = "NTEXT")
	private String content;

	@Column(columnDefinition = "nvarchar(128)")
	private String name;

	@Column
	private Timestamp createdDate;

	@Column
	private Timestamp modifiedDate;

	@Column(columnDefinition = "tinyint")
	private Integer privateMode;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "note_folder_id")
	private NoteFolderEntity noteFolder;

	public Integer getPrivateMode() {
		return privateMode;
	}

	public void setPrivateMode(Integer privateMode) {
		this.privateMode = privateMode;
	}

	public Timestamp getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public NoteFolderEntity getNoteFolder() {
		return noteFolder;
	}

	public void setNoteFolder(NoteFolderEntity noteFolder) {
		this.noteFolder = noteFolder;
	}

}
