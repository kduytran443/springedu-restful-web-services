package com.duyb1906443.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duyb1906443.converter.FileConverter;
import com.duyb1906443.dto.FileDTO;
import com.duyb1906443.entity.ClassLessonEntity;
import com.duyb1906443.entity.FileEntity;
import com.duyb1906443.repository.ClassLessonRepository;
import com.duyb1906443.repository.FileRepository;
import com.duyb1906443.service.FileService;

@Service
public class FileServiceImpl implements FileService {

	@Autowired
	private ClassLessonRepository classLessonRepository;
	
	@Autowired
	private FileRepository fileRepository;

	@Autowired
	private FileConverter fileConverter;

	@Override
	public List<FileDTO> findAllByClassLessonId(Long classLessonId) {
		ClassLessonEntity classLessonEntity = classLessonRepository.findOne(classLessonId);
		System.out.println("classLessonEntity "+classLessonEntity.getName());
		List<FileEntity> fileEntities = classLessonEntity.getFiles();
		System.out.println("file length: "+fileEntities.size());
		return fileConverter.toDTOList(fileEntities);
	}

	@Override
	public void uploadFileOnClassLesson(FileDTO fileDTO, Long classId) {
		ClassLessonEntity classLessonEntity = classLessonRepository.findOne(classId);
		FileEntity fileEntity = fileConverter.toEntity(fileDTO);
		fileDTO.setId(null);
		fileEntity = fileRepository.save(fileEntity);
		
		System.out.println("classLessonId "+classId);
		
		List<FileEntity> files = classLessonEntity.getFiles();
		
		System.out.println("files "+files.size());
		files.add(fileEntity);
		classLessonEntity.setFiles(files);
		
		classLessonRepository.save(classLessonEntity);
	}
	
}
