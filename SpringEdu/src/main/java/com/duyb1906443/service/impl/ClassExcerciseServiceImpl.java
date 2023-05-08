package com.duyb1906443.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duyb1906443.converter.ClassExcerciseConverter;
import com.duyb1906443.converter.FileConverter;
import com.duyb1906443.dto.ClassExcerciseDTO;
import com.duyb1906443.dto.FileDTO;
import com.duyb1906443.entity.ClassEntity;
import com.duyb1906443.entity.ClassExcerciseEntity;
import com.duyb1906443.entity.ClassMemberEntity;
import com.duyb1906443.entity.FileEntity;
import com.duyb1906443.entity.QuestionBankEntity;
import com.duyb1906443.entity.SubmittedExerciseEntity;
import com.duyb1906443.entity.UserEntity;
import com.duyb1906443.repository.ClassExcerciseRepository;
import com.duyb1906443.repository.ClassMemberRepository;
import com.duyb1906443.repository.ClassRepository;
import com.duyb1906443.repository.FileRepository;
import com.duyb1906443.repository.QuestionBankRepository;
import com.duyb1906443.repository.UserRepository;
import com.duyb1906443.service.ClassExcerciseService;

@Service
public class ClassExcerciseServiceImpl implements ClassExcerciseService {

	@Autowired
	private ClassExcerciseRepository classExcerciseRepository;

	@Autowired
	private ClassRepository classRepository;

	@Autowired
	private ClassExcerciseConverter classExcerciseConverter;

	@Autowired
	private QuestionBankRepository questionBankRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ClassMemberRepository classMemberRepository;

	@Autowired
	private FileConverter fileConverter;
	
	@Autowired
	private FileRepository fileRepository;
	
	@Override
	public List<ClassExcerciseDTO> findAllByClassId(Long classId) {
		ClassEntity classEntity = classRepository.findOne(classId);

		List<ClassExcerciseEntity> classExcerciseEntities = classExcerciseRepository
				.findByClassEntityOrderByIdDesc(classEntity).stream()
				.filter(classExcercise -> classExcercise.getStatus() == 1).collect(Collectors.toList());

		/*
		 * classExcerciseEntities = classExcerciseEntities.stream()
		 * .filter(classExcercise -> classExcercise.getStatus() == 1)
		 * .collect(Collectors.toList());
		 */

		return classExcerciseConverter.toDTOList(classExcerciseEntities);
	}

	@Override
	public ClassExcerciseDTO findOneById(Long id) {

		ClassExcerciseEntity classExcerciseEntity = classExcerciseRepository.findOne(id);

		if (classExcerciseEntity.getStatus() == 1) {
			ClassExcerciseDTO classExcerciseDTO = classExcerciseConverter.toDTO(classExcerciseEntity);
			return classExcerciseDTO;
		}

		return null;
	}

	@Override
	public ClassExcerciseDTO save(ClassExcerciseDTO classExcerciseDTO) {
		ClassExcerciseEntity classExcerciseEntity = null;

		if (classExcerciseDTO.getId() != null) {
			classExcerciseEntity = classExcerciseRepository.findOne(classExcerciseDTO.getId());
			classExcerciseEntity = classExcerciseConverter.toEntity(classExcerciseDTO, classExcerciseEntity);
		} else {
			classExcerciseEntity = classExcerciseConverter.toEntity(classExcerciseDTO);

			ClassEntity classEntity = classRepository.findOne(classExcerciseDTO.getClassId());
			classExcerciseEntity.setClassEntity(classEntity);

			Date date = new Date();
			classExcerciseEntity.setCreatedTime(new Timestamp(date.getTime()));
			classExcerciseEntity.setStatus(1);
			if (classExcerciseDTO.getQuestionBankId() != null) {
				QuestionBankEntity questionBankEntity = questionBankRepository
						.findOne(classExcerciseDTO.getQuestionBankId());
				classExcerciseEntity.setQuestionBank(questionBankEntity);
			}
			
			if(classExcerciseDTO.getFileIds() != null) {
				List<Long> fileIds = classExcerciseDTO.getFileIds();
				List<FileEntity> fileEntities = new ArrayList<>();
				for (Long fileId : fileIds) {
					FileEntity fileEntity = fileRepository.findOne(fileId);
					fileEntities.add(fileEntity);
				}
				classExcerciseEntity.setFiles(fileEntities);
			}
			
		}

		if (classExcerciseEntity != null) {
			classExcerciseEntity = classExcerciseRepository.save(classExcerciseEntity);
			return classExcerciseConverter.toDTO(classExcerciseEntity);
		}

		return null;
	}

