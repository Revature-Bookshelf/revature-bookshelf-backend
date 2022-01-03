package com.revature.bookshelf.cartandorder.service;

import com.revature.bookshelf.cartandorder.entity.Cart;
import com.revature.bookshelf.cartandorder.entity.Order;
import com.revature.bookshelf.cartandorder.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    public double calculateTotal(Cart cart){
       double total= cart.getBooks()
                .stream()
                .mapToDouble(b->b.getPrice()*b.getQuantityRequsted())
                .sum();
       return total;
    }

}
