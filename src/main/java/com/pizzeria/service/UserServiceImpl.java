package com.pizzeria.service;

import com.pizzeria.entity.User;
import com.pizzeria.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    private UserRepository userRepo;

    @Override
    public List<User> findAllUser() {
        return (List<User>) userRepo.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepo.findById(id).orElseThrow();
    }


    @Override
    public void saveUser(User user) {
        userRepo.save(user);
    }
}
