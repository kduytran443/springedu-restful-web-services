package com.duyb1906443.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.duyb1906443.dto.ClassMemberDTO;
import com.duyb1906443.entity.ClassMemberEntity;

@Component
public class ClassMemberConverter implements IConverterToDTO<ClassMemberEntity, ClassMemberDTO>,
		IConverterToEntity<ClassMemberEntity, ClassMemberDTO> {
	
	@Autowired
	private TransactionConverter transactionConverter;
	
	@Autowired
	private CertificationConverter certificationConverter;
	
	@Override
	public ClassMemberDTO toDTO(ClassMemberEntity entity) {
		ClassMemberDTO dto = new ClassMemberDTO();
		dto.setAvatar(entity.getUser().getAvatar());
		dto.setEmail(entity.getUser().getEmail());
		dto.setClassRole(entity.getClassRole().getCode());
		dto.setFullname(entity.getUser().getFullname());
		dto.setUserId(entity.getUser().getId());
		dto.setUsername(entity.getUser().getUsername());
		dto.setClassId(entity.getClassEntity().getId());
		if(entity.getTransaction() != null) {
			dto.setTransaction(transactionConverter.toDTO(entity.getTransaction()));
		}
		if(entity.getCertification() != null) {
			dto.setCertification(certificationConverter.toDTO(entity.getCertification()));
		}
		dto.setCreatedDate(entity.getCreatedDate());
		dto.setMemberAccepted(entity.getMemberAccepted());
		dto.setClassAccepted(entity.getClassAccepted());
		dto.setClassName(entity.getClassEntity().getName());
		dto.setClassAvatar(entity.getClassEntity().getAvatar());
		dto.setDiscount(entity.getDiscountPercent());
		return dto;
	}

	@Override
	public List<ClassMemberDTO> toDTOList(List<ClassMemberEntity> entities) {
		return entities.stream().map(item -> toDTO(item)).collect(Collectors.toList());
	}

	@Override
	public ClassMemberEntity toEntity(ClassMemberDTO dto) {
		ClassMemberEntity entity = new ClassMemberEntity();
		entity.setClassAccepted(dto.getClassAccepted());
		entity.setMemberAccepted(dto.getMemberAccepted());
		entity.setCreatedDate(dto.getCreatedDate());
		return entity;
	}

	public ClassMemberEntity toEntity(ClassMemberDTO dto, ClassMemberEntity entity) {
		entity.setClassAccepted(dto.getClassAccepted());
		entity.setMemberAccepted(dto.getMemberAccepted());
		if(dto.getCreatedDate() != null) entity.setCreatedDate(dto.getCreatedDate());
		return entity;
	}

	@Override
	public List<ClassMemberEntity> toEntityList(List<ClassMemberDTO> dtos) {
		List<ClassMemberEntity> entities = new ArrayList<>();
		for (ClassMemberDTO classMemberDTO : dtos) {
			entities.add(toEntity(classMemberDTO));
		}
		return entities;
	}

}
