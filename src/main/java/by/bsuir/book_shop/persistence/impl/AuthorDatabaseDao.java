package by.bsuir.book_shop.persistence.impl;


import by.bsuir.book_shop.persistence.dao.AuthorDao;
import by.bsuir.book_shop.persistence.models.AuthorEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Huge Boss on 02.11.2016.
 */
public class AuthorDatabaseDao implements AuthorDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void add(AuthorEntity elem) throws SQLException {
        Session session = sessionFactory.openSession();
        session.save(elem);
        session.close();
    }

    public void delete(int id) throws SQLException {
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        Query query = session.createQuery("delete AuthorEntity  WHERE id = :id");
        query.setParameter("id", id );
        query.executeUpdate();
        session.getTransaction().commit();
    }

    public void update(int id, AuthorEntity author) throws SQLException {
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        Query query = session.createQuery("update AuthorEntity set name = :name, surname = :surname WHERE id = :id");
        query.setParameter("name", author.getName());
        query.setParameter("surname", author.getSurname() );
        query.setParameter("id", id );
        query.executeUpdate();
        session.getTransaction().commit();

        session.close();

    }

    public List<AuthorEntity> getAll() throws SQLException {
        Session session = sessionFactory.openSession();
        List<AuthorEntity> authors = null;

        Query query = session.createQuery("FROM AuthorEntity");
        authors = query.getResultList();

        session.close();

        return  authors;
    }

    public AuthorEntity getById(int id) throws SQLException {
        Session session = sessionFactory.openSession();
        AuthorEntity author = null;
        Query query = session.createQuery("FROM AuthorEntity WHERE id = :id");
        query.setParameter("id", id);
        author = (AuthorEntity) query.getSingleResult();
        session.close();

        return author;
    }
}
