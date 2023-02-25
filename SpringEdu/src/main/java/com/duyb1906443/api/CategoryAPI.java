package com.duyb1906443.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duyb1906443.dto.CategoryDTO;
import com.duyb1906443.service.CategoryService;

@RestController
public class CategoryAPI {
	
	@Autowired
	private CategoryService categoryService;
	
	@CrossOrigin(origins = "*")
	@GetMapping("/public/api/category")
	public ResponseEntity<List<CategoryDTO>> getCategories(){
		return ResponseEntity.status(200).body(categoryService.findAll());
	}
	
}
