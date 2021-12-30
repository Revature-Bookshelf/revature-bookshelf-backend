package com.revature.bookshelf.loginservice.repository;

import com.revature.bookshelf.loginservice.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {

        User findByEmail(String email);
}

