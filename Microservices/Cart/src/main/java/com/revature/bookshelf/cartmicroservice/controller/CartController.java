package com.revature.bookshelf.cartmicroservice.controller;

import com.revature.bookshelf.cartmicroservice.entity.Cart;
import com.revature.bookshelf.cartmicroservice.repository.CartRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@RestController
@Slf4j
public class CartController {
//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    private CartRepository cartRepository;

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/cart/{userId}"
    )
    public ResponseEntity<?> viewCartByUserId(@PathVariable String userId){
        Optional<Cart> optCart=cartRepository.findByUserId(userId);
        if(optCart.isEmpty()){
            Cart cart = new Cart();
            cart.setUserId(userId);
            cartRepository.save(cart);
            cart = cartRepository.findByUserId(userId).stream().findFirst().get();
            log.info("inside viewCartByUserId in controller because cart dont exist for that user");
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(cart);
        } else{
            Cart crt= optCart.stream().findFirst().get();
            log.info("inside viewCartByUserId in controller");
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(crt);
        }
    }

    @RequestMapping(
            method = RequestMethod.POST,
            value = "/cart/add",
            consumes = {"application/json"}
    )
    public ResponseEntity<?> addCart(@RequestBody Cart cart){
        cartRepository.save(cart);
        log.info("inside add cart");
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(cart);
    }

//     @PostMapping("/cart/books/{bookId}")
//    public void addBookToExistingCartByUserId(@PathVariable String bookId,@RequestBody String userId){
//        // Send as request to BookService to get book details
////         ShopBook sb =
////      send token to user service to get userId
////      String userId = request to restTemplate(userServiceUrl, String.class)
//
////        Optional<Cart> optionalCart = cartRepository.findByUserId(userId);
////        if(optionalCart.isEmpty()){
////            System.out.println("User with Id : "+ userId + "doesn't have a cart yet");
////        } else{
////            Cart cart = optionalCart.stream().findFirst().get();
////            cart.getBooks().add(sb); // assuming cart already has some books in it otherwise error will occur
////            System.out.println("Book was added successfully");
////        }
//     }
@RequestMapping(
        method = RequestMethod.PUT,
        value = "/cart/empty",
        consumes = {"application/json"}
)
    public ResponseEntity<?> emptyCart(@RequestBody Cart cart){
        Cart temp = new Cart();
        temp = cart;
        cartRepository.delete(cart);
        temp.getBooks().clear();
        cartRepository.save(temp);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(temp);
    }
}
