package com.revature.bookshelf.cartmicroservice.repository;


import com.revature.bookshelf.cartmicroservice.entity.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CartRepository extends MongoRepository<Cart,Integer> {
    Optional<Cart> findByUserId(String userId);
}
