package com.duyb1906443.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duyb1906443.converter.ClassMemberConverter;
import com.duyb1906443.dto.ClassMemberDTO;
import com.duyb1906443.entity.ClassEntity;
import com.duyb1906443.entity.ClassMemberEntity;
import com.duyb1906443.repository.ClassMemberRepository;
import com.duyb1906443.repository.ClassRepository;
import com.duyb1906443.service.ClassMemberService;

@Service
public class ClassMemberServiceImpl implements ClassMemberService {
	
	@Autowired
	private ClassMemberRepository classMemberRepository;
	
	@Autowired
	private ClassRepository classRepository;
	
	@Autowired
	private ClassMemberConverter classMemberConverter;
	
	@Override
	public List<ClassMemberDTO> findAllByClassId(Long classId) {
		ClassEntity classEntity = classRepository.findOne(classId);
		List<ClassMemberEntity> classMemberEntities = classMemberRepository.findAllByClassEntity(classEntity);
		
		return classMemberConverter.toDTOList(classMemberEntities);
	}

}
