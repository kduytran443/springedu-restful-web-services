package com.duyb1906443.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duyb1906443.converter.TransactionConverter;
import com.duyb1906443.dto.TransactionDTO;
import com.duyb1906443.entity.ClassEntity;
import com.duyb1906443.entity.ClassMemberEntity;
import com.duyb1906443.entity.TransactionEntity;
import com.duyb1906443.entity.UserEntity;
import com.duyb1906443.entity.id.ClassMemberId;
import com.duyb1906443.repository.ClassMemberRepository;
import com.duyb1906443.repository.ClassRepository;
import com.duyb1906443.repository.TransactionRepository;
import com.duyb1906443.repository.UserRepository;
import com.duyb1906443.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ClassRepository classRepository;

	@Autowired
	private ClassMemberRepository classMemberRepository;
	
	@Autowired
	private TransactionConverter transactionConverter;
	
	@Autowired
	private TransactionRepository transactionRepository;

	@Override
	public TransactionDTO save(TransactionDTO transactionDTO) {
		TransactionEntity transactionEntity = null;
		
		transactionEntity = transactionConverter.toEntity(transactionDTO);

		UserEntity userEntity = userRepository.findOne(transactionDTO.getUserId());
		ClassEntity classEntity = classRepository.findOne(transactionDTO.getClassId());
		System.out.println(userEntity.getUsername()+" : "+classEntity.getName());
		ClassMemberEntity classMemberEntity = classMemberRepository.findOneByClassEntityAndUser(classEntity, userEntity);
		
		ClassMemberId classMemberId = new ClassMemberId();
		classMemberId.setClassId(classEntity.getId());
		classMemberId.setUserId(userEntity.getId());
		classMemberEntity.setClassMemberId(classMemberId);
		transactionEntity.setClassMember(classMemberEntity);
		transactionEntity = transactionRepository.save(transactionEntity);
		
		System.out.println("transactionEntity "+transactionEntity.getCode());
		
		classMemberEntity.setTransaction(transactionEntity);
		classMemberEntity = classMemberRepository.save(classMemberEntity);
		System.out.println("-----entity "+transactionEntity);
		TransactionDTO dto = transactionConverter.toDTO(classMemberEntity.getTransaction());
		System.out.println("Middle "+dto.getCode());
		return dto;
	}

	@Override
	public List<TransactionDTO> findAllByUserId(Long userId) {

		UserEntity userEntity = userRepository.findOne(userId);
		List<ClassMemberEntity> classMemberEntity = classMemberRepository.findAllByUser(userEntity);

		List<TransactionEntity> transactionEntities = classMemberEntity.stream()
				.filter(item -> item.getTransaction() != null).map(item -> item.getTransaction())
				.collect(Collectors.toList());
		
		if(transactionEntities != null) {
			return transactionConverter.toDTOList(transactionEntities);
		}
		
		return null;
	}

	@Override
	public List<TransactionDTO> findAllByClassId(Long classId) {
		ClassEntity classEntity = classRepository.findOne(classId);
		List<ClassMemberEntity> classMemberEntity = classMemberRepository.findAllByClassEntity(classEntity);

		List<TransactionEntity> transactionEntities = classMemberEntity.stream()
				.filter(item -> item.getTransaction() != null).map(item -> item.getTransaction())
				.collect(Collectors.toList());
		
		if(transactionEntities != null) {
			return transactionConverter.toDTOList(transactionEntities);
		}
		
		return null;
	}

}
