package com.imooc.aop.CglibProxy;

import org.junit.Test;

public class ProductDaoTest {
    @Test
    public void demo(){
        ProductDao productDao = new ProductDao();
        productDao.save();
        productDao.update();
        productDao.delete();
        productDao.find();
    }

    //增强测试
    @Test
    public void demo1(){
        ProductDao productDao = new ProductDao();

        ProductDao proxy = (ProductDao) new MyCglibProxy(productDao).createProxy();

        proxy.save();
        proxy.update();
        proxy.delete();
        proxy.find();
    }
}
