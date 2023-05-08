package com.duyb1906443.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.duyb1906443.dto.ClassDTO;
import com.duyb1906443.entity.ClassEntity;

@Component
public class ClassConverter
		implements IConverterToEntity<ClassEntity, ClassDTO>, IConverterToDTO<ClassEntity, ClassDTO> {

	@Override
	public ClassDTO toDTO(ClassEntity entity) {
		ClassDTO dto = new ClassDTO();
		dto.setAccepted(entity.getAccepted());
		dto.setAvatar(entity.getAvatar());
		if (entity.getBackground() != null)
			dto.setBackground(entity.getBackground());
		if (entity.getVideo() != null)
			dto.setVideoData(entity.getVideo());
		if (entity.getId() != null)
			dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setStatus(entity.getStatus());
		dto.setVisiable(entity.getVisiable());
		dto.setCreatorId(entity.getCreator().getId());
		dto.setMinimumCompletionRate(entity.getMinimumCompletionRate());
		return dto;
	}

	@Override
	public List<ClassDTO> toDTOList(List<ClassEntity> entities) {
		List<ClassDTO> dtos = new ArrayList<>();

		for (ClassEntity classEntity : entities) {
			dtos.add(toDTO(classEntity));
		}
		return dtos;
	}

	@Override
	public ClassEntity toEntity(ClassDTO dto) {
		ClassEntity classEntity = new ClassEntity();

		if (dto.getAccepted() != null)
			classEntity.setAccepted(dto.getAccepted());
		if (dto.getAvatar() != null)
			classEntity.setAvatar(dto.getAvatar());
		if (dto.getFee() != null)
			classEntity.setFee(dto.getFee());
		if (dto.getId() != null)
			classEntity.setId(dto.getId());
		if (dto.getName() != null)
			classEntity.setName(dto.getName());
		if (dto.getShortDescription() != null)
			classEntity.setShortDescription(dto.getShortDescription());
		if (dto.getStatus() != null)
			classEntity.setStatus(dto.getStatus());
		if (dto.getVisiable() != null)
			classEntity.setVisiable(dto.getVisiable());
		if(dto.getPaypalAccount() != null) {
			classEntity.setPaypalAccount(dto.getPaypalAccount());			
		}
		if(dto.getMinimumCompletionRate() != null) {
			classEntity.setMinimumCompletionRate(dto.getMinimumCompletionRate());
		}

		return classEntity;
	}

	public ClassEntity toEntity(ClassDTO dto, ClassEntity classEntity) {
		if (dto.getAccepted() != null)
			classEntity.setAccepted(dto.getAccepted());
		if (dto.getAvatar() != null)
			classEntity.setAvatar(dto.getAvatar());
		if (dto.getFee() != null)
			classEntity.setFee(dto.getFee());
		if (dto.getId() != null)
			classEntity.setId(dto.getId());
		if (dto.getName() != null)
			classEntity.setName(dto.getName());
		if (dto.getShortDescription() != null)
			classEntity.setShortDescription(dto.getShortDescription());
		if (dto.getStatus() != null)
			classEntity.setStatus(dto.getStatus());
		if (dto.getVisiable() != null)
			classEntity.setVisiable(dto.getVisiable());
		if(dto.getVideoData() != null)
			classEntity.setVideo(dto.getVideoData());
		if(dto.getContent() != null)
			classEntity.setContent(dto.getContent());
		if(dto.getPaypalAccount() != null) {
			classEntity.setPaypalAccount(dto.getPaypalAccount());			
		}
		if(dto.getMinimumCompletionRate() != null) {
			classEntity.setMinimumCompletionRate(dto.getMinimumCompletionRate());
		}
		return classEntity;
	}

	@Override
	public List<ClassEntity> toEntityList(List<ClassDTO> dtos) {
		List<ClassEntity> entities = new ArrayList<>();

		for (ClassDTO classDTO : dtos) {
			entities.add(toEntity(classDTO));
		}
		return entities;
	}

}
