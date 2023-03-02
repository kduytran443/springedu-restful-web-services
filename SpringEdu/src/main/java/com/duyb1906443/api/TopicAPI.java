package com.duyb1906443.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.duyb1906443.annotation.CrossOriginsList;
import com.duyb1906443.dto.TopicDTO;
import com.duyb1906443.service.TopicService;

@RestController
public class TopicAPI {
	
	@Autowired
	private TopicService topicService;
	
	/* Nho xoa public vi day la API cho Hoc Vien */
	@GetMapping("/public/api/topic/{classId}")
	@CrossOriginsList
	public ResponseEntity<List<TopicDTO>> getTopics(@PathVariable("classId") Long classId){
		List<TopicDTO> dtos = topicService.findAllByClassId(classId);
		if(dtos != null) {
			return ResponseEntity.status(200).body(dtos);
		}
		return ResponseEntity.status(500).body(dtos);
	}

}
