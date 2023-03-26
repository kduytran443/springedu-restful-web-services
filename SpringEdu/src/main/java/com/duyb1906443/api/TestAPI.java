package com.duyb1906443.api;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duyb1906443.dto.MessageDTO;

@RestController
public class TestAPI {

	@PreAuthorize("@testAPISecurityService.isAllowed(#id)")
	@GetMapping("/api/testing/{id}")
	public MessageDTO getAPI(@PathVariable long id) {

		return new MessageDTO();
	}

	@PostMapping("/api/testing")
	public String postAPI() {
		return "success";
	}

}

@Service(value = "testAPISecurityService")
class TestAPISecurityService {
	public boolean isAllowed(long id) {
		System.out.println("ID cực mạnh: " + id);
		return id == 1;
	}
}
