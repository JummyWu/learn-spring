package com.imooc.aop.SpringAopBeforeAdvice;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class StudentDaoImplTest {


    //这里要注入xml里面的代理类
    @Resource(name="studentDaoProxy")
    private StudentDao studentDao;

    @Test
    public void demo1(){
        //给所有方法加入了前置增强
        studentDao.find();
        studentDao.save();
        studentDao.update();
        studentDao.delete();
    }

}
