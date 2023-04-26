package com.duyb1906443.service;

import java.util.List;

import com.duyb1906443.dto.CertificationDTO;

public interface CertificationService {
	
	List<CertificationDTO> findAllByUserId(Long userId);
	List<CertificationDTO> findAllByClassId(Long classId);
	CertificationDTO findOneById(Long id);
	CertificationDTO save(CertificationDTO certificationDTO);
	CertificationDTO delete(Long id);
	
}
