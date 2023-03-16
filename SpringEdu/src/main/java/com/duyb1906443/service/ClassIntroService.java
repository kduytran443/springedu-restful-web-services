package com.duyb1906443.service;

import com.duyb1906443.dto.ClassIntroDTO;

public interface ClassIntroService {
	
	ClassIntroDTO findOneByClassId(Long classId);
	ClassIntroDTO findOneByClassIdAndUserId(Long classId, Long userId);
	ClassIntroDTO changeDateOfClass(ClassIntroDTO classIntroDTO);
	ClassIntroDTO changeClassStatus(ClassIntroDTO classIntroDTO);
	ClassIntroDTO changeClassVisible(ClassIntroDTO classIntroDTO);
	
}
