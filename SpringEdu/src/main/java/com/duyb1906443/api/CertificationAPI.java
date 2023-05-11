package com.duyb1906443.api;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.duyb1906443.annotation.CrossOriginsList;
import com.duyb1906443.dto.CertificationDTO;
import com.duyb1906443.service.CertificationService;

@RestController
public class CertificationAPI {
	
	@Autowired
	private CertificationService certificationService;
	
	@GetMapping("/public/api/certification/user/{username}")
	@CrossOriginsList
	public ResponseEntity<List<CertificationDTO>> getAll(@PathVariable("username") String username) {

		List<CertificationDTO> dtos = certificationService.findAllByUsername(username);
		if (dtos != null) {
			return ResponseEntity.status(200).body(dtos);
		}

		return ResponseEntity.status(500).body(Collections.emptyList());
	}
	
	@GetMapping("/public/api/certification/class/{classId}")
	@CrossOriginsList
	public ResponseEntity<List<CertificationDTO>> getAllByClassId(@PathVariable("classId") Long classId) {

		List<CertificationDTO> dtos = certificationService.findAllByClassId(classId);
		if (dtos != null) {
			return ResponseEntity.status(200).body(dtos);
		}

		return ResponseEntity.status(500).body(Collections.emptyList());
	}
	
	@GetMapping("/public/api/certification/{id}")
	@CrossOriginsList
	public ResponseEntity<CertificationDTO> get(@PathVariable("id") Long id) {

		CertificationDTO dto = certificationService.findOneById(id);
		if (dto != null) {
			return ResponseEntity.status(200).body(dto);
		}

		return ResponseEntity.status(500).body(new CertificationDTO());
	}
	
	@PostMapping("/api/certification")
	@CrossOriginsList
	public ResponseEntity<CertificationDTO> post(@RequestBody CertificationDTO certificationDTO) {
		certificationDTO.setId(null);
		CertificationDTO dto = certificationService.save(certificationDTO);
		if (dto != null) {
			return ResponseEntity.status(200).body(dto);
		}
		return ResponseEntity.status(500).body(new CertificationDTO());
	}
	
	@PutMapping("/api/certification")
	@CrossOriginsList
	public ResponseEntity<CertificationDTO> put(@RequestBody CertificationDTO certificationDTO) {
		CertificationDTO dto = certificationService.save(certificationDTO);
		if (dto != null) {
			return ResponseEntity.status(200).body(dto);
		}
		return ResponseEntity.status(500).body(new CertificationDTO());
	}
	
	@DeleteMapping("/api/certification/{id}")
	@CrossOriginsList
	public ResponseEntity<CertificationDTO> delete(@PathVariable("id") Long id) {
		CertificationDTO dto = certificationService.delete(id);
		if (dto != null) {
			return ResponseEntity.status(200).body(dto);
		}
		return ResponseEntity.status(500).body(new CertificationDTO());
	}
	
}
