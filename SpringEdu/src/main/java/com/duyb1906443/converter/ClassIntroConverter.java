package com.duyb1906443.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.duyb1906443.dto.ClassIntroDTO;
import com.duyb1906443.dto.DateDTO;
import com.duyb1906443.entity.ClassEntity;

@Component
public class ClassIntroConverter implements IConverterToDTO<ClassEntity, ClassIntroDTO> {

	@Autowired
	private ClassScheduleConverter classScheduleConverter;

	@Override
	public ClassIntroDTO toDTO(ClassEntity entity) {
		ClassIntroDTO dto = new ClassIntroDTO();
		if (entity.getId() != null)
			dto.setId(entity.getId());
		dto.setBackgroundImage(entity.getBackgroundImage().getData());
		dto.setCategoryCode(entity.getCategory().getCode());
		dto.setCategoryName(entity.getCategory().getName());
		dto.setClassSchedule(classScheduleConverter.toDTO(entity.getClassSchedule()));
		dto.setCreatedDate(entity.getCreatedDate());
		dto.setName(entity.getName());
		dto.setStatus(entity.getStatus());
		dto.setTextData(entity.getTextData().getContent());
		dto.setVideo(entity.getVideo().getData());
		dto.setVisiable(entity.getVisiable());
		dto.setUserAvatar(entity.getCreator().getAvatar());
		dto.setUsername(entity.getCreator().getUsername());
		dto.setUserFullname(entity.getCreator().getFullname());
		return dto;
	}

	@Override
	public List<ClassIntroDTO> toDTOList(List<ClassEntity> entities) {
		List<ClassIntroDTO> dtos = new ArrayList<ClassIntroDTO>();

		for (ClassEntity classEntity : entities) {
			dtos.add(toDTO(classEntity));
		}

		return dtos;
	}

}
