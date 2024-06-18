package com.spring.controller;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.entity.Request;
import com.spring.util.JwtUtil;

@RestController
public class Controller {
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JwtUtil jwtUtil;
	
	@Autowired
    PasswordEncoder passwordEncoder;
	
	@GetMapping("/hello")
	public Object hello()
	{
	  return "hello sharik";
		
	}
	
	@PostMapping("authenticate")
	public Object authenticate(@RequestBody Request request) throws Exception
	{
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword()));
		} catch (Exception e) {
			// TODO: handle exception
			 throw new Exception("inavalid username/password");
		}
		return jwtUtil.generateToken(request.getUsername());
	}
}
