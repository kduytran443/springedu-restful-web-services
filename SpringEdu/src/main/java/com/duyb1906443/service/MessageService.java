package com.duyb1906443.service;

import java.util.List;

import com.duyb1906443.dto.MessageDTO;

public interface MessageService {
	
	List<MessageDTO> findAllByClassId(Long classId);
	MessageDTO findOneById(Long id);
	MessageDTO save(MessageDTO messageDTO);
	MessageDTO delete(Long id);
	Integer getCountUnreadMessageByUserId();
	Integer getCountUnreadMessageByUserIdAndClassId(Long classId);
	
}