	@Override
	public void delete(ClassExcerciseDTO classExcerciseDTO) {
		ClassExcerciseEntity classExcerciseEntity = classExcerciseRepository.findOne(classExcerciseDTO.getId());
		classExcerciseEntity.setStatus(0);
		classExcerciseRepository.save(classExcerciseEntity);
	}

	@Override
	public List<ClassExcerciseDTO> findAllByUser(Long userId) {
		UserEntity userEntity = userRepository.findOne(userId);
		List<ClassMemberEntity> classMemberEntities = classMemberRepository.findAllByUser(userEntity);

		List<ClassExcerciseDTO> classExcerciseDTOs = new ArrayList<>();
		for (ClassMemberEntity classMemberEntity : classMemberEntities) {
			ClassEntity classEntity = classMemberEntity.getClassEntity();
			List<ClassExcerciseEntity> entities = classEntity.getClassExcercises();
			for (ClassExcerciseEntity entity : entities) {
				ClassExcerciseDTO dto = classExcerciseConverter.toDTO(entity);
				dto.setRole(classMemberEntity.getClassRole().getCode());
				classExcerciseDTOs.add(dto);
			}
		}

		Collections.sort(classExcerciseDTOs, new Comparator<ClassExcerciseDTO>() {
			@Override
			public int compare(ClassExcerciseDTO o1, ClassExcerciseDTO o2) {
				if (o1.getId() < o2.getId()) {
					return 1;
				} else if (o1.getId() > o2.getId()) {
					return -1;
				}
				return 0;
			}
		});

		return classExcerciseDTOs;
	}

	@Override
	public FileDTO saveFile(Long id, FileDTO fileDTO) {
		ClassExcerciseEntity classExcerciseEntity = null; 
		
		if(id != 0) {
			classExcerciseEntity = classExcerciseRepository.findOne(id);			
		}
		
		List<FileEntity> fileEntities = null; 
		
		if(classExcerciseEntity != null) {
			fileEntities = classExcerciseEntity.getFiles();			
		}
		
		if(fileDTO.getId() == null) {
			
			if(fileEntities == null) {
				fileEntities = new ArrayList<>();
			}
			
			FileEntity fileEntity = fileConverter.toEntity(fileDTO);
			fileEntity = fileRepository.save(fileEntity);
			fileEntities.add(fileEntity);
			
			if(classExcerciseEntity != null) {
				classExcerciseEntity.setFiles(fileEntities);
				classExcerciseEntity = classExcerciseRepository.save(classExcerciseEntity);
			}
			
			return fileConverter.toDTO(fileEntity);
		}
		
		return null;
	}

	@Override
	public List<FileDTO> getFileList(Long id) {
		ClassExcerciseEntity classExcerciseEntity = classExcerciseRepository.findOne(id);
		List<FileEntity> fileEntities = classExcerciseEntity.getFiles().stream().map(item -> {
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
			ClassExcerciseEntity classExcerciseEntity = classExcerciseRepository.findOne(id);
			List<FileEntity> fileEntities = classExcerciseEntity.getFiles().stream().filter(item -> item.getId() != fileId).map(item -> {
				item.setData("");
				return item;
			}).collect(Collectors.toList());
			
			classExcerciseEntity.setFiles(fileEntities);
			classExcerciseEntity = classExcerciseRepository.save(classExcerciseEntity);
		}
		
		fileRepository.delete(fileId);
		
		FileDTO fileDTO = new FileDTO();
		fileDTO.setId(fileEntity.getId());
		
		return fileDTO;
	}

}
