package com.revature.bookshelf.cartandorder.repository;

import com.revature.bookshelf.cartandorder.entity.Cart;
import com.revature.bookshelf.cartandorder.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface OrderRepository extends MongoRepository<Order,Integer> {
//    Optional<Order> findByCartUserId(String userId);
}
