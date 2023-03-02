package com.duyb1906443.service.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duyb1906443.converter.TopicConverter;
import com.duyb1906443.dto.TopicDTO;
import com.duyb1906443.entity.ClassEntity;
import com.duyb1906443.repository.ClassRepository;
import com.duyb1906443.service.TopicService;

@Service
public class TopicServiceImpl implements TopicService {
	
	@Autowired
	private ClassRepository classRepository;
	
	@Autowired
	private TopicConverter topicConverter;

	@Override
	public List<TopicDTO> findAllByClassId(Long classId) {
		ClassEntity classEntity = classRepository.findOne(classId);
		
		List<TopicDTO> topicDTOs = topicConverter.toDTOList(classEntity.getTopics());
		
		Collections.sort(topicDTOs, new Comparator<TopicDTO>() {
			@Override
			public int compare(TopicDTO o1, TopicDTO o2) {
				if(o1.getOrdinalNumber() < o2.getOrdinalNumber()) {
					return -1;
				}
				else if(o1.getOrdinalNumber() > o2.getOrdinalNumber()) {
					return 1;
				}
				return 0;
			}
		});
		
		return topicDTOs;
	}

}
