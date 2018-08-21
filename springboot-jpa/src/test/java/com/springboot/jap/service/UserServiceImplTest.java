package com.springboot.jap.service;

import com.springboot.jap.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    public void addUser() {
        User user = new User();
        user.setUserName("张三");
        user.setAge(30);

        userService.addUser(user);
    }

    @Test
    public void deleteUser() {
        int deleteId = 2;
        userService.deleteUser(deleteId);
    }

    @Test
    public void updateUser() {
        User user = new User();
        user.setUserName("李四");
        user.setId(3);
        userService.updateUser(user);
    }

    @Test
    public void getUserById() {
        int getId = 3;
        Optional<User> user = userService.getUserById(getId);
        System.out.println(user);
    }

    @Test
    public void getAllUser() {
        List<User> list = userService.getAllUser();
        for(User user : list){
            System.out.println(user);
        }
    }
}