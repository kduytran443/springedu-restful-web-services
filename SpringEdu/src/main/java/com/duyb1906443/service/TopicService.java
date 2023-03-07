package com.duyb1906443.service;

import java.util.List;

import com.duyb1906443.dto.TopicDTO;

public interface TopicService {
	
	List<TopicDTO> findAllByClassId(Long classId);
	
	TopicDTO save(TopicDTO topicDTO);
	
}
