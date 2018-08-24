package com.wtm.minipro.controller;

import com.wtm.minipro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;

@RestController
@RequestMapping("/wechat")
public class WechatLogin {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public HashMap<String, Object> login(
            @RequestParam("code") String code
    ) throws IOException {
        return userService.login(code);
    }

    @RequestMapping("/getUserInfo")
    public HashMap<String, Object> getUserInfo(
            @RequestParam("sKey") String sKey,
            @RequestParam("rawData") String rawData,
            @RequestParam("iv") String iv,
            @RequestParam("signature") String signature,
            @RequestParam("encryptedData") String encryptedData
    ) {
        return userService.getUserInfo(sKey, rawData, iv, signature, encryptedData);
    }


}
