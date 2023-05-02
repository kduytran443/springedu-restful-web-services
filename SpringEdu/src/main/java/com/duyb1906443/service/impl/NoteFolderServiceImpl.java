package com.duyb1906443.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duyb1906443.converter.NoteFolderConverter;
import com.duyb1906443.dto.NoteFolderDTO;
import com.duyb1906443.entity.NoteFolderEntity;
import com.duyb1906443.entity.UserEntity;
import com.duyb1906443.repository.NoteFolderRepository;
import com.duyb1906443.repository.UserRepository;
import com.duyb1906443.service.NoteFolderService;

@Service
public class NoteFolderServiceImpl implements NoteFolderService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private NoteFolderConverter noteFolderConverter;
	
	@Autowired
	private NoteFolderRepository noteFolderRepository;
	
	@Override
	public List<NoteFolderDTO> findAllByUserId(Long userId) {
		UserEntity userEntity = userRepository.findOne(userId);
		List<NoteFolderEntity> noteFolderEntities = userEntity.getNoteFolders().stream().filter(item -> item.getStatus() == 1).collect(Collectors.toList());
		if(noteFolderEntities != null) {
			return noteFolderConverter.toDTOList(noteFolderEntities);
		}
		return null;
	}

	@Override
	public NoteFolderDTO findOneById(Long id) {
		NoteFolderEntity noteFolderEntity = noteFolderRepository.findOne(id);
		if(noteFolderEntity != null && noteFolderEntity.getStatus() == 1) {
			return noteFolderConverter.toDTO(noteFolderEntity);
		}
		return null;
	}

	@Override
	public NoteFolderDTO save(NoteFolderDTO noteFolderDTO) {
		NoteFolderEntity noteFolderEntity = null;
		
		if(noteFolderDTO.getId() != null) { //edit
			noteFolderEntity = noteFolderRepository.findOne(noteFolderDTO.getId());
			noteFolderEntity = noteFolderConverter.toEntity(noteFolderDTO, noteFolderEntity);
		}
		else {
			noteFolderEntity = noteFolderConverter.toEntity(noteFolderDTO);
			Date date = new Date();
			noteFolderEntity.setCreatedDate(new Timestamp(date.getTime()));
			UserEntity userEntity = userRepository.findOne(noteFolderDTO.getUserId());
			noteFolderEntity.setStatus(1);
			noteFolderEntity.setUser(userEntity);
		}
		
		if(noteFolderEntity != null) {
			noteFolderEntity = noteFolderRepository.save(noteFolderEntity);
			return noteFolderConverter.toDTO(noteFolderEntity);
		}
		
		return null;
	}

	@Override
	public NoteFolderDTO delete(Long id) {
		NoteFolderEntity noteFolderEntity = noteFolderRepository.findOne(id);
		if(noteFolderEntity != null && noteFolderEntity.getStatus() == 1) {
			noteFolderEntity.setStatus(0);
			noteFolderEntity = noteFolderRepository.save(noteFolderEntity);
			return noteFolderConverter.toDTO(noteFolderEntity);
		}
		return null;
	}

}
