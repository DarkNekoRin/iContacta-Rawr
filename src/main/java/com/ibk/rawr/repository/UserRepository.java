package com.ibk.rawr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibk.rawr.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
