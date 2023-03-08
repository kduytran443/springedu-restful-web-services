package com.duyb1906443.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.duyb1906443.annotation.CrossOriginsList;
import com.duyb1906443.dto.ClassDTO;
import com.duyb1906443.dto.ClassIntroDTO;
import com.duyb1906443.dto.ClassReviewCardDTO;
import com.duyb1906443.entity.CustomUserDetails;
import com.duyb1906443.service.ClassIntroService;
import com.duyb1906443.service.ClassReviewCardService;
import com.duyb1906443.service.ClassService;

@RestController
public class ClassAPI {

	@Autowired
	private ClassReviewCardService classReviewCardService;

	@Autowired
	private ClassIntroService classIntroService;

	@Autowired
	private ClassService classService;

	@GetMapping("/public/api/class-review")
	@CrossOriginsList
	public ResponseEntity<List<ClassReviewCardDTO>> getClassReviewCards() {
		return ResponseEntity.status(200).body(classReviewCardService.findAll());
	}

	@GetMapping("/public/api/class-review/{categoryCode}")
	@CrossOriginsList
	public ResponseEntity<List<ClassReviewCardDTO>> getClassReviewCards(
			@PathVariable("categoryCode") String categoryCode) {
		return ResponseEntity.status(200).body(classReviewCardService.findAllByCategoryCode(categoryCode));
	}

	@GetMapping("/public/api/class-intro/{classId}")
	@CrossOriginsList
	public ResponseEntity<ClassIntroDTO> getClassIntro(@PathVariable("classId") Long classId) {
		if (SecurityContextHolder.getContext().getAuthentication().isAuthenticated()
				&& !SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("anonymousUser")) {

			Long userId = ((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal())
					.getUser().getId();

			return ResponseEntity.status(200).body(classIntroService.findOneByClassIdAndUserId(classId, userId));
		}
		return ResponseEntity.status(200).body(classIntroService.findOneByClassId(classId));
	}

	@PostMapping("/api/class")
	@CrossOriginsList
	public ResponseEntity<?> postClass(@RequestBody ClassDTO classDTO) {
		Long userId = ((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal())
				.getUser().getId();
		classDTO.setId(null);
		classDTO.setCreatorId(userId);
		ClassDTO dto = classService.save(classDTO);

		if (dto != null) {
			return ResponseEntity.status(200).body(dto);
		}

		return ResponseEntity.status(500).build();
	}

}
