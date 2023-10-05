package com.pavel.springmvc.dao;

import com.pavel.springmvc.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> index() {
        return entityManager.createQuery("SELECT user FROM User user", User.class).getResultList();
    }
    @Override
    public User showUsers(Long id) {
        return entityManager.find(User.class, id);
    }
    @Override
    public void saveUsers(User user) {
        entityManager.persist(user);
    }
    @Override
    public void updateUser(Long id, User updatedUser) {
        User user = entityManager.merge(updatedUser);
        user.setName(updatedUser.getName());
        user.setSurname(updatedUser.getSurname());
        user.setAge(updatedUser.getAge());
        entityManager.flush();
    }
    @Override
    public void deleteUser(Long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }
}