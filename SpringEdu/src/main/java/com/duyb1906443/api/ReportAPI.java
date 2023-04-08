package com.duyb1906443.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.duyb1906443.annotation.CrossOriginsList;
import com.duyb1906443.dto.ReportDTO;
import com.duyb1906443.entity.CustomUserDetails;
import com.duyb1906443.service.ReportService;

@RestController
public class ReportAPI {

	@Autowired
	private ReportService reportService;

	@GetMapping("/api/report/all")
	@CrossOriginsList
	public ResponseEntity<List<ReportDTO>> getAll() {
		List<ReportDTO> dtos = reportService.findAll();
		if (dtos != null) {
			return ResponseEntity.status(200).body(dtos);
		}
		return ResponseEntity.status(500).body(dtos);
	}

	@GetMapping("/api/report/{reportId}")
	@CrossOriginsList
	public ResponseEntity<ReportDTO> getById(@PathVariable("reportId") Long reportId) {
		ReportDTO dto = reportService.findOneById(reportId);
		if (dto != null) {
			return ResponseEntity.status(200).body(dto);
		}
		return ResponseEntity.status(500).body(new ReportDTO());
	}

	@GetMapping("/api/report/class/{classId}")
	@CrossOriginsList
	public ResponseEntity<List<ReportDTO>> getByClassId(@PathVariable("classId") Long classId) {
		List<ReportDTO> dtos = reportService.findAllByClassId(classId);
		if (dtos != null) {
			return ResponseEntity.status(200).body(dtos);
		}
		return ResponseEntity.status(500).body(dtos);
	}

	@PostMapping("/api/report")
	@CrossOriginsList
	public ResponseEntity<ReportDTO> post(@RequestBody ReportDTO reportDTO) {
		Long userId = ((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal())
				.getUser().getId();
		reportDTO.setUserId(userId);
		ReportDTO dto = reportService.save(reportDTO);
		if (dto != null) {
			return ResponseEntity.status(200).body(dto);
		}
		return ResponseEntity.status(500).body(new ReportDTO());
	}

}
