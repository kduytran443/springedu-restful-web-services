package com.duyb1906443.api;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.duyb1906443.annotation.CrossOriginsList;
import com.duyb1906443.dto.MessageDTO;
import com.duyb1906443.service.MessageService;

@RestController
public class MessageAPI {
	
	@Autowired
	private MessageService messageService;
	
	@GetMapping("/api/message/class/{classId}")
	@CrossOriginsList
	public ResponseEntity<?> getMessagesByClassId(@PathVariable("classId") Long classId) {
		List<MessageDTO> dtos = messageService.findAllByClassId(classId);

		if (dtos != null) {
			return ResponseEntity.status(200).body(dtos);
		}
		return ResponseEntity.status(500).body(Collections.emptyList());
	}
	
	@GetMapping("/api/message/{messageId}")
	@CrossOriginsList
	public ResponseEntity<?> getMessagesByMessageId(@PathVariable("messageId") Long messageId) {
		MessageDTO dto = messageService.findOneById(messageId);

		if (dto != null) {
			return ResponseEntity.status(200).body(dto);
		}
		return ResponseEntity.status(500).body(new Object());
	}
	
	@PostMapping("/api/message")
	@CrossOriginsList
	public ResponseEntity<?> post(@RequestBody MessageDTO messageDTO) {
		MessageDTO dto = messageService.save(messageDTO);
		if (dto != null) {
			return ResponseEntity.status(200).body(dto);
		}
		return ResponseEntity.status(500).body(new Object());
	}
	
	@DeleteMapping("/api/message/{messageId}")
	@CrossOriginsList
	public ResponseEntity<?> delete(@PathVariable("messageId") Long messageId) {
		MessageDTO dto = messageService.delete(messageId);
		if (dto != null) {
			return ResponseEntity.status(200).body(dto);
		}
		return ResponseEntity.status(500).body(new Object());
	}
	
}
