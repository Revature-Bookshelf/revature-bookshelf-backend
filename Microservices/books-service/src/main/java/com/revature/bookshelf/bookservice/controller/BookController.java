package com.revature.bookshelf.bookservice.controller;


import com.revature.bookshelf.bookservice.entity.Book;
import com.revature.bookshelf.bookservice.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class BookController {

    @Autowired
    private BookRepository bookRepository;


    @GetMapping("/books")
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/books/available")
    public List<Book> getAvailableBooks() {
        return bookRepository.findAllAvailable();
    }

}
