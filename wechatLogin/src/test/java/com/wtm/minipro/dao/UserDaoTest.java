package com.wtm.minipro.dao;

import com.wtm.minipro.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void queryUser() {
        User user = new User();
        //user.setNickName("张三");
        System.out.println(userDao.queryUser(user));
    }

    @Test
    public void updateUser() {
        User user = new User();
        user.setNickName("张三");
        user.setCity("武汉");
        userDao.updateUser(user);
    }

    @Test
    public void insertUser() {
        User user = new User();
        user.setNickName("李四");
        userDao.insertUser(user);
    }
}