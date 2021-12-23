package com.revature.bookshelf.cartservice.repository;


import org.bson.Document;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CartRepository extends MongoRepository<Document,Integer> {
    public List<Object> findProductsByUserId(String userId);
}
