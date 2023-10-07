package com.pavel.springmvc.service;

import com.pavel.springmvc.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User showUser(Long id);
    void saveUser(User user);
    void updateUser(User updatedUser);
    void deleteUser(Long id);
}
