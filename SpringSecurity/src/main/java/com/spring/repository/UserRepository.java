package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.entities.User;
import java.util.List;


public interface UserRepository extends JpaRepository<User, Integer> {
 public User findByUserName(String userName);
}
