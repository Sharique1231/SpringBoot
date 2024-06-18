package com.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.spring.entities.User;
import com.spring.repository.UserRepository;

@SpringBootApplication
public class SpringSecurityApplication implements CommandLineRunner {
	@Autowired
	UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		User user = new User();
		user.setUserName("test1");
		user.setPassword(passwordEncoder.encode("test@123"));
		user.setRole("ROLE_NORMAL");
		userRepository.save(user);

		User user1 = new User();
		user1.setUserName("test2");
		user1.setPassword(passwordEncoder.encode("test@123"));
		user1.setRole("ROLE_NORMAL");
		userRepository.save(user1);
	}
}
