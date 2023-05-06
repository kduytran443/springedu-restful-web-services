package com.duyb1906443.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duyb1906443.converter.ClassScheduleConverter;
import com.duyb1906443.dto.ClassScheduleDTO;
import com.duyb1906443.entity.ClassEntity;
import com.duyb1906443.entity.ClassMemberEntity;
import com.duyb1906443.entity.ClassScheduleEntity;
import com.duyb1906443.entity.UserEntity;
import com.duyb1906443.entity.WeeklyClassScheduleEntity;
import com.duyb1906443.repository.ClassMemberRepository;
import com.duyb1906443.repository.ClassRepository;
import com.duyb1906443.repository.ClassScheduleRepository;
import com.duyb1906443.repository.UserRepository;
import com.duyb1906443.repository.WeeklyClassScheduleRepository;
import com.duyb1906443.service.ClassScheduleService;

@Service
public class ClassScheduleServiceImpl implements ClassScheduleService {

	@Autowired
	private ClassScheduleRepository classScheduleRepository;

	@Autowired
	private ClassScheduleConverter classScheduleConverter;

	@Autowired
	private ClassRepository classRepository;

	@Autowired
	private WeeklyClassScheduleRepository weeklyClassScheduleRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ClassMemberRepository classMemberRepository;

	@Override
	public List<ClassScheduleDTO> findAllByClassId(Long classId) {
		ClassEntity classEntity = classRepository.findOne(classId);
		if (classEntity.getClassSchedules() != null) {
			List<ClassScheduleDTO> classScheduleDTOs = classScheduleConverter
					.toDTOList(classEntity.getClassSchedules());
			return classScheduleDTOs;
		}
		return null;
	}

	@Override
	public ClassScheduleDTO save(ClassScheduleDTO classScheduleDTO) {

		ClassScheduleEntity classScheduleEntity = null;
		if (classScheduleDTO.getId() != null) { // edit
			classScheduleEntity = classScheduleRepository.findOne(classScheduleDTO.getId());

			classScheduleEntity = classScheduleConverter.toEntity(classScheduleDTO, classScheduleEntity);
		} else {
			classScheduleEntity = classScheduleConverter.toEntity(classScheduleDTO);
		}

		if (classScheduleDTO.getWeeklyClassScheduleId() != null) {
			WeeklyClassScheduleEntity weeklyClassScheduleEntity = weeklyClassScheduleRepository
					.findOne(classScheduleDTO.getWeeklyClassScheduleId());
			classScheduleEntity.setWeeklyClassSchedule(weeklyClassScheduleEntity);
		}

		if (classScheduleDTO.getClassId() != null) {
			ClassEntity classEntity = classRepository.findOne(classScheduleDTO.getClassId());
			classScheduleEntity.setClassEntity(classEntity);
		}

		if (classScheduleEntity != null) {
			classScheduleEntity = classScheduleRepository.save(classScheduleEntity);
			return classScheduleConverter.toDTO(classScheduleEntity);
		}

		return null;
	}

	@Override
	public void delete(Long id) {
		classScheduleRepository.delete(id);
	}

	@Override
	public ClassScheduleDTO findOneByClassScheduleId(Long classScheduleId) {
		ClassScheduleEntity scheduleEntity = classScheduleRepository.findOne(classScheduleId);

		if (scheduleEntity != null) {
			return classScheduleConverter.toDTO(scheduleEntity);
		}

		return null;
	}

	@Override
	public List<ClassScheduleDTO> findAllByClassUserId(Long userId) {

		UserEntity userEntity = userRepository.findOne(userId);
		List<ClassMemberEntity> classMemberEntities = classMemberRepository.findAllByUser(userEntity);

		List<ClassEntity> classEntities = classMemberEntities.stream()
				.filter(classMember -> (classMember.getClassAccepted() == 1 && classMember.getMemberAccepted() == 1))
				.map(classMember -> classMember.getClassEntity()).collect(Collectors.toList());

		List<ClassScheduleEntity> classScheduleEntities = new ArrayList<>();

		for (ClassEntity classEntity : classEntities) {
			List<ClassScheduleEntity> entities = classEntity.getClassSchedules();
			for (ClassScheduleEntity entity : entities) {
				classScheduleEntities.add(entity);
			}
		}

		return classScheduleConverter.toDTOList(classScheduleEntities);
	}

}
