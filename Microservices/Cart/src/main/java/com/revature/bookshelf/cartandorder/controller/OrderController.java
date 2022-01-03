package com.revature.bookshelf.cartandorder.controller;

import com.revature.bookshelf.cartandorder.entity.Cart;
import com.revature.bookshelf.cartandorder.entity.Order;
import com.revature.bookshelf.cartandorder.repository.CartRepository;
import com.revature.bookshelf.cartandorder.repository.OrderRepository;
import com.revature.bookshelf.cartandorder.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;
import static org.springframework.data.mongodb.core.query.Criteria.where;


@RestController
@Slf4j
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderService orderService;

    @PostMapping("/add")
    public ResponseEntity<?> addOrder(@RequestBody Cart cart){
        Order order = new Order();
        order.setCartId(cart.getId());
        order.setTotal(orderService.calculateTotal(cart));
        orderRepository.save(order);
        log.info("inside add order");
//        Order order1= orderRepository.findAll().stream().filter(o-> Objects.equals(o.getId(), order.getId())).findFirst().get();
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(order);
    }

//    @RequestMapping(
//            method = RequestMethod.GET,
//            value = "/cart/{userId}"
//    )
//    public ResponseEntity<?> viewOrder(String userId){
//        Order order = orderRepository.findByCartUserId(userId).stream().findFirst().get();
//        return ResponseEntity
//                .status(HttpStatus.ACCEPTED)
//                .body(order);
//    }

//    public ResponseEntity<?> cancelOrder(){
//
//    }

}
