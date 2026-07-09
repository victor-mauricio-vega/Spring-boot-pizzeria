package com.pizzeria.service;

import com.pizzeria.dto.request.RegisterRequest;
import com.pizzeria.entity.User;
import com.pizzeria.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<User> findAllUser() {
        return userRepo.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepo.findById(id).orElseThrow();
    }

    @Override
    public User registerUser(RegisterRequest registerRequest) {
//        if (userRepo.existsByEmail(registerRequest.email())) {
//
//        }

        User newUser = User.builder()
                .name(registerRequest.name())
                .lastname(registerRequest.lastname())
                .email(registerRequest.email())
                .password(passwordEncoder.encode(registerRequest.password()))
                .build();

        return userRepo.save(newUser);
    }
}
