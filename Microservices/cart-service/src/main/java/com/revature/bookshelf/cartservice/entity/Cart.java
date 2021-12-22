package com.revature.bookshelf.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collation = "cart")
public class Cart {
    private int id;
    private List<Object> products;
    private String user_id;

}
