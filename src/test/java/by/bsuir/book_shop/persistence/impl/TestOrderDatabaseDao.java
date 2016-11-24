package by.bsuir.book_shop.persistence.impl;


import by.bsuir.book_shop.persistence.dao.OrderDao;
import by.bsuir.book_shop.persistence.dao.UserDao;
import by.bsuir.book_shop.persistence.models.OrderEntity;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by Huge Boss on 10.11.2016.
 */
public class TestOrderDatabaseDao {
    ClassPathXmlApplicationContext context;
    OrderDao orderDao;
    UserDao userDao;
    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("spring.xml");
        orderDao = context.getBean(OrderDao.class);
        userDao = context.getBean(UserDao.class);
    }

    @Test
    public void add() throws Exception {
        OrderEntity order = new OrderEntity();
        order.setUser(userDao.getById(1));
        orderDao.add(order);
    }

    @Test
    public void delete() throws Exception {
        orderDao.delete(2);
    }

    @Test
    public void update() throws Exception {
       
    }

    @Test
    public void getAll() throws Exception {
        List<OrderEntity> orders = orderDao.getAll();
        assertTrue(!orders.isEmpty());
    }

    @Test
    public void getById() throws Exception {
        int testId = 5;
        assertTrue(orderDao.getById(testId) != null);
    }

}