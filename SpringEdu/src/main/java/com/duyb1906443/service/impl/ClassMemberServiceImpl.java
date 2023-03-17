package com.duyb1906443.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duyb1906443.converter.ClassConverter;
import com.duyb1906443.converter.ClassMemberConverter;
import com.duyb1906443.dto.ClassMemberDTO;
import com.duyb1906443.entity.ClassEntity;
import com.duyb1906443.entity.ClassMemberEntity;
import com.duyb1906443.entity.ClassRoleEntity;
import com.duyb1906443.entity.DiscountEntity;
import com.duyb1906443.entity.UserEntity;
import com.duyb1906443.entity.id.ClassMemberId;
import com.duyb1906443.repository.ClassMemberRepository;
import com.duyb1906443.repository.ClassRepository;
import com.duyb1906443.repository.ClassRoleRepository;
import com.duyb1906443.repository.DiscountRepository;
import com.duyb1906443.repository.UserRepository;
import com.duyb1906443.service.ClassMemberService;

@Service
public class ClassMemberServiceImpl implements ClassMemberService {

	@Autowired
	private ClassMemberRepository classMemberRepository;

	@Autowired
	private ClassRepository classRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ClassRoleRepository classRoleRepository;

	@Autowired
	private ClassMemberConverter classMemberConverter;

	@Autowired
	private DiscountRepository discountRepository;
	

	@Override
	public List<ClassMemberDTO> findAllByClassId(Long classId) {
		ClassEntity classEntity = classRepository.findOne(classId);
		List<ClassMemberEntity> classMemberEntities = classMemberRepository.findAllByClassEntity(classEntity);
		List<ClassMemberEntity> filterMembers = classMemberEntities.stream()
				.filter(member -> (member.getMemberAccepted() == 1 && member.getClassAccepted() == 1))
				.collect(Collectors.toList());
		return classMemberConverter.toDTOList(filterMembers);
	}

	@Override
	public List<ClassMemberDTO> findAllByUserId(Long userId) {
		UserEntity userEntity = userRepository.findOne(userId);
		List<ClassMemberEntity> classMemberEntities = classMemberRepository.findAllByUser(userEntity);
		List<ClassMemberEntity> filterMembers = classMemberEntities.stream()
				.filter(member -> (member.getMemberAccepted() == 1 && member.getClassAccepted() == 1))
				.collect(Collectors.toList());
		return classMemberConverter.toDTOList(filterMembers);
	}

	@Override
	public ClassMemberDTO save(ClassMemberDTO classMemberDTO) {

		ClassEntity classEntity = classRepository.findOne(classMemberDTO.getClassId());
		UserEntity userEntity = userRepository.findOne(classMemberDTO.getUserId());

		ClassMemberEntity classMemberEntity = classMemberRepository.findOneByClassEntityAndUser(classEntity,
				userEntity);

		System.out.println(userEntity.getUsername() + "  - class: " + classEntity.getName());

		if (classMemberEntity == null) { // tạo mới
			System.out.println("Null nè");
			classMemberEntity = classMemberConverter.toEntity(classMemberDTO);
			classMemberEntity.setClassEntity(classEntity);
			classMemberEntity.setUser(userEntity);

			ClassRoleEntity classRoleEntity = classRoleRepository.findOneByCode(classMemberDTO.getClassRole());

			classMemberEntity.setClassRole(classRoleEntity);

			Date date = new Date();
			classMemberEntity.setCreatedDate(new Timestamp(date.getTime()));

			if (classMemberDTO.getDiscountId() != null) {
				DiscountEntity discountEntity = discountRepository.findOne(classMemberDTO.getDiscountId());
				classMemberEntity.setDiscount(discountEntity);
			}
			ClassMemberId classMemberId = new ClassMemberId();
			classMemberId.setClassId(classEntity.getId());
			classMemberId.setUserId(userEntity.getId());
			classMemberEntity.setClassMemberId(classMemberId);
		} else {
			classMemberEntity = classMemberConverter.toEntity(classMemberDTO, classMemberEntity);

			ClassRoleEntity classRoleEntity = classRoleRepository.findOneByCode(classMemberDTO.getClassRole());
			classMemberEntity.setClassRole(classRoleEntity);

			if (classMemberDTO.getDiscountId() != null) {
				DiscountEntity discountEntity = discountRepository.findOne(classMemberDTO.getDiscountId());
				classMemberEntity.setDiscount(discountEntity);
			}
		}
		classMemberEntity = classMemberRepository.save(classMemberEntity);

		return classMemberConverter.toDTO(classMemberEntity);
	}

