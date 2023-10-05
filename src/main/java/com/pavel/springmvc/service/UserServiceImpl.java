package com.pavel.springmvc.service;

import com.pavel.springmvc.dao.UserDao;
import com.pavel.springmvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> index() {
        return userDao.index();
    }

    @Override
    public User showUsers(Long id) {
        return userDao.showUsers(id);
    }

    @Transactional
    @Override
    public void saveUsers(User user) {
        userDao.saveUsers(user);
    }

    @Transactional
    @Override
    public void updateUser(Long id, User updatedUser) {
        userDao.updateUser(id, updatedUser);
    }

    @Transactional
    @Override
    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }
}