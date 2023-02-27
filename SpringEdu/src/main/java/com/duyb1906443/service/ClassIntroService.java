package com.duyb1906443.service;

import com.duyb1906443.dto.ClassIntroDTO;

public interface ClassIntroService {
	
	ClassIntroDTO findOneByClassId(Long classId);
	
}
