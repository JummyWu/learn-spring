package com.wtm.minipro.utils;

import com.wtm.minipro.dto.Jscode2sessionDto;
import net.sf.json.JSONObject;

import java.io.IOException;

public class WechatUtil {
    private static final String SECRET = "你自己小程序的SECRET";
    private static final String APPID = "你自己小程序的APPID";

    private static final String requestUrl = "https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code";

    public static Jscode2sessionDto getJscode2session(String code) throws IOException {

        Jscode2sessionDto jscode2session = new Jscode2sessionDto();
        //请求url
        String url = requestUrl.replace("APPID", APPID).replace("SECRET", SECRET).replace("JSCODE", code);

        JSONObject jsonObject = SendRequestUtil.doGet(url);

        if(jsonObject != null){
            jscode2session.setOpenid(jsonObject.getString("openid"));
            jscode2session.setSessionKey(jsonObject.getString("session_key"));
//            jscode2session.setUnionid(jsonObject.getString("unionid"));
        }

        return jscode2session;
    }

}
