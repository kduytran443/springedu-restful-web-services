package com.duyb1906443.service;

import java.util.List;

import com.duyb1906443.dto.ClassMemberDTO;

public interface ClassMemberService {
	
	List<ClassMemberDTO> findAllByClassId(Long classId);
	
}
