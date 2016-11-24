package by.bsuir.book_shop.persistence.impl;


import by.bsuir.book_shop.persistence.dao.PhoneDao;
import by.bsuir.book_shop.persistence.models.PhoneEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Huge Boss on 02.11.2016.
 */
public class PhoneDatabaseDao implements PhoneDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void add(PhoneEntity elem) throws SQLException {
        Session session = sessionFactory.openSession();
        session.save(elem);
        session.close();
    }

    public void delete(int id) throws SQLException {
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        Query query = session.createQuery("delete PhoneEntity  WHERE id = :id");
        query.setParameter("id", id );
        query.executeUpdate();

        session.getTransaction().commit();
        session.close();
    }

    public void update(int id, PhoneEntity elem) throws SQLException {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("update PhoneEntity set phone = :phone, type_of_phone = :type_phone WHERE id = :id");
        query.setParameter("phone", elem.getPhone());
        query.setParameter("type_phone", elem.getTypeOfPhone());
        query.setParameter("id", id );
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    public List<PhoneEntity> getAll() throws SQLException {
        Session session = sessionFactory.openSession();
        List<PhoneEntity> phones = null;
        Query query = session.createQuery("FROM PhoneEntity");
        phones = query.getResultList();
        session.close();
        return phones;
    }

    public PhoneEntity getById(int id) throws SQLException {
        Session session = sessionFactory.openSession();
        PhoneEntity phone = null;
        Query query = session.createQuery("FROM PhoneEntity WHERE id = :id");
        query.setParameter("id", id);
        phone = (PhoneEntity) query.getSingleResult();
        session.close();

        return phone;
    }
}
