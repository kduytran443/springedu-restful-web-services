package com.duyb1906443.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.duyb1906443.annotation.CrossOriginsList;
import com.duyb1906443.dto.UserDTO;
import com.duyb1906443.service.UserService;

@RestController
public class UserAPI {
	
    @Autowired
    private UserService userService;
	
	@GetMapping("/public/api/user/{username}")
	@CrossOriginsList
	public ResponseEntity<?> getUserByUsername(@PathVariable("username") String username) {
		UserDTO userDTO = userService.findOneByUsername(username);
		if(userDTO != null) {
			return ResponseEntity.status(200).body(userDTO);			
		}
		return ResponseEntity.status(500).body(new UserDTO());
	}

	@PutMapping("/api/user")
	@CrossOriginsList
	public ResponseEntity<?> putUser(@RequestBody UserDTO userDTO) {
		UserDTO dto = userService.save(userDTO);
		if(dto != null) {
			return ResponseEntity.status(200).body(dto);			
		}
		return ResponseEntity.status(500).body(new UserDTO());
	}
	
	@DeleteMapping("/api/user/{username}")
	@CrossOriginsList
	public ResponseEntity<?> deleteUser(@PathVariable("username") String username) {
		userService.delete(username);
		return ResponseEntity.status(200).body(new UserDTO());
	}
	
}
