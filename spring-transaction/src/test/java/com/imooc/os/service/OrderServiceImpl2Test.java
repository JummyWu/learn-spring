package com.imooc.os.service;

import com.imooc.os.entity.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:spring-dao2.xml")
//@ContextConfiguration("classpath:spring-aop-dao4.xml")
//@ContextConfiguration("classpath:spring-aop-dao3.xml")
//@ContextConfiguration("classpath:spring-aop-dao5.xml")
@ContextConfiguration("classpath:spring-aop-dao6.xml")
public class OrderServiceImpl2Test {

    @Autowired
    private OrderService orderService;

    @Test
    public void addOrder() {
        Order order = new Order("100014", "100001", 7, 3299, "", "", "");
        orderService.addOrder(order);
    }
}