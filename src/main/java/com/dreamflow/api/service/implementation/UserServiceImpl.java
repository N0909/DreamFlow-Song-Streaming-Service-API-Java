package com.dreamflow.api.service.implementation;

import java.time.LocalDateTime;

import org.springframework.context.annotation.Primary;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.dreamflow.api.auth.SignUpDTO;
import com.dreamflow.api.dto.UserDTO;
import com.dreamflow.api.entity.User;
import org.springframework.stereotype.*;

import com.dreamflow.api.exception.GeneralException;
import com.dreamflow.api.exception.ResourceNotFoundException;
import com.dreamflow.api.exception.UserEmailAlreadyExistsException;
import com.dreamflow.api.exception.UserNameAlreadyExistsException;
import com.dreamflow.api.repository.UserRepository;
import com.dreamflow.api.service.UserService;

import jakarta.transaction.Transactional;

@Primary
@Component
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public UserDTO getUser(String username) {
		User user = userRepository.findByUserName(username)
				.orElseThrow(() -> new ResourceNotFoundException("User with username: " + username + " Not Found"));
		UserDTO userDTO = new UserDTO(user.getUserId(), user.getUserName(), user.getEmail(), user.getCreatedAt());
		return userDTO;
	}

	@Override
	@Transactional
	public UserDTO addUser(SignUpDTO user) {

		/*
		 * checking if username or email exists
		 */
		if (userRepository.existsByUserName(user.username())) {
			throw new UserNameAlreadyExistsException(user.username() + " already exists");
		}
		if (userRepository.existsByEmail(user.email())) {
			throw new UserEmailAlreadyExistsException(user.email() + " already exists");
		}
		User newUser = new User();
		newUser.setUserName(user.username());
		newUser.setEmail(user.email());
		newUser.setPassword(passwordEncoder.encode(user.password()));
		newUser.setCreatedAt(LocalDateTime.now());
		// to handle race condition
		/*	
		 * incase multiple users pass the check defined above at same time
		 */
		try {
			userRepository.save(newUser);
			newUser = userRepository.findByUserName(newUser.getUserName()).orElseThrow(
					() -> new ResourceNotFoundException("User with username: " + user.username() + " Not Found"));
			return new UserDTO(newUser.getUserId(), newUser.getUserName(), newUser.getEmail(), newUser.getCreatedAt());
		} catch (DataIntegrityViolationException e) {
			throw new GeneralException("Sign-up failed. try again");
		}

	}

}
