package com.revature.bookshelf.loginservice.repository;

import com.revature.bookshelf.loginservice.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    User findByEmail(String username);
}
