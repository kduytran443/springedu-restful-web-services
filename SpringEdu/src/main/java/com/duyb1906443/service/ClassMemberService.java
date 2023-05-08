package com.duyb1906443.service;

import java.util.List;

import com.duyb1906443.dto.ClassMemberDTO;

public interface ClassMemberService {
	
	List<ClassMemberDTO> findAllByClassId(Long classId);
	List<ClassMemberDTO> findAllRequestMemberByClassId(Long classId);
	List<ClassMemberDTO> findAllInvitedMemberByClassId(Long classId);
	List<ClassMemberDTO> findAllByUserId(Long userId);
	List<ClassMemberDTO> findAllByUsername(String username);
	List<ClassMemberDTO> findAllRequestMemberByUsername(String username);
	List<ClassMemberDTO> findAllInvitedMemberByUsername(String username);
	ClassMemberDTO findOneByUserAndClass(Long userId, Long classId);
	ClassMemberDTO save(ClassMemberDTO classMemberDTO);
	void delete(ClassMemberDTO classMemberDTO);
	ClassMemberDTO acceptRequest(ClassMemberDTO classMemberDTO);
	ClassMemberDTO deleteCertification(ClassMemberDTO classMemberDTO);
	Integer countAllMember(Long classId);
	
}
