package com.springboot.jap.service;

import com.springboot.jap.dao.UserDao;
import com.springboot.jap.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void addUser(User user) {
        userDao.save(user);
    }

    @Override
    public void deleteUser(int id) {
        userDao.deleteById(id);
    }

    @Override
    public void updateUser(User user) {
        userDao.save(user);
    }

    @Override
    public Optional<User> getUserById(int id) {
        return userDao.findById(id);
    }

    @Override
    public List<User> getAllUser() {
        return (List<User>) userDao.findAll();
    }
}
