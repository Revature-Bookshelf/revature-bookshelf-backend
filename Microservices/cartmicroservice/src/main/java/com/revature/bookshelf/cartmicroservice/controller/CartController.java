package com.revature.bookshelf.cartmicroservice.controller;

import com.revature.bookshelf.cartmicroservice.model.Cart;
import com.revature.bookshelf.cartmicroservice.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/")
public class CartController {

    @Autowired
    private CartRepository cartRepository;

    @GetMapping("/cart-service/{userId}")
    public Optional<Cart> getCartByUserId(@PathVariable String userId){
        return cartRepository.findByUserId(userId);
    }

    @PostMapping("/cart-service")
    public String addCart(Cart cart){
        cartRepository.save(cart);
        return "Cart was added successfully";
    }
}
