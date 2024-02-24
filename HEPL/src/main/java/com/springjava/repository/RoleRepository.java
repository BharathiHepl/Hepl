package com.springjava.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springjava.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
	Optional<Role> findByName(String name);
	
}

