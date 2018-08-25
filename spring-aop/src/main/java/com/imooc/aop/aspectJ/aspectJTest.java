package com.imooc.aop.aspectJ;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext5.xml")
public class aspectJTest {

    @Resource(name="productDao")
    private ProductDao productDao;

    @Test
    public void demo(){
        productDao.save();
        productDao.detele();
        productDao.find();
        productDao.update();
        productDao.findAll();
    }

}
