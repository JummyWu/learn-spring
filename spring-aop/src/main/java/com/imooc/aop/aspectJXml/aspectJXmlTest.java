package com.imooc.aop.aspectJXml;


import com.imooc.aop.aspectJ.ProductDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext6.xml")
public class aspectJXmlTest {

    @Resource(name="customerDao")
    private CustomerDao customerDao;

    @Test
    public void demo(){
        customerDao.save();
        customerDao.detele();
        customerDao.find();
        customerDao.update();
        customerDao.findAll();
    }

}
