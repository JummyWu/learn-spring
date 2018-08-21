package com.springboot.jap.controller;

import com.springboot.jap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getAllUser", method = RequestMethod.GET)
    private Map<String, Object> getAllUser() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("userList", userService.getAllUser());
        return hashMap;
    }

    @RequestMapping(value = "/getUser/{userId}", method = RequestMethod.GET)
    private Map<String, Object> getUser(@PathVariable("userId") int userId) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("user", userService.getUserById(userId));
        return hashMap;
    }

}
