package com.duyb1906443.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.duyb1906443.dto.FileDTO;
import com.duyb1906443.entity.FileEntity;

@Component
public class FileConverter implements IConverterToDTO<FileEntity, FileDTO> {

	@Override
	public FileDTO toDTO(FileEntity entity) {
		FileDTO dto = new FileDTO();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setSize(entity.getSize());
		dto.setType(entity.getType());
		dto.setData(entity.getData());
		return dto;
	}

	@Override
	public List<FileDTO> toDTOList(List<FileEntity> entities) {
		List<FileDTO> dtos = new ArrayList<>();
		
		for (FileEntity fileEntity : entities) {
			dtos.add(toDTO(fileEntity));
		}
		
		return dtos;
	}
	
}
