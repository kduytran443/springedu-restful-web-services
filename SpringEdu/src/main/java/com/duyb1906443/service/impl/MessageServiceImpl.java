package com.duyb1906443.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.duyb1906443.converter.MessageConverter;
import com.duyb1906443.dto.MessageDTO;
import com.duyb1906443.entity.ClassEntity;
import com.duyb1906443.entity.MessageEntity;
import com.duyb1906443.repository.ClassRepository;
import com.duyb1906443.repository.MessageRepository;
import com.duyb1906443.service.MessageService;

public class MessageServiceImpl implements MessageService {
	
	@Autowired
	private ClassRepository classRepository;
	
	@Autowired
	private MessageConverter messageConverter;
	
	@Autowired
	private MessageRepository messageRepository;
	
	@Override
	public List<MessageDTO> findAllByClassId(Long classId) {
		ClassEntity classEntity = classRepository.findOne(classId);
		
		List<MessageEntity> messageEntities = classEntity.getMessages();
		
		return messageConverter.toDTOList(messageEntities);
	}

	@Override
	public MessageDTO findOneById(Long id) {
		MessageEntity entity = messageRepository.findOne(id);
		return messageConverter.toDTO(entity);
	}

	@Override
	public MessageDTO save(MessageDTO messageDTO) {
		return null;
	}

	@Override
	public MessageDTO delete(Long id) {
		MessageEntity entity = messageRepository.findOne(id);
		
		entity.setStatus(0);
		entity = messageRepository.save(entity);
		return messageConverter.toDTO(entity);
	}

}
