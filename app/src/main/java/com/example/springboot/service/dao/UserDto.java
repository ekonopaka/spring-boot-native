package com.example.springboot.service.dao;

import com.example.springboot.model.User;

public record UserDto(Long id,
                      String firstname,
                      String lastname) {
    public static UserDto asDto(User user) {
        return new UserDto(user.id(), user.firstname(), user.lastname());
    }
}