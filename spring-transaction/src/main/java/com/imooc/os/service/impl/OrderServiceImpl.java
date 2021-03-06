package com.imooc.os.service.impl;

import com.imooc.os.dao.OrderDao;
import com.imooc.os.dao.ProductDao;
import com.imooc.os.entity.Order;
import com.imooc.os.entity.Product;
import com.imooc.os.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;

import java.util.Date;


@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private ProductDao productDao;

    //事务管理对象
    @Autowired
    private PlatformTransactionManager platformTransactionManager;

    //事务定义对象
    @Autowired
    private TransactionDefinition transactionDefinition;


    public void addOrder(Order order) {


        order.setCreateTime(new Date());
        order.setStatus("待付款");

        TransactionStatus transactionStatus = platformTransactionManager.getTransaction(transactionDefinition);
        try {
            orderDao.insert(order);
            Product product = productDao.select(order.getProductsId());
            product.setStock(product.getStock() - order.getNumber());
            productDao.update(product);

            platformTransactionManager.commit(transactionStatus);
        } catch (Exception e) {
            System.out.println("回滚了");
            e.printStackTrace();
            platformTransactionManager.rollback(transactionStatus);
        }

    }


}
