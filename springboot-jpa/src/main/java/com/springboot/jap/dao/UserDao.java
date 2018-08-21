package com.springboot.jap.dao;

import com.springboot.jap.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User, Integer> {

}
