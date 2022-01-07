package com.revature.bookshelf.displayproducts.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "books")
public class Book {

    @Id
    private int id;
    private String title;
    private int pageCount;
    private Date publishDate;
    private String isbn;
    private String author;
    private String genre;
    private String imgPath;
    private int quantity;
    private double price;

}
