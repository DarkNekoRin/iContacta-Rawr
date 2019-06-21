package com.ibk.rawr.service;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ibk.rawr.entity.User;
import com.ibk.rawr.repository.RoleRepository;
import com.ibk.rawr.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(roleRepository.findAll()));
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

	@Override
	public void update(User user) {
		userRepository.save(user);
	}

	@Override
	public PageRequest buildPageRequest(int num, int size, Direction asc, String string) {
		 return new PageRequest(num-1, size,null,string);
	}

	@Override
	public Page<User> findAll(int pageNo, int pageSize, Direction dir, String str) {
		PageRequest request = buildPageRequest(pageNo, pageSize, dir, str);
        Page<User> users = userRepository.findAll(request);
        return users;
	}

}
