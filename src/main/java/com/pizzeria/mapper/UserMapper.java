package com.pizzeria.mapper;

import com.pizzeria.dto.response.UserResponse;
import com.pizzeria.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class UserMapper {

    public UserResponse userResponse(User user){
        return new UserResponse(
                user.getId_user(),
                user.getName(),
                user.getLastname(),
                user.getEmail());
    }

    public List<UserResponse> userResponseList(List<User> users){
        return users.stream().map(this::userResponse).toList();
    }
}
