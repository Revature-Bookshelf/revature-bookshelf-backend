package com.revature.bookshelf.loginservice.repository;

import com.revature.bookshelf.loginservice.entity.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface UserRepository extends ReactiveMongoRepository<User, String> {
        Mono<User> findByEmail(String email);
        //User findByEmail(String email);
}

