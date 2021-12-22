package com.revature.bookshelf.bookservice;

import com.revature.bookshelf.bookservice.entity.Book;
import com.revature.bookshelf.bookservice.repository.BookRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;



@SpringBootApplication
@EnableMongoRepositories
public class BookServiceApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext=
		SpringApplication.run(BookServiceApplication.class, args);

		BookRepository bookRepository=applicationContext.getBean(BookRepository.class);

		Book book1=new Book();
		book1.setId(1);
		book1.setTitle("War and Peace");
		book1.setPageCount(300);
		book1.setAuthor("Tolstoy");
		book1.setISBN("3645364");
		book1.setGenre("novel");
		book1.setQuantity(3);

		bookRepository.save(book1);

		Book book2=new Book();
		book2.setId(2);
		book2.setTitle("crime and Punishment");
		book2.setPageCount(200);
		book2.setAuthor("Dostoevsky");
		book2.setISBN("3646894");
		book2.setGenre("Philosophical");
		book2.setQuantity(7);

		bookRepository.save(book2);
	}

}
