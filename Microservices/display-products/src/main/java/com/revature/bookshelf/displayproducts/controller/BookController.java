package com.revature.bookshelf.displayproducts.controller;


import com.revature.bookshelf.displayproducts.entity.Book;
import com.revature.bookshelf.displayproducts.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@Slf4j
public class BookController {


    @Autowired
    private BookRepository bookRepository;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @GetMapping("/books")
    public List<Book> getBooks() {
        log.info("Listed all books");
        return bookRepository.findAll();
    }

    @GetMapping("/books/available")
    public List<Book> getAvailableBooks() {
        log.info("Listed available books");
        return bookRepository.findAllAvailable();
    }

    @GetMapping("/books/{_genre}")
    public List<Book> getSelectGenre(@PathVariable String _genre) {
        return bookRepository.findSelectGenre(_genre);
    }

    @GetMapping("/genres")
    public List<String> getAllGenres() {
        List<String> genres = new ArrayList<>();
        List<String> allGenres = new ArrayList<>();

        for(int i=0; i<bookRepository.findAllGenres().size(); i++){
            genres.add(i,bookRepository.findAllGenres().get(i));
        }

        for (String genre : genres) {
            allGenres.add(genre.substring(11, genre.lastIndexOf("}") - 1));
        }
        log.info("Listed all genres");
        return allGenres.stream().distinct().collect(Collectors.toList());

    }


}
