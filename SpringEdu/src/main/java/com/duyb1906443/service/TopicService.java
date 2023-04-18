package com.duyb1906443.service;

import java.util.List;

import com.duyb1906443.dto.TopicDTO;

public interface TopicService {
	
	List<TopicDTO> findAllByClassId(Long classId);
	
	TopicDTO save(TopicDTO topicDTO);
	TopicDTO findOneById(Long id);
	TopicDTO changeVisible(TopicDTO topicDTO);
	TopicDTO changeOrdinal(TopicDTO topicDTO);
	
	void delete(TopicDTO topicDTO);
	
}
