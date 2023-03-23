package com.duyb1906443.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.duyb1906443.converter.UserConverter;
import com.duyb1906443.dto.UserDTO;
import com.duyb1906443.entity.CustomUserDetails;
import com.duyb1906443.entity.RoleEntity;
import com.duyb1906443.entity.UserEntity;
import com.duyb1906443.repository.RoleRepository;
import com.duyb1906443.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UserConverter userConverter;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) {
		// Kiểm tra xem user có tồn tại trong database không?
		UserEntity user = userRepository.findOneByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException(username);
		}
		return new CustomUserDetails(user);
	}

	public UserDetails loadUserById(Long Id) {
		// Kiểm tra xem user có tồn tại trong database không?
		UserEntity user = userRepository.findOne(Id);
		if (user == null) {
			throw new UsernameNotFoundException("UserId: " + Id);
		}
		return new CustomUserDetails(user);
	}

	public UserDTO signUp(UserDTO userDTO) {

		//checkEmailExisted
		UserEntity userCheckEntity = userRepository.findOneByEmail(userDTO.getEmail());
		if(userCheckEntity != null) {
			throw new RuntimeException("Email đã tồn tại");
		}
		userCheckEntity = userRepository.findOneByUsername(userDTO.getUsername());
		if(userCheckEntity != null) {
			throw new RuntimeException("Username đã tồn tại");
		}
		
		UserEntity userEntity = userConverter.toEntity(userDTO);
		String encodedPassword = passwordEncoder.encode(userDTO.getPassword());
		userEntity.setPassword(encodedPassword);
		

		// Adding USER role code for register
		List<RoleEntity> roles = new ArrayList<RoleEntity>();
		roles.add(roleRepository.findOneByCode("USER"));
		userEntity.setStatus(1);
		userEntity.setRoles(roles);

		// Make sure id of new user is empty
		userEntity.setId(null);

		return userConverter.toDTO(userRepository.save(userEntity));
	}

	public boolean checkEmailsExisted(String email) {
		UserEntity userEntity = userRepository.findOneByEmail(email);
		if (userEntity != null) {
			return true;
		}
		return false;
	}

	public UserDTO findOneById(Long id) {
		UserEntity userEntity = userRepository.findOne(id);
		if (userEntity.getStatus() == 0) {
			return null;
		}
		return userConverter.toDTO(userRepository.findOne(id));
	}

	public UserDTO findOneByUsername(String username) {
		return userConverter.toDTO(userRepository.findOneByUsername(username));
	}

	public UserDTO save(UserDTO userDTO) {
		Long userId = ((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal())
				.getUser().getId();
		UserEntity userEntity = userRepository.findOne(userId);
		if (userDTO.getAvatar() != null)
			userEntity.setAvatar(userDTO.getAvatar());
		if (userDTO.getBirthYear() != null)
			userEntity.setBirthYear(userDTO.getBirthYear());
		if (userDTO.getFullname() != null)
			userEntity.setFullname(userDTO.getFullname());
		if (userDTO.getGender() != null)
			userEntity.setGender(userDTO.getGender());
		if (userDTO.getPhoneNumber() != null)
			userEntity.setPhoneNumber(userDTO.getPhoneNumber());

		userEntity = userRepository.save(userEntity);

		return userConverter.toDTO(userEntity);
	}

	public void delete(String username) {
		UserEntity userEntity = userRepository.findOneByUsername(username);
		userEntity.setStatus(0);
		userEntity = userRepository.save(userEntity);
	}

	public void updateAvatar(String avatar) {
		Long userId = ((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal())
				.getUser().getId();
		UserEntity userEntity = userRepository.findOne(userId);
		userEntity.setAvatar(avatar);
		System.out.println(avatar);
		userRepository.save(userEntity);
	}

}
