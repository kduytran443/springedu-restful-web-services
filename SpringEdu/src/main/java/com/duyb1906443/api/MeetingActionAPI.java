package com.duyb1906443.api;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.duyb1906443.annotation.CrossOriginsList;
import com.duyb1906443.dto.MeetingActionDTO;
import com.duyb1906443.entity.CustomUserDetails;
import com.duyb1906443.service.MeetingActionService;

@RestController
public class MeetingActionAPI {

	@Autowired
	private MeetingActionService meetingActionService;

	@GetMapping("/api/meeting-action/{classId}")
	@CrossOriginsList
	public ResponseEntity<?> getAllByClassId(@PathVariable("classId") Long classId) {
		List<MeetingActionDTO> dtos = meetingActionService.getAllByClassId(classId);
		if (dtos != null) {
			return ResponseEntity.status(200).body(dtos);
		}
		return ResponseEntity.status(500).body(Collections.emptyList());
	}

	@GetMapping("/api/meeting-action/{classId}/{startTime}/{endTime}")
	@CrossOriginsList
	public ResponseEntity<?> getAllByClassIdAndRange(@PathVariable("classId") Long classId,
			@PathVariable("startTime") Long startTime, @PathVariable("endTime") Long endTime) {
		Timestamp start = new Timestamp(startTime);
		Timestamp end = new Timestamp(endTime);
		List<MeetingActionDTO> dtos = meetingActionService.getAllByClassIdAndRange(classId, start, end);
		if (dtos != null) {
			return ResponseEntity.status(200).body(dtos);
		}
		return ResponseEntity.status(500).body(Collections.emptyList());
	}

	@PostMapping("/api/meeting-action")
	@CrossOriginsList
	public ResponseEntity<?> getAllByClassIdAndRange(@RequestBody MeetingActionDTO meetingActionDTO) {
		Long userId = ((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal())
				.getUser().getId();
		meetingActionDTO.setUserId(userId);
		MeetingActionDTO dto = meetingActionService.save(meetingActionDTO);
		if (dto != null) {
			return ResponseEntity.status(200).body(dto);
		}
		return ResponseEntity.status(500).body(new Object());
	}

}
