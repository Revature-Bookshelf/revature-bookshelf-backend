package com.revature.bookshelf.displayproducts;

import com.revature.bookshelf.displayproducts.repository.BookRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@EnableMongoRepositories
@EnableDiscoveryClient
public class DisplayProductsApplication {



	public static void main(String[] args) {
//		ConfigurableApplicationContext applicationContext=
		SpringApplication.run(DisplayProductsApplication.class, args);

//		BookRepository bookRepository=applicationContext.getBean(BookRepository.class);
//
//		Book book1=new Book();
//		book1.setId(1);
//		book1.setTitle("War and Peace");
//		book1.setPageCount(300);
//		book1.setAuthor("Tolstoy");
//		book1.setIsbn("3645364");
//		book1.setGenre("novel");
//		book1.setQuantity(3);
//		book1.setPrice(44.00);
//		book1.setImgPath("../assets/images/crimeAndPunishment.jpg");
//
//		bookRepository.save(book1);
//
//		Book book2=new Book();
//		book2.setId(2);
//		book2.setTitle("crime and Punishment");
//		book2.setPageCount(200);
//		book2.setAuthor("Dostoevsky");
//		book2.setIsbn("3646894");
//		book2.setGenre("Philosophical");
//		book2.setQuantity(7);
//		book2.setPrice(37.00);
//
//		bookRepository.save(book2);
//
//		Book book3=new Book();
//		book3.setId(3);
//		book3.setTitle("White");
//		book3.setPageCount(320);
//		book3.setAuthor("Jack London");
//		book3.setIsbn("3246896");
//		book3.setGenre("story");
//		book3.setQuantity(0);
//		book3.setPrice(51.00);
//
//		bookRepository.save(book3);
//
//		Book book4=new Book();
//		book4.setId(4);
//		book4.setTitle("Jane Eyre");
//		book4.setPageCount(320);
//		book4.setAuthor("Harper Lee");
//		book4.setIsbn("4211898");
//		book4.setGenre("story");
//		book4.setQuantity(12);
//		book4.setPrice(21.00);
//
//		bookRepository.save(book4);
//
//		Book book5=new Book();
//		book5.setId(5);
//		book5.setTitle("The Lord of the Rings");
//		book5.setPageCount(320);
//		book5.setAuthor("J. R. R. Tolkien");
//		book5.setIsbn("1562861");
//		book5.setGenre("story");
//		book5.setQuantity(2);
//		book5.setPrice(81.00);
//
//		bookRepository.save(book5);
//
//		Book book6=new Book();
//		book6.setId(6);
//		book6.setTitle("Little Women");
//		book6.setPageCount(320);
//		book6.setAuthor("Louisa May Alcott");
//		book6.setIsbn("1462961");
//		book6.setGenre("story");
//		book6.setQuantity(7);
//		book6.setPrice(19.00);
//
//		bookRepository.save(book6);
//
//		Book book7=new Book();
//		book7.setId(7);
//		book7.setTitle("The Stand");
//		book7.setPageCount(320);
//		book7.setAuthor("Stephen King");
//		book7.setIsbn("7417590");
//		book7.setGenre("story");
//		book7.setQuantity(14);
//		book7.setPrice(33.00);
//
//		bookRepository.save(book7);
//
//		Book book8=new Book();
//		book8.setId(8);
//		book8.setTitle("David Copperfield");
//		book8.setPageCount(320);
//		book8.setAuthor("Charles Dickens");
//		book8.setIsbn("1892561");
//		book8.setGenre("story");
//		book8.setQuantity(27);
//		book8.setPrice(61.00);
//
//		bookRepository.save(book8);



	}





}
