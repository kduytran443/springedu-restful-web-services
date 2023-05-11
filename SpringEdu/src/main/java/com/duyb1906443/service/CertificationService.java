package com.duyb1906443.service;

import java.util.List;

import com.duyb1906443.dto.CertificationDTO;

public interface CertificationService {
	
	List<CertificationDTO> findAllByUsername(String username);
	List<CertificationDTO> findAllByClassId(Long classId);
	CertificationDTO findOneById(Long id);
	CertificationDTO save(CertificationDTO certificationDTO);
	CertificationDTO delete(Long id);
	
}
