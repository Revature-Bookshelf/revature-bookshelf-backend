package com.revature.bookshelf.loginservice.service;

import com.revature.bookshelf.loginservice.entity.User;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserService{

    void register(User user);
    // for auth-service
//    UserDetails loadUserByUsername(String email);
}