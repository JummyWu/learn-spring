package com.wtm.minipro.utils;



import java.util.HashMap;

public class ResultMsgUtil {

    public static HashMap<String, Object> success(Object object){
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("ret", 0);
        hashMap.put("msg", "请求成功");
        hashMap.put("data", object);
        return hashMap;
    }

}
