package by.bsuir.book_shop.rest.services;


import by.bsuir.book_shop.persistence.dao.BookDao;
import by.bsuir.book_shop.persistence.models.BookEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Huge Boss on 21.11.2016.
 */
public class BookService implements IBookService {

    @Autowired
    private BookDao bookDao;

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public void addBook(BookEntity book) throws SQLException {
        bookDao.add(book);
    }

    public List<BookEntity> getAllBooks() throws SQLException {
        return bookDao.getAll();
    }

    public void removeBook(int id) throws SQLException {
        bookDao.delete(id);
    }
}
