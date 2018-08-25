package com.imooc.aop.SpringAopDefaultAutoProxy;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext4.xml")
public class SpringAopTest {


    @Resource(name="studentDao")
    private StudentDao studentDao;

    @Resource(name="customerDao")
    private CustomerDao customerDao;


    @Test
    public void demo1(){
        //给所有方法加入了前置增强
        studentDao.find();
        studentDao.save();
        studentDao.update();
        studentDao.delete();


        customerDao.find();
        customerDao.save();
        customerDao.update();
        customerDao.delete();
    }

}