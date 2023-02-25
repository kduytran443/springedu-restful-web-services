package com.duyb1906443.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "`class_role`")
public class ClassRoleEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String code;
	
	@Column(columnDefinition = "NVARCHAR(32)")
	private String name;
	
	@OneToMany(mappedBy = "classRole", fetch = FetchType.LAZY)
	private List<ClassMemberEntity> classMember;

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

	public List<ClassMemberEntity> getClassMember() {
		return classMember;
	}

	public void setClassMember(List<ClassMemberEntity> classMember) {
		this.classMember = classMember;
	}
	
}
