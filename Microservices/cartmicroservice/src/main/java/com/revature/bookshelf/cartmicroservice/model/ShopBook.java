package com.revature.bookshelf.cartmicroservice.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
public class ShopBook {
    private String name;
    private int quantity;
}
