package by.bsuir.book_shop.persistence.impl;


import by.bsuir.book_shop.persistence.dao.BookDao;
import by.bsuir.book_shop.persistence.models.BookEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Huge Boss on 02.11.2016.
 */
public class BookDatabaseDao  implements BookDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void add(BookEntity elem) throws SQLException {
        Session session = sessionFactory.openSession();
        session.save(elem);
        session.close();
    }

    public void delete(int id) throws SQLException {
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        Query query = session.createQuery("delete BookEntity WHERE id = :id");
        query.setParameter("id", id );
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    public void update(int id, BookEntity book) throws SQLException {
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        Query query = session.createQuery("update BookEntity set name = :name, price = :price WHERE id = :id");
        query.setParameter("name", book.getName());
        query.setParameter("price", book.getPrice());
        query.setParameter("id", id );
        query.executeUpdate();
        session.getTransaction().commit();

        session.close();
    }

    public List<BookEntity> getAll() throws SQLException {
        Session session = sessionFactory.openSession();
        List<BookEntity> books = null;
        Query query = session.createQuery("FROM BookEntity");
        books = query.list();
        return  books;

    }

    public BookEntity getById(int id) throws SQLException {
       Session session = sessionFactory.openSession();
        BookEntity book = null;

        Query query = session.createQuery("FROM BookEntity WHERE id = :id");
        query.setParameter("id", id);
        book = (BookEntity) query.getSingleResult();

        session.close();

        return book;
    }
}
