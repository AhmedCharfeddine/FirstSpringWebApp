package com.exercise.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.exercise.demo.models.UserEntity;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

// see: https://spring.io/guides/gs/accessing-data-mysql/

public interface UserRepository extends CrudRepository<UserEntity, Integer> {
    UserEntity findFirstByLogin(String login);
}
