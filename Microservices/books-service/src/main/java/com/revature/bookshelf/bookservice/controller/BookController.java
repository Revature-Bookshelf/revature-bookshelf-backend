package com.revature.bookshelf.bookservice.controller;

import com.mongodb.client.model.Collation;
import com.mongodb.connection.Stream;
import com.revature.bookshelf.bookservice.entity.Book;
import com.revature.bookshelf.bookservice.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookRepository bookRepository;


    @GetMapping("/book-list/all")
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/book-list/available")
    public List<Book> getAvailableBooks() {
        return bookRepository.findAllAvailable();
    }

}
