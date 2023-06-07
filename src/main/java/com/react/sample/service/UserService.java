package com.react.sample.service;

import com.react.sample.model.User;

import java.util.List;

public interface UserService {
    public User saveUser(User user);
    public List<User> getAllUser();
}