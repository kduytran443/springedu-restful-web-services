package com.duyb1906443.api;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duyb1906443.dto.LoginRequestDTO;
import com.duyb1906443.dto.LoginResponseDTO;
import com.duyb1906443.dto.MessageDTO;
import com.duyb1906443.dto.UserDTO;
import com.duyb1906443.entity.CustomUserDetails;
import com.duyb1906443.mail.MailHolder;
import com.duyb1906443.mail.MailService;
import com.duyb1906443.security.token.JwtTokenProvider;
import com.duyb1906443.service.UserService;
import com.nimbusds.oauth2.sdk.http.HTTPRequest;

@RestController
@RequestMapping("/api")
public class LoginAPI {
	
	@Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;
	
    @Autowired
    private UserService userService;
    
    @Autowired
    private MailService mailService;
    
	@PostMapping("/login")
	public LoginResponseDTO login(@RequestBody LoginRequestDTO loginRequest) {
		System.out.println(loginRequest);
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
        return new LoginResponseDTO("Bearer "+jwt);
	}
	
	@GetMapping("/home")
	public MessageDTO test() {
		System.out.println("USERNAME: "+SecurityContextHolder.getContext().getAuthentication().getName());
		return new MessageDTO("SUCCESFULL");
	}
	
	@PostMapping("/logout")
	public MessageDTO logout() throws ServletException {
		SecurityContextHolder.clearContext();
		return new MessageDTO("Logout successfully!");
	}
	
	@PostMapping("/sign-up")
	public UserDTO signUp(@RequestBody UserDTO userDTO) {
		
		System.out.println(userDTO);
		return userService.signUp(userDTO);
	}
	
	@PostMapping("/verify")
	public UserDTO verifySignUp(@RequestBody UserDTO userDTO) {
		
		MailHolder holder = new MailHolder(userDTO);
		
		String subject = "Verify SpringEdu's Account";
		String content = "Key of your verify is: " + holder.getKey();
		
		mailService.sendMail(null, userDTO.getEmail(), subject, content);
		
		System.out.println(userDTO);
		return userDTO;
	}
	
}
