package com.duyb1906443.api;

import java.util.Collections;
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
	
	@GetMapping("/api/topic/class/{classId}")
	@CrossOriginsList
	public ResponseEntity<List<TopicDTO>> getTopicsByClass(@PathVariable("classId") Long classId){
		List<TopicDTO> dtos = topicService.findAllByClassId(classId);
		if(dtos != null) {
			return ResponseEntity.status(200).body(dtos);
		}
		return ResponseEntity.status(500).body(Collections.emptyList());
	}
	
	@GetMapping("/api/topic/{topicId}")
	@CrossOriginsList
	public ResponseEntity<TopicDTO> getTopicById(@PathVariable("topicId") Long topicId){
		TopicDTO dto = topicService.findOneById(topicId);
		if(dto != null) {
			return ResponseEntity.status(200).body(dto);
		}
		return ResponseEntity.status(500).body(new TopicDTO());
	}
	
	@PostMapping("/api/topic")
	@CrossOriginsList
	public ResponseEntity<TopicDTO> postTopic(@RequestBody TopicDTO topicDTO){
		topicDTO.setId(null);
		TopicDTO dto = topicService.save(topicDTO);
		if(dto != null) {
			return ResponseEntity.status(200).body(dto);
		}
		return ResponseEntity.status(500).body(new TopicDTO());
	}
	
	@PutMapping("/api/topic/visible")
	@CrossOriginsList
	public ResponseEntity<TopicDTO> putVisibleOrdinal(@RequestBody TopicDTO topicDTO){
		TopicDTO dto = topicService.changeVisible(topicDTO);
		if(dto != null) {
			return ResponseEntity.status(200).body(dto);
		}
		return ResponseEntity.status(500).body(new TopicDTO());
	}
	
	@PutMapping("/api/topic/ordinal")
	@CrossOriginsList
	public ResponseEntity<TopicDTO> putTopicOrdinal(@RequestBody TopicDTO topicDTO){
		TopicDTO dto = topicService.changeOrdinal(topicDTO);
		if(dto != null) {
			return ResponseEntity.status(200).body(dto);
		}
		return ResponseEntity.status(500).body(new TopicDTO());
	}
	
	@PutMapping("/api/topic")
	@CrossOriginsList
	public ResponseEntity<TopicDTO> putTopic(@RequestBody TopicDTO topicDTO){
		TopicDTO dto = topicService.save(topicDTO);
		if(dto != null) {
			return ResponseEntity.status(200).body(dto);
		}
		return ResponseEntity.status(500).body(new TopicDTO());
	}
	
	@DeleteMapping("/api/topic")
	@CrossOriginsList
	public ResponseEntity<TopicDTO> deleteTopic(@RequestBody TopicDTO topicDTO){
		topicService.delete(topicDTO);
		return ResponseEntity.status(200).body(new TopicDTO());
	}
	
}
