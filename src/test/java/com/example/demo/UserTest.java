package com.example.demo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dreamflow.api.repository.UserRepository;

@SpringBootTest
public class UserTest {
	@Autowired
	private UserRepository repository;
	
	@Test
	public void testUser() {
		System.out.println(repository.isUserNameExists("n0909"));
	}
}
