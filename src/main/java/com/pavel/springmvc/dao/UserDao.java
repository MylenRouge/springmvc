package com.pavel.springmvc.dao;

import com.pavel.springmvc.model.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();
    User showUser(Long id);
    void saveUser(User user);
    void updateUser(User updateUserdUser);
    void deleteUser(Long id);

}