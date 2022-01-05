package com.revature.bookshelf.displayproducts.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
<<<<<<< Updated upstream:Microservices/display-products/src/main/java/com/revature/bookshelf/displayproducts/entity/Book.java
import org.springframework.data.annotation.Id;
=======
import lombok.NoArgsConstructor;
>>>>>>> Stashed changes:Microservices/books-service/src/main/java/com/revature/bookshelf/bookservice/entity/Book.java
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
