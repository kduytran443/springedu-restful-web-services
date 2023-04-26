package com.duyb1906443.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.duyb1906443.dto.CertificationDTO;
import com.duyb1906443.dto.ClassDTO;
import com.duyb1906443.entity.CertificationEntity;
import com.duyb1906443.entity.ClassMemberEntity;

@Component
public class CertificationConverter implements IConverterToDTO<CertificationEntity, CertificationDTO>, IConverterToEntity<CertificationEntity, CertificationDTO> {
	
	@Autowired
	private ClassConverter classConverter;

	@Autowired
	private UserConverter userConverter;
	
	@Override
	public CertificationEntity toEntity(CertificationDTO dto) {
		CertificationEntity entity = new CertificationEntity();
		if(dto.getAvg() != null) entity.setAvg(dto.getAvg());
		if(dto.getComment() != null) entity.setComment(dto.getComment());
		if(dto.getId() != null) entity.setComment(dto.getComment());
		return entity;
	}
	public CertificationEntity toEntity(CertificationDTO dto, CertificationEntity entity) {
		if(dto.getAvg() != null) entity.setAvg(dto.getAvg());
		if(dto.getComment() != null) entity.setComment(dto.getComment());
		if(dto.getId() != null) entity.setComment(dto.getComment());
		return entity;
	}

	@Override
	public List<CertificationEntity> toEntityList(List<CertificationDTO> dtos) {
		return dtos.stream().map(item -> toEntity(item)).collect(Collectors.toList());
	}

	@Override
	public CertificationDTO toDTO(CertificationEntity entity) {
		CertificationDTO dto = new CertificationDTO();
		dto.setAvg(entity.getAvg());
		ClassMemberEntity classMemberEntity = entity.getClassMember();
		if(classMemberEntity != null) {
			ClassDTO classDTO  = classConverter.toDTO(classMemberEntity.getClassEntity());
			classDTO.setVideo(null);
			classDTO.setBackground(null);
			classDTO.setCategory(null);
			classDTO.setVideoData(null);
			dto.setClassDTO(classDTO);
			dto.setUsername(classMemberEntity.getUser().getUsername());
			dto.setFullname(classMemberEntity.getUser().getFullname());
		}
		dto.setComment(entity.getComment());
		dto.setDate(entity.getDate());
		dto.setId(entity.getId());
		dto.setUserId(entity.getClassMember().getUser().getId());
		return dto;
	}

	@Override
	public List<CertificationDTO> toDTOList(List<CertificationEntity> entities) {
		return entities.stream().map(item -> toDTO(item)).collect(Collectors.toList());
	}

}
