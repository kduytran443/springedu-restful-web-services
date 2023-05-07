package com.duyb1906443.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duyb1906443.converter.ClassLessonConverter;
import com.duyb1906443.converter.FileConverter;
import com.duyb1906443.dto.ClassLessonDTO;
import com.duyb1906443.dto.FileDTO;
import com.duyb1906443.entity.ClassExcerciseEntity;
import com.duyb1906443.entity.ClassLessonEntity;
import com.duyb1906443.entity.FileEntity;
import com.duyb1906443.repository.ClassLessonRepository;
import com.duyb1906443.repository.FileRepository;
import com.duyb1906443.repository.TopicRepository;
import com.duyb1906443.service.ClassLessonService;

@Service
public class ClassLessonServiceImpl implements ClassLessonService {

	@Autowired
	private ClassLessonRepository classLessonRepository;

	@Autowired
	private TopicRepository topicRepository;

	@Autowired
	private ClassLessonConverter classLessonConverter;

	@Autowired
	private FileConverter fileConverter;
	
	@Autowired
	private FileRepository fileRepository;

	@Override
	public ClassLessonDTO findOne(Long id) {
		ClassLessonEntity classLessonEntity = classLessonRepository.findOne(id);
		ClassLessonDTO classLessonDTO = classLessonConverter.toDTO(classLessonEntity);
		return classLessonDTO;
	}

	@Override
	public ClassLessonDTO save(ClassLessonDTO classLessonDTO) {
		ClassLessonEntity classLessonEntity = new ClassLessonEntity();

		if (classLessonDTO.getId() != null) {
			ClassLessonEntity oldClassLessonEntity = classLessonRepository.findOne(classLessonDTO.getId());
			classLessonEntity = classLessonConverter.toEntity(classLessonDTO, oldClassLessonEntity);
		} else {
			classLessonEntity = classLessonConverter.toEntity(classLessonDTO);
			Date date = new Date();
			classLessonEntity.setCreatedDate(new Timestamp(date.getTime()));
			

			if(classLessonDTO.getFileIds() != null) {
				List<Long> fileIds = classLessonDTO.getFileIds();
				List<FileEntity> fileEntities = new ArrayList<>();
				for (Long fileId : fileIds) {
					FileEntity fileEntity = fileRepository.findOne(fileId);
					fileEntities.add(fileEntity);
				}
				classLessonEntity.setFiles(fileEntities);
			}
			
			
		}
		if(classLessonDTO.getTopicId() != null) {
			classLessonEntity.setTopic(topicRepository.findOne(classLessonDTO.getTopicId()));
		}
		classLessonEntity = classLessonRepository.save(classLessonEntity);

		return classLessonConverter.toDTO(classLessonEntity);
	}

	@Override
	public void delete(Long id) {
		classLessonRepository.delete(id);
	}

	@Override
	public FileDTO saveFile(Long id, FileDTO fileDTO) {
		ClassLessonEntity classLessonEntity = null; 
		
		if(id != 0) {
			classLessonEntity = classLessonRepository.findOne(id);			
		}
		
		List<FileEntity> fileEntities = null; 
		
		if(classLessonEntity != null) {
			classLessonEntity.getFiles();			
		}
		
		if(fileDTO.getId() == null) {
			
			if(fileEntities == null) {
				fileEntities = new ArrayList<>();
			}
			
			FileEntity fileEntity = fileConverter.toEntity(fileDTO);
			fileEntity = fileRepository.save(fileEntity);
			fileEntities.add(fileEntity);
			
			if(classLessonEntity != null) {
				classLessonEntity.setFiles(fileEntities);
				classLessonEntity = classLessonRepository.save(classLessonEntity);
			}
			
			return fileConverter.toDTO(fileEntity);
		}
		
		return null;
	}

	@Override
	public List<FileDTO> getFileList(Long id) {
		ClassLessonEntity classLessonEntity = classLessonRepository.findOne(id);
		List<FileEntity> fileEntities = classLessonEntity.getFiles().stream().map(item -> {
			item.setData("");
			return item;
		}).collect(Collectors.toList());
		
		if(fileEntities != null) {
			return fileConverter.toDTOList(fileEntities);
		}
		
		return null;
	}

	@Override
	public FileDTO delete(Long id, Long fileId) {
		FileEntity fileEntity = fileRepository.findOne(fileId);
		
		if(id != 0) {
			ClassLessonEntity classLessonEntity = classLessonRepository.findOne(id);
			List<FileEntity> fileEntities = classLessonEntity.getFiles().stream().filter(item -> item.getId() != fileId).map(item -> {
				item.setData("");
				return item;
			}).collect(Collectors.toList());
			
			classLessonEntity.setFiles(fileEntities);
			classLessonEntity = classLessonRepository.save(classLessonEntity);
		}
		
		fileRepository.delete(fileId);
		
		FileDTO fileDTO = new FileDTO();
		fileDTO.setId(fileEntity.getId());
		
		return fileDTO;
	}

}
