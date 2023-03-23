package com.duyb1906443.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.duyb1906443.dto.ReportDTO;
import com.duyb1906443.entity.ReportEntity;

@Component
public class ReportConverter implements IConverterToDTO<ReportEntity, ReportDTO>, IConverterToEntity<ReportEntity, ReportDTO> {

	@Override
	public ReportEntity toEntity(ReportDTO dto) {
		ReportEntity entity = new ReportEntity();
		
		entity.setContent(dto.getContent());
		entity.setCreatedDate(dto.getCreatedDate());
		
		return entity;
	}

	@Override
	public List<ReportEntity> toEntityList(List<ReportDTO> dtos) {
		return dtos.stream().map(dto -> toEntity(dto)).collect(Collectors.toList());
	}

	@Override
	public ReportDTO toDTO(ReportEntity entity) {
		ReportDTO dto = new ReportDTO();
		
		dto.setClassId(entity.getClassEntity().getId());
		dto.setClassName(entity.getClassEntity().getName());
		dto.setContent(entity.getContent());
		dto.setCreatedDate(entity.getCreatedDate());
		dto.setId(entity.getId());
		dto.setUserId(entity.getUser().getId());
		dto.setUsername(entity.getUser().getUsername());
		dto.setUserAvatar(entity.getUser().getAvatar());
		dto.setChecked(entity.getChecked());
		
		return dto;
	}

	@Override
	public List<ReportDTO> toDTOList(List<ReportEntity> entities) {
		return entities.stream().map(entity -> toDTO(entity)).collect(Collectors.toList());
	}
	
}
