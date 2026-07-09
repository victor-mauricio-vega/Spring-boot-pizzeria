package com.pizzeria.controller;

import com.pizzeria.dto.request.RegisterRequest;
import com.pizzeria.dto.response.UserResponse;
import com.pizzeria.entity.User;
import com.pizzeria.mapper.UserMapper;
import com.pizzeria.service.IUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private UserMapper userMapper;

    @GetMapping
    public ResponseEntity<List<UserResponse>> findAllUser(){
        return ResponseEntity.ok(userMapper.userResponseList(userService.findAllUser()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> findByIdUser(@PathVariable Long id){
        User user = userService.findById(id);
        return ResponseEntity.ok(userMapper.userResponse(user));
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> registerUser(@Valid @RequestBody RegisterRequest registerRequest){
        User userSaved = userService.registerUser(registerRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(userMapper.userResponse(userSaved));
    }

}
