package com.duyb1906443.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.duyb1906443.dto.TransactionDTO;
import com.duyb1906443.entity.TransactionEntity;

@Component
public class TransactionConverter implements IConverterToEntity<TransactionEntity, TransactionDTO>, IConverterToDTO<TransactionEntity, TransactionDTO> {

	@Override
	public TransactionEntity toEntity(TransactionDTO dto) {
		TransactionEntity entity = new TransactionEntity();
		entity.setCode(dto.getCode());
		entity.setFee(dto.getFee());
		return entity;
	}

	@Override
	public List<TransactionEntity> toEntityList(List<TransactionDTO> dtos) {
		return dtos.stream().map(item -> toEntity(item)).collect(Collectors.toList());
	}

	@Override
	public TransactionDTO toDTO(TransactionEntity entity) {
		TransactionDTO dto = new TransactionDTO();
		dto.setCode(entity.getCode());
		dto.setFee(entity.getFee());
		dto.setId(entity.getId());
		dto.setClassId(entity.getClassMember().getClassMemberId().getClassId());
		dto.setUserId(entity.getClassMember().getClassMemberId().getUserId());
		dto.setUsername(entity.getClassMember().getUser().getUsername());
		return dto;
	}

	@Override
	public List<TransactionDTO> toDTOList(List<TransactionEntity> entities) {
		return entities.stream().map(item -> toDTO(item)).collect(Collectors.toList());
	}

}
