package com.duyb1906443.service;


public interface ReadMessageService {
	
	Integer getCountUnreadMessageByUserId(Long userId);
	void readAllByClassId();
	
}
