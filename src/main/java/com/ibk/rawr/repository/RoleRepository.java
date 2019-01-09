package com.ibk.rawr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibk.rawr.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
}
