package com.spring;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.spring.Repository.UserRepository;
import com.spring.entity.User;

@SpringBootApplication
public class SpringJwtApplication {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(SpringJwtApplication.class, args);
	}
	
	@PostConstruct
	void initialise()
	{
		User user = new User();
		user.setUsername("test1");
		user.setPassword("test@123");
		userRepository.save(user);
	}

}
