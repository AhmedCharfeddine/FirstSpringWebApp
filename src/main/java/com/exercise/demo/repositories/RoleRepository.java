package com.exercise.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exercise.demo.models.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByName(String name);
}
