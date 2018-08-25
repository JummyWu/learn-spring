package com.imooc.os.service.impl2;

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
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.Date;


@Service
public class OrderServiceImpl2 implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private TransactionTemplate transactionTemplate;

    public void addOrder(final Order order) {

        order.setCreateTime(new Date());
        order.setStatus("待付款");

        transactionTemplate.execute(new TransactionCallback<Object>() {
            public Object doInTransaction(TransactionStatus transactionStatus) {

                try {
                    orderDao.insert(order);
                    Product product = productDao.select(order.getProductsId());
                    product.setStock(product.getStock() - order.getNumber());
                    productDao.update(product);
                } catch (Exception e) {
                    System.out.println("回滚了1");
                    e.printStackTrace();
                    //只用设置回滚
                    transactionStatus.setRollbackOnly();
                }

                return null;
            }
        });

    }


}
