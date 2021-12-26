package com.revature.bookshelf.loginservice.authenicator.model;


import lombok.Data;

@Data
public class AuthRequest {

    private String username;
    private String password;

}