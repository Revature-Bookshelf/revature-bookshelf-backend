package com.revature.bookshelf.loginservice.repository;

import com.revature.bookshelf.loginservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByEmail(String username);
    }

