package by.bsuir.book_shop.persistence.impl;


import by.bsuir.book_shop.persistence.dao.LanguageDao;
import by.bsuir.book_shop.persistence.models.LanguageEntity;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by Huge Boss on 11.11.2016.
 */
public class TestLanguageDatabaseDao {
    ClassPathXmlApplicationContext context;
    LanguageDao languageDao;
    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("spring.xml");
        languageDao = context.getBean(LanguageDao.class);
    }

    @Test
    public void add() throws Exception {
        LanguageEntity language = new LanguageEntity("INSERT");
        languageDao.add(language);
    }

    @Test
    public void delete() throws Exception {
        languageDao.delete(2);
    }

    @Test
    public void update() throws Exception {
        languageDao.update(3, new LanguageEntity("UPDATE"));
    }

    @Test
    public void getAll() throws Exception {
        List<LanguageEntity> languages = languageDao.getAll();
        assertTrue(!languages.isEmpty());
    }

    @Test
    public void getById() throws Exception {
        int testId = 1;
        assertTrue(languageDao.getById(testId) != null);
    }

}