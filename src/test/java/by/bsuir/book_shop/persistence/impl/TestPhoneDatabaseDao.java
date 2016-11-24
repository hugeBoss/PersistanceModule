package by.bsuir.book_shop.persistence.impl;


import by.bsuir.book_shop.persistence.dao.PhoneDao;
import by.bsuir.book_shop.persistence.dao.UserDao;
import by.bsuir.book_shop.persistence.models.PhoneEntity;
import by.bsuir.book_shop.persistence.models.UserEntity;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by Huge Boss on 11.11.2016.
 */
public class TestPhoneDatabaseDao {
    ClassPathXmlApplicationContext context;
    PhoneDao phoneDao;
    UserDao userDao;

    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("spring.xml");
        userDao = context.getBean(UserDao.class);
        phoneDao = context.getBean(PhoneDao.class);
    }

    @Test
    public void add() throws Exception {
        PhoneEntity phone = new PhoneEntity("INSERT","INSERT");
        UserEntity user = userDao.getById(3);
        phone.setUser(user);
        phoneDao.add(phone);
    }

    @Test
    public void delete() throws Exception {
        phoneDao.delete(2);
    }

    @Test
    public void update() throws Exception {
        phoneDao.update(3, new PhoneEntity("UPDATE","INSERT"));
    }

    @Test
    public void getAll() throws Exception {
        List<PhoneEntity> phones = phoneDao.getAll();
        assertTrue(!phones.isEmpty());
    }

    @Test
    public void getById() throws Exception {
        int testId = 1;
        assertTrue(phoneDao.getById(testId) != null);
    }

}