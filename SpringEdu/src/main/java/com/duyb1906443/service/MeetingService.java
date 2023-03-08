package com.duyb1906443.service;


import com.duyb1906443.dto.MeetingDTO;

public interface MeetingService {
	
	MeetingDTO findOneByClassIdAndUserId(Long classId, Long userId);

	MeetingDTO findOneByClassId(Long classId, Long userId);
	MeetingDTO save(MeetingDTO meetingDTO);
}
