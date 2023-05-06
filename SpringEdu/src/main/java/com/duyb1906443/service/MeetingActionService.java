package com.duyb1906443.service;

import java.sql.Timestamp;
import java.util.List;

import com.duyb1906443.dto.MeetingActionDTO;

public interface MeetingActionService {
	List<MeetingActionDTO> getAllByClassId(Long classId);
	List<MeetingActionDTO> getAllByClassIdAndRange(Long classId, Timestamp startTime, Timestamp endTime);
	MeetingActionDTO save(MeetingActionDTO meetingActionDTO);
	MeetingActionDTO delete(Long id);
}
