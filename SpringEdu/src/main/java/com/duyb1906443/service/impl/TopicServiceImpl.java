package com.duyb1906443.service.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.transaction.Transactional;

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
		TopicEntity topicEntity = null;
		
		if(topicDTO.getId() != null) {
			TopicEntity oldTopicEntity = topicRepository.findOne(topicDTO.getId());
			topicEntity = topicConverter.toEntity(topicDTO, oldTopicEntity);
		}else {
			topicEntity = topicConverter.toEntity(topicDTO);
			ClassEntity classEntity = classRepository.findOne(topicDTO.getClassId());
			topicEntity.setClassEntity(classEntity);
			
			List<TopicEntity> topicEntities = topicRepository.findAllByClassEntity(classEntity);
			
			int count = 1;
			for (TopicEntity entity : topicEntities) {
				entity.setOrdinalNumber(count++);
				topicRepository.save(entity);
			}
			topicEntity.setOrdinalNumber(count);
		}
		
		if(topicEntity != null) {
			topicEntity = topicRepository.save(topicEntity);
			return topicConverter.toDTO(topicEntity);			
		}
		
		return null;
	}

	@Override
	public void delete(TopicDTO topicDTO) {
		TopicEntity entity = topicRepository.findOne(topicDTO.getId());
		Long entityId = entity.getClassEntity().getId();
		topicRepository.delete(entity);

		ClassEntity classEntity = classRepository.findOne(entityId);

		resetOrdinalNumber(classEntity);
		
	}
	
	private void resetOrdinalNumber(ClassEntity classEntity) {
		List<TopicEntity> topicEntities = topicRepository.findAllByClassEntity(classEntity);
		int count = 1;
		for (TopicEntity topicEntity : topicEntities) {
			topicEntity.setOrdinalNumber(count++);
			topicRepository.save(topicEntity);
		}
	}

	@Override
	public TopicDTO findOneById(Long id) {
		TopicEntity topicEntity = topicRepository.findOne(id);
		if(topicEntity != null) {
			return topicConverter.toDTO(topicEntity);
		}
		return null;
	}

	@Override
	public TopicDTO changeOrdinal(TopicDTO topicDTO) {
		
		int ordinalNumberNeedToChange = topicDTO.getOrdinalNumber();
		TopicEntity topicEntity = topicRepository.findOne(topicDTO.getId());
		int oldOrdinalNumber = topicEntity.getOrdinalNumber();
		
		ClassEntity classEntity = classRepository.findOne(topicEntity.getClassEntity().getId());
		
		TopicEntity changedTopic = topicRepository.findOneByOrdinalNumberAndClassEntity(ordinalNumberNeedToChange, classEntity);
		
		changedTopic.setOrdinalNumber(oldOrdinalNumber);
		topicEntity.setOrdinalNumber(ordinalNumberNeedToChange);
		
		topicRepository.save(changedTopic);
		topicRepository.save(topicEntity);
		
		return topicConverter.toDTO(topicEntity);
	}

}
