package com.revature.bookshelf.bookservice.repository;
import com.revature.bookshelf.bookservice.entity.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;


public interface BookRepository extends MongoRepository<Book, Integer> {

    @Query(  "  {  quantity: {$gt: 0 }  }    "  )
    List<Book> findAllAvailable();
}
