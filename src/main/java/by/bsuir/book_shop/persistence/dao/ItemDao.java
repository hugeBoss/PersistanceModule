package by.bsuir.book_shop.persistence.dao;

import by.bsuir.book_shop.persistence.models.Model;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Huge Boss on 02.11.2016.
 */
public interface ItemDao<T extends Model> {

    public void add(T elem) throws SQLException;
    public void delete(int id) throws SQLException;
    public void update(int id, T elem) throws SQLException;
    public List<T> getAll() throws SQLException;
    public T getById(int id) throws SQLException;

}
