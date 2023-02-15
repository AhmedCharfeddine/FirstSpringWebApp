package com.exercise.demo.service;

import com.exercise.demo.models.UserEntity;


import com.exercise.demo.DTO.RegistrationDto;

public interface UserService {
    void saveUser(RegistrationDto registrationDto);
    UserEntity findByLogin(String login);
}