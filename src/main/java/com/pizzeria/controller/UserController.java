package com.pizzeria.controller;

import com.pizzeria.entity.User;
import com.pizzeria.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping
    public ResponseEntity<List<User>> findAllUser(){
        return ResponseEntity.ok(userService.findAllUser());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findByIdUser(@PathVariable Long id){
        return ResponseEntity.ok(userService.findById(id));
    }

    @PostMapping()
    public void saveUser(@RequestBody User user){
        userService.saveUser(user);
    }

}
