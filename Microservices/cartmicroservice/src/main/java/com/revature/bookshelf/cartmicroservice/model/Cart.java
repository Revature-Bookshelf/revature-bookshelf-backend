package com.revature.bookshelf.cartmicroservice.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Data
@Document(collection = "cart")
public class Cart {
    @Id
    private int id;
    private int bookId;
    private List<ShopBook> books;
    private String userId;
//    private int quantity;
}
