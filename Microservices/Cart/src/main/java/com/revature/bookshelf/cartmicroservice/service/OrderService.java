package com.revature.bookshelf.cartmicroservice.service;

import com.revature.bookshelf.cartmicroservice.entity.Order;

public class OrderService {
    public double calculateTotal(Order order){
       double total= order.getCart().getBooks()
                .stream()
                .mapToDouble(b->b.getPrice()*b.getQuantityRequsted())
                .sum();
       return total;
    }

}
