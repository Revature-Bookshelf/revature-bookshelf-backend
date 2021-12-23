package com.revature.bookshelf.bookservice.entity;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "books")
public class Book {

    private int id;
    private String title;
    private int pageCount;
    private String ISBN;
    private String author;
    private String genre;
    private String imgPath;
    private int quantity;

}
