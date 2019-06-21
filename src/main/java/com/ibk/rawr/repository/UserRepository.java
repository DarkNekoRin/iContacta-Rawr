package com.ibk.rawr.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.ibk.rawr.entity.User;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    User findByUsername(String username);
}
