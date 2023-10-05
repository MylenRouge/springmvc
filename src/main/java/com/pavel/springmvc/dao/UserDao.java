package com.pavel.springmvc.dao;

import com.pavel.springmvc.model.User;

import java.util.List;

public interface UserDao {
    List<User> index();
    User showUsers(Long id);
    void saveUsers(User user);
    void updateUser(Long id, User updateUserdUser);
    void deleteUser(Long id);

}