package com.revature.bookshelf.cartmicroservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@Document(collection = "cart")
public class Cart  {
    @Id
    private int id;
    private String userId;
    private List<ShopBook> books;

}
