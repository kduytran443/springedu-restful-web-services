package com.duyb1906443.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.duyb1906443.annotation.CrossOriginsList;
import com.duyb1906443.dto.SocketMessageDTO;

@Controller
public class WebsocketController {
	
	@Autowired
	private SimpMessagingTemplate template;
	
	@MessageMapping("/register")
	@CrossOriginsList
	public void registerSocket(@Payload SocketMessageDTO messageDTO) throws Exception {
	}
	
	@MessageMapping("/notification.send")
	@CrossOriginsList
	public void orderProcess(@Payload SocketMessageDTO messageDTO) throws Exception {
		template.convertAndSend("/web-socket/notification", messageDTO);
	}
	
}
