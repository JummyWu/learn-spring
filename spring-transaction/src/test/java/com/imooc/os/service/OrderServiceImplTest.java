package com.imooc.os.service;

import com.imooc.os.entity.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-dao1.xml")
public class OrderServiceImplTest {

    @Autowired
    private OrderService orderService;


    @Test
    public void addOrder() {
        Order order = new Order("100008", "100004", 1, 3299, "", "", "");
        orderService.addOrder(order);
    }
}