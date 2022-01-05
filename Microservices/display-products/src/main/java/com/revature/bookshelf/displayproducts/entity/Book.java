package com.revature.bookshelf.displayproducts.entity;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "books")
public class Book {

    @Id
    private int id;
    private String title;
    private int pageCount;
    private String isbn;
    private String author;
    private String genre;
    private String imgPath;
    private int quantity;
    private double price;

}
