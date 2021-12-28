package com.revature.bookshelf.cartmicroservice.controller;

import com.revature.bookshelf.cartmicroservice.model.Cart;
import com.revature.bookshelf.cartmicroservice.model.ShopBook;
import com.revature.bookshelf.cartmicroservice.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@RestController
@RequestMapping("/")
public class CartController {

    @Autowired
    private CartRepository cartRepository;

    @GetMapping("/cart/{userId}")
    public Cart viewCartByUserId(@PathVariable String userId){
        Optional<Cart> optCart=cartRepository.findByUserId(userId);
        if(optCart.isEmpty()){
            Cart cart = new Cart();
            cart.setUserId(userId);
            cartRepository.save(cart);
            return cartRepository.findByUserId(userId).stream().findFirst().get();
        } else{
            return optCart.stream().findFirst().get();
        }
    }

    @PostMapping("/cart/add")
    public void addCart(@RequestBody Cart cart){
        cartRepository.save(cart);
        System.out.println("cart was added successfully");
    }
     @PostMapping("/cart/books/{bookId}")
    public void addBookToExistingCartByUserId(@PathVariable String bookId,@RequestBody String userId){
        // Send as request to BookService to get book details
         ShopBook sb =
//      send token to user service to get userId
//      String userId = request to restTemplate(userServiceUrl, String.class)

        Optional<Cart> optionalCart = cartRepository.findByUserId(userId);
        if(optionalCart.isEmpty()){
            System.out.println("User with Id : "+ userId + "doesn't have a cart yet");
        } else{
            Cart cart = optionalCart.stream().findFirst().get();
            cart.getBooks().add(sb); // assuming cart already has some books in it otherwise error will occur
            System.out.println("Book was added successfully");
        }
     }
    @PostMapping("/cart/empty")
    public Cart emptyCart(@RequestBody Cart cart){
        Optional<Cart> tempOpt = cartRepository.findByUserId(cart.getUserId());
        Cart temp = tempOpt.stream().findFirst().get();
        cartRepository.save(temp);
        return temp;
    }
}
