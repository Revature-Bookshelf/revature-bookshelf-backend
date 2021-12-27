package com.revature.repository;

import com.revature.entity.User;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@EnableMongoRepositories
public interface UserRepository extends MongoRepository<User, ObjectId>{
   User findByEmail(String email);
}
