package com.duyb1906443.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duyb1906443.converter.ClassConverter;
import com.duyb1906443.dto.ClassDTO;
import com.duyb1906443.entity.CategoryEntity;
import com.duyb1906443.entity.ClassEntity;
import com.duyb1906443.entity.ClassMemberEntity;
import com.duyb1906443.entity.ClassRoleEntity;
import com.duyb1906443.entity.MeetingEntity;
import com.duyb1906443.entity.UserEntity;
import com.duyb1906443.entity.id.ClassMemberId;
import com.duyb1906443.repository.CategoryRepository;
import com.duyb1906443.repository.ClassMemberRepository;
import com.duyb1906443.repository.ClassRepository;
import com.duyb1906443.repository.ClassRoleRepository;
import com.duyb1906443.repository.FileRepository;
import com.duyb1906443.repository.MeetingRepository;
import com.duyb1906443.repository.UserRepository;
import com.duyb1906443.service.ClassService;
import com.duyb1906443.service.MeetingService;

@Service
public class ClassServiceImpl implements ClassService {

	@Autowired
	private ClassConverter classConverter;

	@Autowired
	private ClassRepository classRepository;

	@Autowired
	private FileRepository fileRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private MeetingRepository meetingRepository;

	@Autowired
	private MeetingService meetingService;
	
	@Autowired
	private ClassMemberRepository classMemberRepository;
	
	@Autowired
	private ClassRoleRepository classRoleRepository;

	@Override
	public ClassDTO save(ClassDTO classDTO) {
		ClassEntity classEntity = new ClassEntity();

		if (classDTO.getId() != null) {
			ClassEntity oldClassEntity = classRepository.findOne(classDTO.getId());

			classEntity = classConverter.toEntity(classDTO, oldClassEntity);
			classEntity = classRepository.save(classEntity);
		} else {
			
			classEntity = classConverter.toEntity(classDTO);
			classEntity.setContent(classDTO.getContent());
			
			classEntity.setVideo(classDTO.getVideoData());
			classEntity.setAvatar(classDTO.getAvatar());
			
			if (classDTO.getBackground() != null)
				classEntity.setBackground(classDTO.getBackground());
			
			classEntity.setPaypalAccount(classDTO.getPaypalAccount());
			
			classEntity.setAccepted(0);
			
			CategoryEntity category = categoryRepository.findOne(classDTO.getCategory().getId());
			classEntity.setCategory(category);
			
			Date date = new Date();
			classEntity.setCreatedDate(new Timestamp(date.getTime()));
			
			UserEntity user = userRepository.findOne(classDTO.getCreatorId());
			classEntity.setCreator(user);
			
			MeetingEntity meetingEntity = new MeetingEntity();
			String randomKey = "spring-edu-class-"+ classDTO.getId() + "-" +date.getTime();
			meetingEntity.setUrl(randomKey);
			meetingRepository.save(meetingEntity);
			
			classEntity.setMeeting(meetingEntity);
			
			ClassMemberEntity classMemberEntity = new ClassMemberEntity();
			classMemberEntity.setClassAccepted(1);
			
			
			ClassRoleEntity classRoleEntity = classRoleRepository.findOne(1L);
			classMemberEntity.setClassRole(classRoleEntity);
			classMemberEntity.setCreatedDate(new Timestamp(date.getTime()));
			
			classMemberEntity.setMemberAccepted(1);
			classMemberEntity.setUser(user);

			if(classDTO.getMinimumCompletionRate() != null) {
				classEntity.setMinimumCompletionRate(50);
			}
			
			classEntity = classRepository.save(classEntity);
			
			
			classMemberEntity.setClassEntity(classEntity);
			ClassMemberId classMemberId = new ClassMemberId();
			classMemberId.setClassId(classEntity.getId());
			classMemberId.setUserId(user.getId());
			classMemberEntity.setClassMemberId(classMemberId);

			classMemberRepository.save(classMemberEntity);
		}
		
		return classConverter.toDTO(classEntity);
	}

	@Override
	public List<Integer> getClassChart() {
		List<ClassEntity> classEntities = classRepository.findAll();
		
		Map<Integer, List<ClassEntity>> map = classEntities.stream().collect(Collectors.groupingBy(item -> item.getCreatedDate().getMonth()));
		
		List<Integer> integers = new ArrayList<>();
		
		for(int i = 0; i < 12; i++) {
			if(map.containsKey(i)) {
				integers.add(map.get(i).size());
			}
			else {
				integers.add(0);
			}
		}
		
		return integers;
	}

	@Override
	public boolean checkFavorited(Long classId, Long userId) {
		UserEntity userEntity = userRepository.findOne(userId);
		ClassEntity classEntity = classRepository.findOne(classId);

		if (userEntity.getFavoritedClassess() != null && userEntity.getFavoritedClassess().contains(classEntity)) {
			return true;
		}

		return false;
	}

	@Override
	public void favorite(Long classId, Long userId) {
		UserEntity userEntity = userRepository.findOne(userId);
		ClassEntity classEntity = classRepository.findOne(classId);

		List<ClassEntity> classEntities = userEntity.getFavoritedClassess();
		List<ClassEntity> filterList = classEntities.stream().filter(entity -> entity.getId() == classId).collect(Collectors.toList());
		
		if(filterList != null && filterList.size() != 0) {
			for (ClassEntity entity : filterList) {
				classEntities.remove(entity);
			}
		}
		else {
			classEntities.add(classEntity);
		}
		userEntity.setFavoritedClassess(classEntities);
		userRepository.save(userEntity);		
	}

}
