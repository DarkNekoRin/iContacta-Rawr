package com.ibk.rawr.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.ibk.rawr.entity.User;

public interface UserService {
    void save(User user);
    User findByUsername(String username);
    void update(User user);
    PageRequest buildPageRequest(int num, int size, Sort.Direction asc,
            String string);
    public Page<User> findAll(int pageNo, int pageSize, Sort.Direction dir, String str);
}
