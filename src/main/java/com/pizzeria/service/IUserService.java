package com.pizzeria.service;

import com.pizzeria.entity.User;

import java.util.List;

public interface IUserService {

    List<User> findAllUser();

    User findById(Long id);

    void saveUser(User user);


}
