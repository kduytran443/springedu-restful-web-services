package com.duyb1906443.service.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duyb1906443.converter.TopicConverter;
import com.duyb1906443.dto.TopicDTO;
import com.duyb1906443.entity.ClassEntity;
import com.duyb1906443.entity.TopicEntity;
import com.duyb1906443.repository.ClassRepository;
import com.duyb1906443.repository.TopicRepository;
import com.duyb1906443.service.TopicService;

@Service
public class TopicServiceImpl implements TopicService {
	
	@Autowired
	private ClassRepository classRepository;
	
	@Autowired
	private TopicRepository topicRepository;
	
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

	@Override
	public TopicDTO save(TopicDTO topicDTO) {
		TopicEntity topicEntity = new TopicEntity();
		
		if(topicDTO.getId() != null) {
			TopicEntity oldTopicEntity = topicRepository.findOne(topicDTO.getId());
			topicEntity = topicConverter.toEntity(topicDTO, oldTopicEntity);
		}else {
			topicEntity = topicConverter.toEntity(topicDTO);
			topicEntity.setClassEntity(classRepository.findOne(topicDTO.getClassId()));
			
			List<TopicDTO> oldTopicDTOs = findAllByClassId(topicDTO.getClassId());
			
			int maxValue = 0;
			for (TopicDTO dto : oldTopicDTOs) {
				if(dto.getOrdinalNumber() > maxValue) {
					maxValue = dto.getOrdinalNumber();
				}
			}
			topicEntity.setOrdinalNumber(maxValue + 1);
		}
		
		topicEntity = topicRepository.save(topicEntity);
		
		return topicConverter.toDTO(topicEntity);
	}

}
