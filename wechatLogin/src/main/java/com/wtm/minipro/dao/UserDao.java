package com.wtm.minipro.dao;

import com.wtm.minipro.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;


@Mapper
@Component(value="userMapper")
public interface UserDao {

    User queryUser(User user);

    void updateUser(User user);

    void insertUser(User user);

}
