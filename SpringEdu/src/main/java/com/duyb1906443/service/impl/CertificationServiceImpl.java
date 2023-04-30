package com.duyb1906443.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duyb1906443.converter.CertificationConverter;
import com.duyb1906443.dto.CertificationDTO;
import com.duyb1906443.entity.CertificationEntity;
import com.duyb1906443.entity.ClassEntity;
import com.duyb1906443.entity.ClassMemberEntity;
import com.duyb1906443.entity.UserEntity;
import com.duyb1906443.entity.id.ClassMemberId;
import com.duyb1906443.repository.CertificationRepository;
import com.duyb1906443.repository.ClassMemberRepository;
import com.duyb1906443.repository.ClassRepository;
import com.duyb1906443.repository.UserRepository;
import com.duyb1906443.service.CertificationService;
import com.duyb1906443.service.ClassMemberService;
import com.duyb1906443.service.ClassService;
import com.duyb1906443.service.UserService;

@Service
public class CertificationServiceImpl implements CertificationService {

	@Autowired
	private ClassMemberRepository classMemberRepository;

	@Autowired
	private ClassRepository classRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CertificationConverter certificationConverter;

	@Autowired
	private CertificationRepository certificationRepository;

	@Override
	public CertificationDTO findOneById(Long id) {
		CertificationEntity certificationEntity = certificationRepository.findOne(id);
		return certificationConverter.toDTO(certificationEntity);
	}

	@Override
	public CertificationDTO save(CertificationDTO certificationDTO) {
		CertificationEntity certificationEntity = null;
		ClassMemberEntity classMemberEntity = null;
		if(certificationDTO.getId() != null) {
			CertificationEntity entity = certificationRepository.findOne(certificationDTO.getId());
			certificationEntity = certificationConverter.toEntity(certificationDTO, entity);
		}
		else {
			certificationEntity = certificationConverter.toEntity(certificationDTO);

			ClassEntity classEntity = classRepository.findOne(certificationDTO.getClassDTO().getId());
			UserEntity userEntity = userRepository.findOne(certificationDTO.getUserId());
			
			classMemberEntity = classMemberRepository.findOneByClassEntityAndUser(classEntity, userEntity);
			certificationEntity.setClassMember(classMemberEntity);

			ClassMemberId classMemberId = new ClassMemberId();
			classMemberId.setClassId(classEntity.getId());
			classMemberId.setUserId(userEntity.getId());
			classMemberEntity.setClassMemberId(classMemberId);
			
			Date date = new Date();
			Timestamp timestamp = new Timestamp(date.getTime());
			certificationEntity.setDate(timestamp);
		}
		
		if(certificationEntity != null) {
			certificationEntity = certificationRepository.save(certificationEntity);
			classMemberEntity.setCertification(certificationEntity);
			classMemberRepository.save(classMemberEntity);
			return certificationConverter.toDTO(certificationEntity);
		}
		
		return null;
	}

	@Override
	public CertificationDTO delete(Long id) {
		CertificationEntity certificationEntity = certificationRepository.findOne(id);
		CertificationDTO certificationDTO = certificationConverter.toDTO(certificationEntity);
		certificationRepository.delete(certificationEntity);
		return certificationDTO;
	}

	@Override
	public List<CertificationDTO> findAllByUserId(Long userId) {
		UserEntity userEntity = userRepository.findOne(userId);
		List<ClassMemberEntity> classMemberEntities = classMemberRepository.findAllByUser(userEntity);

		List<CertificationEntity> certificationEntities = classMemberEntities.stream()
				.filter(item -> item.getCertification() != null).map(item -> item.getCertification())
				.collect(Collectors.toList());

		return certificationConverter.toDTOList(certificationEntities);
	}

	@Override
	public List<CertificationDTO> findAllByClassId(Long classId) {
		ClassEntity classEntity = classRepository.findOne(classId);
		List<ClassMemberEntity> classMemberEntities = classMemberRepository.findAllByClassEntity(classEntity);

		List<CertificationEntity> certificationEntities = classMemberEntities.stream()
				.filter(item -> item.getCertification() != null).map(item -> item.getCertification())
				.collect(Collectors.toList());

		return certificationConverter.toDTOList(certificationEntities);
	}

}
