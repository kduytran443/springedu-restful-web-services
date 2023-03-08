package com.duyb1906443.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duyb1906443.converter.TextDataConverter;
import com.duyb1906443.dto.TextDataDTO;
import com.duyb1906443.entity.ClassEntity;
import com.duyb1906443.entity.ClassLessonEntity;
import com.duyb1906443.entity.TextDataEntity;
import com.duyb1906443.repository.ClassLessonRepository;
import com.duyb1906443.repository.ClassRepository;
import com.duyb1906443.repository.TextDataRepository;
import com.duyb1906443.service.TextDataService;

@Service
public class TextDataServiceImpl implements TextDataService {

	@Autowired
	private ClassRepository classRepository;

	@Autowired
	private ClassLessonRepository classLessonRepository;

	@Autowired
	private TextDataRepository textDataRepository;

	@Autowired
	private TextDataConverter textDataConverter;

	@Override
	public TextDataDTO findOneByClassLessonId(Long classLessonId) {
		ClassLessonEntity classLessonEntity = classLessonRepository.findOne(classLessonId);

		TextDataEntity textDataEntity = classLessonEntity.getTextData();

		return textDataConverter.toDTO(textDataEntity);
	}

	@Override
	public TextDataDTO findOneByClassId(Long classId) {
		ClassEntity classEntity = classRepository.findOne(classId);

		TextDataEntity textDataEntity = classEntity.getTextData();

		return textDataConverter.toDTO(textDataEntity);
	}

	@Override
	public TextDataDTO save(TextDataDTO textDataDTO) {

		if (textDataDTO.getId() != null) {
			TextDataEntity textDataEntity = textDataRepository.findOne(textDataDTO.getId());
			textDataEntity.setContent(textDataDTO.getContent());

			textDataEntity = textDataRepository.save(textDataEntity);

			return textDataConverter.toDTO(textDataEntity);
		}

		return null;
	}

	@Override
	public TextDataDTO saveOnClassLesson(TextDataDTO textDataDTO, Long classLessonId) {
		TextDataEntity textDataEntity = new TextDataEntity();
		if (textDataDTO.getId() != null) {
			textDataEntity = textDataRepository.findOne(textDataDTO.getId());
			textDataEntity.setContent(textDataDTO.getContent());
			textDataEntity = textDataRepository.save(textDataEntity);
			return textDataConverter.toDTO(textDataEntity);
		} else {
			textDataEntity = textDataConverter.toEntity(textDataDTO, textDataEntity);
			textDataEntity.setClassLesson(classLessonRepository.findOne(classLessonId));
			textDataEntity = textDataRepository.save(textDataEntity);
			return textDataConverter.toDTO(textDataEntity);
		}
	}

	@Override
	public TextDataDTO saveOnClass(TextDataDTO textDataDTO, Long classId) {
		TextDataEntity textDataEntity = new TextDataEntity();
		if (textDataDTO.getId() != null) {
			textDataEntity = textDataRepository.findOne(textDataDTO.getId());
			textDataEntity.setContent(textDataDTO.getContent());
			textDataEntity = textDataRepository.save(textDataEntity);
			return textDataConverter.toDTO(textDataEntity);
		} else {
			textDataEntity = textDataConverter.toEntity(textDataDTO, textDataEntity);
			textDataEntity.setClassEntity(classRepository.findOne(classId));
			textDataEntity = textDataRepository.save(textDataEntity);
			return textDataConverter.toDTO(textDataEntity);
		}
	}

}
