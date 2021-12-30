package com.revature.bookshelf.cartmicroservice.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Data
@NoArgsConstructor
@Document(collection = "cart")
public class Cart  {
    @Id
    private String _id;
    private String userId;
    private List<ShopBook> books;

}
