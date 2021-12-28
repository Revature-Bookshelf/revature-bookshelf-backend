package com.revature.bookshelf.cartmicroservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShopBook{
    private int id;
    private String title;
    private int pageCount;
    private String ISBN;
    private String author;
    private String genre;
    private String imgPath;
    private double price;
    private int quantityRequsted;
}
