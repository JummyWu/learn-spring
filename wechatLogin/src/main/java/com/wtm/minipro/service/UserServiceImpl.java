package com.wtm.minipro.service;

import com.wtm.minipro.dao.UserDao;
import com.wtm.minipro.dto.Jscode2sessionDto;
import com.wtm.minipro.entity.User;
import com.wtm.minipro.utils.AESUtil;
import com.wtm.minipro.utils.ResultMsgUtil;
import com.wtm.minipro.utils.WechatUtil;
import net.sf.json.JSONObject;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.util.HashMap;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    /**
     * 微信小程序登录
     * @param code
     * @return
     * @throws IOException
     */
    @Override
    public HashMap<String, Object> login(String code) throws IOException {

        HashMap<String, Object> hashMap = new HashMap<>();

        /**
         * 1.拿到code
         * appid + appsecret + code
         * 拿到session_key + openid
         */
        Jscode2sessionDto jscode2session = WechatUtil.getJscode2session(code);
        String sessionkey = jscode2session.getSessionKey();
        String openid = jscode2session.getOpenid();

        /**
         * 2.生产唯一标识uuid
         */
        String sKey = UUID.randomUUID().toString();

        /**
         * 3.根据openid去数据库查询用户数据
         */
        User newUser = new User();
        newUser.setOpenid(openid);
        User user = userDao.queryUser(newUser);
        newUser.setsKey(sKey);
        newUser.setSessionkey(sessionkey);

        //表示未登陆新用户
        if (user == null) {
            userDao.insertUser(newUser);
            hashMap.put("msg", "新用户");
        } else {
            //更新sKey
            userDao.updateUser(newUser);
            hashMap.put("msg", "老用户");
        }

        hashMap.put("sKey", sKey);

        return ResultMsgUtil.success(hashMap);

    }

    /**
     * 获取用户信息
     * @param sKey
     * @param rawData
     * @param iv
     * @param signature
     * @param encryptedData
     * @return
     */
@Override
public HashMap getUserInfo(String sKey, String rawData, String iv, String signature, String encryptedData) {

    HashMap<String, Object> hashMap = new HashMap<>();

    User newUser = new User();
    newUser.setsKey(sKey);

    /**
     * 1.通过sKey去数据库拿到sessionkey
     */
    User user = userDao.queryUser(newUser);

    /**
     * 2.加密数据解密算法获取openid
     */
    if (user != null) {
        try {
            String session_key = user.getSessionkey();
            byte[] resultByte = AESUtil.decrypt(Base64.decodeBase64(encryptedData),
                    Base64.decodeBase64(session_key),
                    Base64.decodeBase64(iv));
            if (resultByte != null && resultByte.length > 0) {
                String userInfo = new String(resultByte, "UTF-8");
                hashMap.put("userInfo", JSONObject.fromObject(rawData));
                if (userInfo != null) {
                    JSONObject userInfoJson = JSONObject.fromObject(userInfo);
                    newUser.setCity(userInfoJson.getString("city"));
                    newUser.setAvatarUrl(userInfoJson.getString("avatarUrl"));
                    newUser.setCountry(userInfoJson.getString("country"));
                    newUser.setNickName(userInfoJson.getString("nickName"));
                    newUser.setGender(userInfoJson.getString("gender"));
                    newUser.setProvince(userInfoJson.getString("province"));
                    newUser.setOpenid(userInfoJson.getString("openId"));
                    userDao.updateUser(newUser);
                }
            }
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    } else {
        hashMap.put("msg", "user不存在");
    }

    return  ResultMsgUtil.success(hashMap);
}
}
