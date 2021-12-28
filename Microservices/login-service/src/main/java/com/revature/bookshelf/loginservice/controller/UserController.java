package com.revature.bookshelf.loginservice.controller;

import com.revature.bookshelf.loginservice.controller.payload.HttpResponseBody;
import com.revature.bookshelf.loginservice.entity.User;
import com.revature.bookshelf.loginservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;


    // POST /api/users

    @RequestMapping(
            method = RequestMethod.POST,
            value = "/api/users"
    )
    public ResponseEntity<?> doPost(@RequestBody User user){
        userService.register(user);
        HttpResponseBody responseBody=new HttpResponseBody("user registered");
        return ResponseEntity.status(HttpStatus.CREATED).body(responseBody);
    }


}
