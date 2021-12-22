package com.revature.bookshelf.bookservice.repository;

import com.revature.bookshelf.bookservice.entity.Book;
import org.springframework.data.mongodb.repository.MongoRepository;



public interface BookRepository extends MongoRepository<Book, Integer> {

}