	@Override
	public void delete(ClassMemberDTO classMemberDTO) {
		ClassEntity classEntity = classRepository.findOne(classMemberDTO.getClassId());
		UserEntity userEntity = userRepository.findOne(classMemberDTO.getUserId());

		ClassMemberEntity classMemberEntity = classMemberRepository.findOneByClassEntityAndUser(classEntity,
				userEntity);
		classMemberEntity.setClassAccepted(0);
		classMemberEntity.setMemberAccepted(0);
		classMemberEntity = classMemberRepository.save(classMemberEntity);
	}

	@Override
	public List<ClassMemberDTO> findAllByUsername(String username) {
		UserEntity userEntity = userRepository.findOneByUsername(username);
		List<ClassMemberEntity> entities = classMemberRepository.findAllByUser(userEntity);
		List<ClassMemberEntity> filterMembers = entities.stream()
				.filter(member -> (member.getMemberAccepted() == 1 && member.getClassAccepted() == 1))
				.collect(Collectors.toList());
		return classMemberConverter.toDTOList(filterMembers);
	}

	@Override
	public List<ClassMemberDTO> findAllRequestMemberByClassId(Long classId) {
		ClassEntity classEntity = classRepository.findOne(classId);
		List<ClassMemberEntity> classMemberEntities = classMemberRepository.findAllByClassEntity(classEntity);
		List<ClassMemberEntity> filterMembers = classMemberEntities.stream()
				.filter(member -> (member.getMemberAccepted() == 1 && member.getClassAccepted() == 0))
				.collect(Collectors.toList());
		return classMemberConverter.toDTOList(filterMembers);
	}

	@Override
	public List<ClassMemberDTO> findAllInvitedMemberByClassId(Long classId) {
		ClassEntity classEntity = classRepository.findOne(classId);
		List<ClassMemberEntity> classMemberEntities = classMemberRepository.findAllByClassEntity(classEntity);
		List<ClassMemberEntity> filterMembers = classMemberEntities.stream()
				.filter(member -> (member.getMemberAccepted() == 0 && member.getClassAccepted() == 1))
				.collect(Collectors.toList());
		return classMemberConverter.toDTOList(filterMembers);
	}

	@Override
	public List<ClassMemberDTO> findAllRequestMemberByUsername(String username) {
		UserEntity userEntity = userRepository.findOneByUsername(username);
		List<ClassMemberEntity> entities = classMemberRepository.findAllByUser(userEntity);
		List<ClassMemberEntity> filterMembers = entities.stream()
				.filter(member -> (member.getMemberAccepted() == 1 && member.getClassAccepted() == 0))
				.collect(Collectors.toList());
		return classMemberConverter.toDTOList(filterMembers);
	}

	@Override
	public List<ClassMemberDTO> findAllInvitedMemberByUsername(String username) {
		UserEntity userEntity = userRepository.findOneByUsername(username);
		List<ClassMemberEntity> entities = classMemberRepository.findAllByUser(userEntity);
		List<ClassMemberEntity> filterMembers = entities.stream()
				.filter(member -> (member.getMemberAccepted() == 0 && member.getClassAccepted() == 1))
				.collect(Collectors.toList());
		return classMemberConverter.toDTOList(filterMembers);
	}

	@Override
	public ClassMemberDTO acceptRequest(ClassMemberDTO classMemberDTO) {
		ClassEntity classEntity = classRepository.findOne(classMemberDTO.getClassId());
		UserEntity userEntity = userRepository.findOne(classMemberDTO.getUserId());

		ClassMemberEntity classMemberEntity = classMemberRepository.findOneByClassEntityAndUser(classEntity,
				userEntity);
		classMemberEntity.setClassAccepted(1);
		classMemberEntity.setMemberAccepted(1);
		classMemberEntity = classMemberRepository.save(classMemberEntity);
		return classMemberConverter.toDTO(classMemberEntity);
	}

	@Override
	public Integer countAllMember(Long classId) {
		ClassEntity classEntity = classRepository.findOne(classId);
		List<ClassMemberEntity> classMemberEntities = classMemberRepository.findAllByClassEntity(classEntity);
		List<ClassMemberEntity> filterMembers = classMemberEntities.stream()
				.filter(member -> (member.getMemberAccepted() == 1 && member.getClassAccepted() == 1))
				.collect(Collectors.toList());
		return filterMembers.size();
	}

}
