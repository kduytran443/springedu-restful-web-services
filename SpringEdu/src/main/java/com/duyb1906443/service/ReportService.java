package com.duyb1906443.service;

import java.util.List;

import com.duyb1906443.dto.ReportDTO;

public interface ReportService {

	List<ReportDTO> findAll();

	List<ReportDTO> findAllByClassId(Long classId);

	ReportDTO findOneById(Long id);

	ReportDTO save(ReportDTO reportDTO);

	void delete(ReportDTO reportDTO);

}
