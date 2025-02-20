package com.spring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	User findByUsername(String username);

}
