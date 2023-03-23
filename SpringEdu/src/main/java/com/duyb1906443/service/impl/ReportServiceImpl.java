package com.duyb1906443.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duyb1906443.converter.ReportConverter;
import com.duyb1906443.dto.ReportDTO;
import com.duyb1906443.entity.ClassEntity;
import com.duyb1906443.entity.ReportEntity;
import com.duyb1906443.entity.UserEntity;
import com.duyb1906443.repository.ClassRepository;
import com.duyb1906443.repository.ReportRepository;
import com.duyb1906443.repository.UserRepository;
import com.duyb1906443.service.ReportService;

@Service
public class ReportServiceImpl implements ReportService {

	@Autowired
	private ReportRepository reportRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ClassRepository classRepository;

	@Autowired
	private ReportConverter reportConverter;

	@Override
	public List<ReportDTO> findAll() {
		List<ReportEntity> reportEntities = reportRepository.findAll();
		if (reportEntities != null) {
			return reportConverter.toDTOList(reportEntities);
		}
		return null;
	}

	@Override
	public List<ReportDTO> findAllByClassId(Long classId) {
		ClassEntity classEntity = classRepository.findOne(classId);
		List<ReportEntity> reportEntities = classEntity.getReports();
		if (reportEntities != null) {
			return reportConverter.toDTOList(reportEntities);
		}
		return null;
	}

	@Override
	public ReportDTO findOneById(Long id) {

		ReportEntity reportEntity = reportRepository.findOne(id);

		if (reportEntity != null) {
			return reportConverter.toDTO(reportEntity);
		}

		return null;
	}

	@Override
	public ReportDTO save(ReportDTO reportDTO) {

		ReportEntity reportEntity = reportConverter.toEntity(reportDTO);

		ClassEntity classEntity = classRepository.findOne(reportDTO.getClassId());

		reportEntity.setClassEntity(classEntity);

		UserEntity userEntity = userRepository.findOne(reportDTO.getUserId());
		reportEntity.setUser(userEntity);

		Date date = new Date();
		reportEntity.setCreatedDate(new Timestamp(date.getTime()));

		reportEntity = reportRepository.save(reportEntity);

		return reportConverter.toDTO(reportEntity);
	}

	@Override
	public void delete(ReportDTO reportDTO) {

	}

}
