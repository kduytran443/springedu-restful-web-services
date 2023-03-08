package com.duyb1906443.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.duyb1906443.annotation.CrossOriginsList;
import com.duyb1906443.dto.MeetingDTO;
import com.duyb1906443.entity.CustomUserDetails;
import com.duyb1906443.security.token.JwtTokenProvider;
import com.duyb1906443.service.MeetingService;

@RestController
public class MeetingAPI {
	
	@Autowired
	private MeetingService meetingService;
	
    @Autowired
    private JwtTokenProvider tokenProvider;
	
	@GetMapping("/api/meeting")
	@CrossOriginsList
	public ResponseEntity<?> getMeeting(@RequestParam(name = "classId") Long classId) {
		Long userId = ((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser().getId();
		MeetingDTO meetingDTO = meetingService.findOneByClassId(classId, userId);
		
		if(meetingDTO != null) {
			return ResponseEntity.status(200).body(meetingDTO);
		}
		
		return ResponseEntity.notFound().build();
	}
	
}
