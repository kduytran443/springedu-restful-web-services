package com.duyb1906443.dto;


public class CategoryDTO {
	private Long id;
	private String code;
	private String name;
	private String description;
	private String image;

	public CategoryDTO() {
	}

	public CategoryDTO(Long id, String code, String name, String description, String image) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.description = description;
		this.image = image;
	}

	@Override
	public String toString() {
		return "CategoryDTO [id=" + id + ", code=" + code + ", name=" + name + ", description=" + description
				+ ", image=" + image + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}


}
