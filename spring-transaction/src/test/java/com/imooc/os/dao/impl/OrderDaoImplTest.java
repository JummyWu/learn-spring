package com.imooc.os.dao.impl;

import com.imooc.os.dao.OrderDao;
import com.imooc.os.entity.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-dao.xml")
public class OrderDaoImplTest {

    @Autowired
    private OrderDao orderDao;

    @Test
    public void insert() {
        Order order = new Order("100006", "100002", 2, 1799, "", "", "");
        orderDao.insert(order);
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void select() {
    }

    @Test
    public void select1() {
    }
}