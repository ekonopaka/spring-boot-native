package com.example.springboot.dao;

import com.example.springboot.model.User;

import java.util.Optional;

public interface UserDao {
    User getUser(long userId);

    Optional<User> findUser(long userId);
}