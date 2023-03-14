package com.duyb1906443.api;

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
import com.duyb1906443.dto.CategoryDTO;
import com.duyb1906443.service.CategoryService;

@RestController
public class CategoryAPI {

	@Autowired
	private CategoryService categoryService;

	@GetMapping("/public/api/category")
	@CrossOriginsList
	public ResponseEntity<List<CategoryDTO>> getCategories() {
		return ResponseEntity.status(200).body(categoryService.findAll());
	}

	@GetMapping("/public/api/category/{categoryCode}")
	@CrossOriginsList
	public ResponseEntity<CategoryDTO> getCategory(@PathVariable("categoryCode") String categoryCode) {
		return ResponseEntity.status(200).body(categoryService.findOneByCode(categoryCode));
	}

	@PostMapping("/api/category")
	@CrossOriginsList
	public ResponseEntity<?> postCategory(@RequestBody CategoryDTO categoryDTO) {
		categoryDTO.setId(null);
		CategoryDTO dto = categoryService.save(categoryDTO);

		if (dto != null) {
			return ResponseEntity.status(200).body(dto);
		}

		return ResponseEntity.status(500).build();
	}

	@PutMapping("/api/category")
	@CrossOriginsList
	public ResponseEntity<?> putCategory(@RequestBody CategoryDTO categoryDTO) {
		CategoryDTO dto = categoryService.save(categoryDTO);

		if (dto != null) {
			return ResponseEntity.status(200).body(dto);
		}

		return ResponseEntity.status(500).build();
	}

	@DeleteMapping("/api/category")
	@CrossOriginsList
	public ResponseEntity<?> deleteCategory(@RequestBody CategoryDTO categoryDTO) {
		categoryService.delete(categoryDTO.getId());
		return ResponseEntity.status(200).build();
	}

}
