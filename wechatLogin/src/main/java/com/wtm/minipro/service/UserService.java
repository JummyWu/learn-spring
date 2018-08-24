package com.wtm.minipro.service;

import com.wtm.minipro.entity.User;

import java.io.IOException;
import java.util.HashMap;

public interface UserService {

    HashMap login(String code) throws IOException;

    HashMap getUserInfo(String sKey, String rawData, String iv, String signature, String encryptedData );

}
