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
import com.duyb1906443.dto.DiscountDTO;
import com.duyb1906443.service.DiscountService;

@RestController
public class DiscountAPI {
	
	@Autowired
	private DiscountService discountService;
	
	@GetMapping("/public/api/discount/class/{classId}")
	@CrossOriginsList
	public ResponseEntity<List<DiscountDTO>> getDiscountsByClass(@PathVariable("classId") Long classId){
		List<DiscountDTO> dtos = discountService.getAllByClassId(classId);
		if(dtos != null) {
			return ResponseEntity.status(200).body(dtos);
		}
		return ResponseEntity.status(500).body(Collections.emptyList());
	}
	
	@GetMapping("/api/discount/{id}")
	@CrossOriginsList
	public ResponseEntity<DiscountDTO> getDiscountById(@PathVariable("id") Long id){
		DiscountDTO dto = discountService.findOneById(id);
		if(dto != null) {
			return ResponseEntity.status(200).body(dto);
		}
		return ResponseEntity.status(500).body(new DiscountDTO());
	}
	
	@PostMapping("/api/discount")
	@CrossOriginsList
	public ResponseEntity<DiscountDTO> post(@RequestBody DiscountDTO discountDTO){
		discountDTO.setId(null);
		DiscountDTO dto = discountService.save(discountDTO);
		if(dto != null) {
			return ResponseEntity.status(200).body(dto);
		}
		return ResponseEntity.status(500).body(new DiscountDTO());
	}
	
	@PutMapping("/api/discount")
	@CrossOriginsList
	public ResponseEntity<DiscountDTO> put(@RequestBody DiscountDTO discountDTO){
		DiscountDTO dto = discountService.save(discountDTO);
		if(dto != null) {
			return ResponseEntity.status(200).body(dto);
		}
		return ResponseEntity.status(500).body(new DiscountDTO());
	}
	
	@DeleteMapping("/api/discount/{id}")
	@CrossOriginsList
	public ResponseEntity<DiscountDTO> delete(@PathVariable("id") Long id){
		discountService.delete(id);
		return ResponseEntity.status(200).body(new DiscountDTO());
	}
	
}
