package com.revature.bookshelf;

import com.revature.bookshelf.cartmicroservice.controller.CartController;
import com.revature.bookshelf.cartmicroservice.model.Cart;
import com.revature.bookshelf.cartmicroservice.model.ShopBook;
import com.revature.bookshelf.cartmicroservice.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableMongoRepositories
@EnableDiscoveryClient
public class CartServiceApplication {
	static CartController cartController;
	public static void main(String[] args) {
		SpringApplication.run(CartServiceApplication.class, args);
		Cart cart = new Cart();
		ShopBook sb = new ShopBook(1,"Java For Life",200,"123efrt","Manny","Text","bla/bla/bla",0.99,2);
		ShopBook sb2 = new ShopBook(2,"Java For Life 2",250,"123efrt2","Manny","Text","bla/bla/bla",0.99,2);
		ShopBook sb3 = new ShopBook(3,"Java For Life 3",260,"123efrt3","Manny","Text","bla/bla/bla",0.99,2);
		ShopBook sb4 = new ShopBook(4,"Java For Life 4",270,"123efrt4","Manny","Text","bla/bla/bla",0.99,2);
		List<ShopBook> sks = Arrays.asList(sb,sb2,sb3,sb4);
		cart.setBooks(sks);
		cart.setUserId("12345");
		System.out.println(cart);
	}

}
