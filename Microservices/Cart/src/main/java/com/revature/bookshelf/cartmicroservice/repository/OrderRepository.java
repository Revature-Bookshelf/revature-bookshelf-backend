package com.revature.bookshelf.cartmicroservice.repository;

import com.revature.bookshelf.cartmicroservice.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order,Integer> {
}
