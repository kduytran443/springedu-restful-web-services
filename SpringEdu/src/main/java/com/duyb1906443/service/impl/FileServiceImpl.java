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
		List<FileEntity> fileEntities = classLessonEntity.getFiles();
		return fileConverter.toDTOList(fileEntities);
	}

	@Override
	public void uploadFileOnClassLesson(FileDTO fileDTO, Long classId) {
		ClassLessonEntity classLessonEntity = classLessonRepository.findOne(classId);
		FileEntity fileEntity = fileConverter.toEntity(fileDTO);
		fileDTO.setId(null);
		fileEntity = fileRepository.save(fileEntity);

		List<FileEntity> files = classLessonEntity.getFiles();

		files.add(fileEntity);
		classLessonEntity.setFiles(files);

		classLessonRepository.save(classLessonEntity);
	}

	@Override
	public FileDTO getById(Long id) {
		FileEntity fileEntity = fileRepository.findOne(id);
		if(fileEntity != null) {
				
			return fileConverter.toDTO(fileEntity);
		}
		return null;
	}

}
