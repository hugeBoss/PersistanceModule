package by.bsuir.book_shop.rest.controllers;

import by.bsuir.book_shop.persistence.models.BookEntity;
import by.bsuir.book_shop.rest.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Huge Boss on 21.11.2016.
 */
@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public List getBooks() throws SQLException {
        return bookService.getAllBooks();
    }

    @PostMapping(value = "/books")
    public ResponseEntity addBook(@RequestBody BookEntity book) throws SQLException {
        bookService.addBook(book);
        return new ResponseEntity(book, HttpStatus.OK);
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity deleteCustomer(@PathVariable Integer id) throws SQLException {

        bookService.removeBook(id);

        return new ResponseEntity(id, HttpStatus.OK);

    }

}
