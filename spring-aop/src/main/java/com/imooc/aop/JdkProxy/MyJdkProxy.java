package com.imooc.aop.JdkProxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 创建userdao代理类，对其增强
 * 只能对实现了接口的类代理增强
 */

public class MyJdkProxy implements InvocationHandler {


    private UserDao userDao;

    public MyJdkProxy(UserDao userDao){
        this.userDao = userDao;
    }

    //第一步：创建代理对象
    public Object createProxy(){
        Object proxy = Proxy.newProxyInstance(userDao.getClass().getClassLoader(), userDao.getClass().getInterfaces(), this);
        return proxy;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if("save".equals(method.getName())){
            System.out.println("权限校验");
            return method.invoke(userDao, args);
        }

        return method.invoke(userDao, args);
    }
}
