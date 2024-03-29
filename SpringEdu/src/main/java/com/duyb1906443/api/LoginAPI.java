package com.duyb1906443.api;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duyb1906443.annotation.CrossOriginsList;
import com.duyb1906443.dto.LoginRequestDTO;
import com.duyb1906443.dto.UserDTO;
import com.duyb1906443.entity.CustomUserDetails;
import com.duyb1906443.mail.MailHolder;
import com.duyb1906443.mail.MailService;
import com.duyb1906443.security.token.JwtTokenProvider;
import com.duyb1906443.service.UserService;

@RestController
@RequestMapping
public class LoginAPI {
	
	@Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;
	
    @Autowired
    private UserService userService;
    
    @Autowired
    private MailService mailService;
	
	@PostMapping("/api/login")
	@CrossOriginsList
	public UserDTO login(@RequestBody LoginRequestDTO loginRequest) {
		// Xác thực từ username và password.
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );
        
        // Nếu không xảy ra exception tức là thông tin hợp lệ
        
        // Set thông tin authentication vào Security Context
        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        // Trả về jwt cho người dùng.
        String jwt = tokenProvider.generateToken((CustomUserDetails) authentication.getPrincipal());
        UserDTO userDTO = userService.findOneById(((CustomUserDetails) authentication.getPrincipal()).getUser().getId());
        userDTO.setJwt("Bearer "+jwt);
        return userDTO;
	}
	

	@GetMapping("/api/user")
	@CrossOriginsList
	public ResponseEntity<?> getUserFromJWT() {
		Long userId = ((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser().getId();
		UserDTO userDTO = userService.findOneById(userId);
		return ResponseEntity.status(200).body(userDTO);
	}
	
	@PostMapping("/api/sign-up")
	@CrossOriginsList
	public UserDTO signUp(@RequestBody UserDTO userDTO) {
		return userService.signUp(userDTO);
	}
	
	@PostMapping("/api/sign-up/admin")
	@CrossOriginsList
	public UserDTO signUpAdmin(@RequestBody UserDTO userDTO) {
		return userService.signUpAdmin(userDTO);
	}
	
	@PostMapping("/api/verify")
	@CrossOriginsList
	public UserDTO verifySignUp(@RequestBody UserDTO userDTO) {
		MailHolder holder = new MailHolder(userDTO);
		
		String subject = "Verify SpringEdu's Account";
		String content = "Key of your verify is: " + holder.getKey();
		
		mailService.sendMail(null, userDTO.getEmail(), subject, content);
		
		return userDTO;
	}

	@PostMapping("/api/logout")
	@CrossOriginsList
	public String logout() throws ServletException {
		SecurityContextHolder.clearContext();
		return new String("Logout successfully!");
	}
	
}
