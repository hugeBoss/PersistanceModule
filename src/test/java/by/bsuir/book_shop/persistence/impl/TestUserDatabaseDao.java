package by.bsuir.book_shop.persistence.impl;


import by.bsuir.book_shop.persistence.dao.UserDao;
import by.bsuir.book_shop.persistence.models.UserEntity;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by Huge Boss on 11.11.2016.
 */
public class TestUserDatabaseDao {
    ClassPathXmlApplicationContext context;
    UserDao userDao;

    @Before
    public void setUp() throws Exception {
       context = new ClassPathXmlApplicationContext("spring.xml");
        userDao = context.getBean(UserDao.class);
    }

    @Test
    public void add() throws Exception {
        UserEntity user = new UserEntity("INSERT", "INSERT", "INSERT", "INSERT", "INSERT");
        userDao.add(user);
    }

    @Test
    public void delete() throws Exception {
        userDao.delete(2);
    }

    @Test
    public void update() throws Exception {
        userDao.update(3, new UserEntity("UPDATE", "UPDATE", "UPDATE", "UPDATE", "UPDATE"));
    }

    @Test
    public void getAll() throws Exception {
        List<UserEntity> users = userDao.getAll();
        assertTrue(!users.isEmpty());
    }

    @Test
    public void getById() throws Exception {
        int testId = 1;
        assertTrue(userDao.getById(testId) != null);
    }

}