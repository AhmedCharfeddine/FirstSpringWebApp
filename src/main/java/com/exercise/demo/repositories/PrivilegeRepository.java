package com.exercise.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exercise.demo.models.Privilege;

public interface PrivilegeRepository extends JpaRepository<Privilege, Integer> {
    Privilege findByName(String name);
}
