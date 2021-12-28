package com.revature.bookshelf.loginservice.service;

import com.revature.bookshelf.loginservice.entity.User;

public interface UserService{
    // THIS REGISTER SERVICE SHOULD NOT BE USED FOR DEVELOPMENT, JUST USED FOR TESTING
    void register(User user);
}