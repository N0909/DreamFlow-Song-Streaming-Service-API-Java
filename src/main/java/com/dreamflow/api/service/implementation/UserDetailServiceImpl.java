package com.dreamflow.api.service.implementation;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

//import com.dreamflow.api.entity.User;
import com.dreamflow.api.repository.UserRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

	private final UserRepository userRepository;

	public UserDetailServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.dreamflow.api.entity.User user = userRepository.findByUserName(username)
				.orElseThrow(() -> new UsernameNotFoundException("User With " + username + " Not Found"));
		
		return User.builder()
				.username(user.getUserName())
				.password(user.getPassword())
				.roles()
				.build();
	}

}
