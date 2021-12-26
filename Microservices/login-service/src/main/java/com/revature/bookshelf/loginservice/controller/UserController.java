package com.revature.bookshelf.loginservice.controller;

import com.revature.bookshelf.loginservice.entity.User;
import com.revature.bookshelf.loginservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    //public User saveUser(User user);

}
