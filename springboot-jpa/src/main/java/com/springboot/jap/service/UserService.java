package com.springboot.jap.service;

import com.springboot.jap.entity.User;

import java.util.List;
import java.util.Optional;


public interface UserService {
    void addUser(User user);
    void deleteUser(int id);
    void updateUser(User user);
    Optional<User> getUserById(int id);
    List<User> getAllUser();
}
