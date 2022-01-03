package com.revature.bookshelf.cartandorder.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShopBook{
    private int id;
    private String title;
    private int pageCount;
    private String isbn;
    private String author;
    private String genre;
    private String imgPath;
    private double price;
    private int quantityRequsted;
}
