package com.springsecurity.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springsecurity.login.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
