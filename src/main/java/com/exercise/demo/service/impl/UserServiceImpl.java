package com.exercise.demo.service.impl;



import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.exercise.demo.models.Role;
import com.exercise.demo.models.UserEntity;
import com.exercise.demo.repositories.RoleRepository;
import com.exercise.demo.repositories.UserRepository;

import com.exercise.demo.DTO.RegistrationDto;
import com.exercise.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl() {
    }

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public void saveUser(RegistrationDto registrationDto) {
        UserEntity user = new UserEntity();
        user.setLogin(registrationDto.getLogin());
        user.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
        Role role = roleRepository.findByName("USER");
        user.setRoles(Arrays.asList(role));
        user.setRoles(Arrays.asList(roleRepository.findByName("ROLE_USER")));
        userRepository.save(user);
    }

    public UserEntity findByLogin(String login) {
        return userRepository.findFirstByLogin(login);
    }
}

