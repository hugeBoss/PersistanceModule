package by.bsuir.book_shop.persistence.impl;


import by.bsuir.book_shop.persistence.dao.BookDao;
import by.bsuir.book_shop.persistence.dao.LanguageDao;
import by.bsuir.book_shop.persistence.models.BookEntity;
import by.bsuir.book_shop.persistence.models.LanguageEntity;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by Huge Boss on 08.11.2016.
 */
public class TestBookDatabaseDao {
    ClassPathXmlApplicationContext context;
    LanguageDao languageDao;
    BookDao bookDao;
    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("spring.xml");
        bookDao = context.getBean(BookDao.class);
        languageDao = context.getBean(LanguageDao.class);
    }

    @Test
    public void add() throws Exception {
        LanguageEntity language = languageDao.getById(3);
        BookEntity book = new BookEntity("INSERT", 9999, language);
        bookDao.add(book);
    }

    @Test
    public void delete() throws Exception {
        bookDao.delete(2);
    }

    @Test
    public void update() throws Exception {
        bookDao.update(3, new BookEntity("UPDATE", 500));
    }

    @Test
    public void getAll() throws Exception {
        List<BookEntity> books = bookDao.getAll();
        assertTrue(!books.isEmpty());
}

    @Test
    public void getById() throws Exception {
        int testId = 7;
        assertTrue(bookDao.getById(testId) != null);
    }

}