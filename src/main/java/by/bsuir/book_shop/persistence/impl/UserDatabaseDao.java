package by.bsuir.book_shop.persistence.impl;


import by.bsuir.book_shop.persistence.dao.UserDao;
import by.bsuir.book_shop.persistence.models.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Huge Boss on 02.11.2016.
 */
public class UserDatabaseDao implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void add(UserEntity elem) throws SQLException {
        Session session = sessionFactory.openSession();
        session.save(elem);
        session.close();
    }

    public void delete(int id) throws SQLException {
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        Query query = session.createQuery("delete UserEntity  WHERE id = :id");
        query.setParameter("id", id );
        query.executeUpdate();
        session.getTransaction().commit();
    }

    public void update(int id, UserEntity elem) throws SQLException {
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        Query query = session.createQuery("update UserEntity set name = :name, surname = :surname, adress = :adress, login = :login, password = :password WHERE id = :id");
        query.setParameter("name", elem.getName());
        query.setParameter("surname", elem.getSurname());
        query.setParameter("adress", elem.getAdress());
        query.setParameter("login", elem.getLogin());
        query.setParameter("password", elem.getPassword());
        query.setParameter("id", id );
        query.executeUpdate();
        session.getTransaction().commit();

        session.close();
    }

    public List<UserEntity> getAll() throws SQLException {
        Session session = sessionFactory.openSession();
        List<UserEntity> users = null;

        Query query = session.createQuery("FROM UserEntity");
        users = query.getResultList();

        session.close();

        return users;
    }

    public UserEntity getById(int id) throws SQLException {
        Session session = sessionFactory.openSession();
        UserEntity user = null;
        Query query = session.createQuery("FROM UserEntity WHERE id = :id");
        query.setParameter("id", id);
        user = (UserEntity) query.getSingleResult();
        session.close();

        return user;
    }
}
