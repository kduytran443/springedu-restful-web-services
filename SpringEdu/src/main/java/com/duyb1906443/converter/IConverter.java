package com.duyb1906443.converter;

import java.util.List;

public interface IConverter<Entity, DTO> {
	
	public Entity toEntity(DTO dto);
	public DTO toDTO(Entity entity);
	public List<Entity> toEntityList(List<DTO> dtos);
	public List<DTO> toDTOList(List<Entity> entities);
}
