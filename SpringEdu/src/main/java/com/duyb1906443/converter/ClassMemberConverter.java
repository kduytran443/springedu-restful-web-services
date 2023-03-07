package com.duyb1906443.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.duyb1906443.dto.ClassMemberDTO;
import com.duyb1906443.entity.ClassMemberEntity;

@Component
public class ClassMemberConverter implements IConverterToDTO<ClassMemberEntity, ClassMemberDTO> {

	@Override
	public ClassMemberDTO toDTO(ClassMemberEntity entity) {
		ClassMemberDTO dto = new ClassMemberDTO();
		dto.setAvatar(entity.getUser().getAvatar());
		dto.setEmail(entity.getUser().getEmail());
		dto.setClassRole(entity.getClassRole().getCode());
		dto.setFullname(entity.getUser().getFullname());
		dto.setUserId(entity.getUser().getId());
		dto.setUsername(entity.getUser().getUsername());
		return dto;
	}

	@Override
	public List<ClassMemberDTO> toDTOList(List<ClassMemberEntity> entities) {
		List<ClassMemberDTO> dtos = new ArrayList<>();
		
		for (ClassMemberEntity classMemberEntity : entities) {
			dtos.add(toDTO(classMemberEntity));
		}
		
		return dtos;
	}

}
