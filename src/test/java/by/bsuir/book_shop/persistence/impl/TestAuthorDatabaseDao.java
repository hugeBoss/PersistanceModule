package by.bsuir.book_shop.persistence.impl;

import by.bsuir.book_shop.persistence.dao.AuthorDao;
import by.bsuir.book_shop.persistence.models.AuthorEntity;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by Huge Boss on 09.11.2016.
 */
public class TestAuthorDatabaseDao {
    ClassPathXmlApplicationContext context;
    AuthorDao authorDao;

    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("spring.xml");
        authorDao = context.getBean(AuthorDao.class);
    }

    @Test
    public void add() throws Exception {
        AuthorEntity author = new AuthorEntity("INSERT","INSERT");
        authorDao.add(author);
    }

    @Test
    public void delete() throws Exception {
        authorDao.delete(2);
    }

    @Test
    public void update() throws Exception {
        authorDao.update(3, new AuthorEntity("UPDATE","UPDATE"));
    }

    @Test
    public void getAll() throws Exception {
        List<AuthorEntity> authors = authorDao.getAll();
        assertTrue(!authors.isEmpty());
    }

    @Test
    public void getById() throws Exception {
        int testId = 1;
        assertTrue(authorDao.getById(testId) != null);
    }

}