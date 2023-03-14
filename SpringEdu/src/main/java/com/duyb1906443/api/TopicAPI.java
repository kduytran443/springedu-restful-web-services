package com.duyb1906443.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.duyb1906443.annotation.CrossOriginsList;
import com.duyb1906443.dto.TopicDTO;
import com.duyb1906443.service.TopicService;

@RestController
public class TopicAPI {
	
	@Autowired
	private TopicService topicService;
	
	@GetMapping("/api/topic/{classId}")
	@CrossOriginsList
	public ResponseEntity<List<TopicDTO>> getTopics(@PathVariable("classId") Long classId){
		List<TopicDTO> dtos = topicService.findAllByClassId(classId);
		if(dtos != null) {
			return ResponseEntity.status(200).body(dtos);
		}
		return ResponseEntity.status(500).body(dtos);
	}
	
	@PostMapping("/api/topic")
	@CrossOriginsList
	public ResponseEntity<TopicDTO> postTopic(@RequestBody TopicDTO topicDTO){
		topicDTO.setId(null);
		TopicDTO dto = topicService.save(topicDTO);
		if(dto != null) {
			return ResponseEntity.status(200).body(dto);
		}
		return ResponseEntity.status(500).body(dto);
	}
	
	@PutMapping("/api/topic")
	@CrossOriginsList
	public ResponseEntity<TopicDTO> putTopic(@RequestBody TopicDTO topicDTO){
		TopicDTO dto = topicService.save(topicDTO);
		if(dto != null) {
			return ResponseEntity.status(200).body(dto);
		}
		return ResponseEntity.status(500).body(dto);
	}
	
	@DeleteMapping("/api/topic")
	@CrossOriginsList
	public ResponseEntity<TopicDTO> deleteTopic(@RequestBody TopicDTO topicDTO){
		System.out.println("topicDTO "+topicDTO);
		topicService.delete(topicDTO);
		return ResponseEntity.status(200).body(new TopicDTO());
	}
	
}
