package by.bsuir.book_shop.persistence.impl;


import by.bsuir.book_shop.persistence.dao.LanguageDao;
import by.bsuir.book_shop.persistence.models.LanguageEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Huge Boss on 02.11.2016.
 */
public class LanguageDatabaseDao implements LanguageDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void add(LanguageEntity elem) throws SQLException {
        Session session = sessionFactory.openSession();
        session.save(elem);
        session.close();
    }

    public void delete(int id) throws SQLException {
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        Query query = session.createQuery("delete LanguageEntity  WHERE id = :id");
        query.setParameter("id", id );
        query.executeUpdate();

        session.getTransaction().commit();
    }

    public void update(int id, LanguageEntity language) throws SQLException {
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        Query query = session.createQuery("update LanguageEntity set name = :name WHERE id = :id");
        query.setParameter("name", language.getName());
        query.setParameter("id", id );
        query.executeUpdate();
        session.getTransaction().commit();

        session.close();

    }

    public List<LanguageEntity> getAll() throws SQLException {
        Session session = sessionFactory.openSession();
        List<LanguageEntity> languages = null;

        Query query = session.createQuery("FROM LanguageEntity");
        languages = query.getResultList();

        session.close();

        return languages;
    }

    public LanguageEntity getById(int id) throws SQLException {
        Session session = sessionFactory.openSession();
        LanguageEntity language = null;
        Query query = session.createQuery("FROM LanguageEntity WHERE id = :id");
        query.setParameter("id", id);
        language = (LanguageEntity) query.getSingleResult();
        session.close();

        return language;
    }
}
