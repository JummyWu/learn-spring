package com.imooc.aop.JdkProxy;


import org.junit.Test;

public class UserDaoImplTest {

    //普通测试
    @Test
    public void demo(){
        UserDao userDao = new UserDaoImpl();

        userDao.save();
        userDao.update();
        userDao.delete();
        userDao.find();
    }

    //jdkProxy代理类增强测试
    @Test
    public void demo1(){
        UserDao userDao = new UserDaoImpl();
        UserDao proxy = (UserDao)new MyJdkProxy(userDao).createProxy();

        proxy.save();
        proxy.update();
        proxy.delete();
        proxy.find();

        //权限校验
        //保存
        //修改
        //删除
        //查找
    }

}
