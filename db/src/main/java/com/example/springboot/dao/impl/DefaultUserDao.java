package com.example.springboot.dao.impl;

import com.example.springboot.dao.UserDao;
import com.example.springboot.model.User;

import java.util.List;
import java.util.Optional;

public class DefaultUserDao implements UserDao {
    private static final List<User> STORAGE = List.of(
            new User(1L, "Chuck", "Norris"),
            new User(2L, "Arnold", "Schwarzenegger")
    );

    @Override
    public User getUser(long userId) {
        return STORAGE.stream()
                      .filter(user -> user.id().equals(userId))
                      .findFirst()
                      .orElseThrow(() -> new IllegalArgumentException("User not found"));
    }

    @Override
    public Optional<User> findUser(long userId) {
        return STORAGE.stream()
                      .filter(user -> user.id().equals(userId))
                      .findFirst();
    }
}