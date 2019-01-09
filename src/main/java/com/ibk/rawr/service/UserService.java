package com.ibk.rawr.service;

import com.ibk.rawr.entity.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
