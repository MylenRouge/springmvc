package com.pavel.springmvc.service;

import com.pavel.springmvc.model.User;

import java.util.List;

public interface UserService {
    List<User> index();
    User showUsers(Long id);
    void saveUsers(User user);
    void updateUser(Long id, User updatedUser);
    void deleteUser(Long id);
}
