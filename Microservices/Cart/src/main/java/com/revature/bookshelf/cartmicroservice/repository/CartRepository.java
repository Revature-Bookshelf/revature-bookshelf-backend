package com.revature.bookshelf.cartmicroservice.repository;


import com.revature.bookshelf.cartmicroservice.model.ShopBook;
import com.revature.bookshelf.cartmicroservice.model.Cart;
import org.bson.Document;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface CartRepository extends MongoRepository<Cart,Integer> {
    Optional<Cart> findByUserId(String userId);
}
