package com.spring.restful.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.restful.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByusername(String username);
}
