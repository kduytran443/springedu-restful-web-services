package com.duyb1906443.api;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.duyb1906443.annotation.CrossOriginsList;
import com.duyb1906443.dto.NotificationDTO;
import com.duyb1906443.entity.CustomUserDetails;
import com.duyb1906443.service.UserNotificationService;

@RestController
public class NotificationAPI {
	
	@Autowired
	private UserNotificationService userNotificationService;
	
	@GetMapping("/api/notification/user")
	@CrossOriginsList
	public ResponseEntity<List<NotificationDTO>> findAllByUser(){
		Long userId = ((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser().getId();
		List<NotificationDTO> dtos = userNotificationService.findAllByUserId(userId);
		if(dtos != null) {
			return ResponseEntity.status(200).body(dtos);
		}
		return ResponseEntity.status(500).body(Collections.emptyList());
	}
	
	@PostMapping("/api/notification")
	@CrossOriginsList
	public ResponseEntity<?> post(@RequestBody NotificationDTO notificationDTO){
		Long userId = ((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser().getId();
		notificationDTO.setSenderId(userId);
		userNotificationService.sendNotification(notificationDTO);
		return ResponseEntity.status(200).body(new NotificationDTO());
	}
	
	@PutMapping("/api/notification/read")
	@CrossOriginsList
	public ResponseEntity<?> readAll(){
		Long userId = ((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser().getId();
		userNotificationService.readAll(userId);
		return ResponseEntity.status(200).body(new NotificationDTO());
	}
	
}
