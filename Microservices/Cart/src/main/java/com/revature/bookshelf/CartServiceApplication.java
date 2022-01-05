package com.revature.bookshelf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
@EnableDiscoveryClient
public class CartServiceApplication {
//	static CartController cartController;
	public static void main(String[] args) {
//		OrderService orderService=new OrderService();
		SpringApplication.run(CartServiceApplication.class, args);
//		Cart cart = new Cart();
//		ShopBook sb = new ShopBook(1,"Java For Life",200,"123efrt","Manny","Text","bla/bla/bla",1.99,2);
//		ShopBook sb2 = new ShopBook(2,"Java For Life 2",250,"123efrt2","Manny","Text","bla/bla/bla",0.99,2);
//		ShopBook sb3 = new ShopBook(3,"Java For Life 3",260,"123efrt3","Manny","Text","bla/bla/bla",3.99,2);
//		ShopBook sb4 = new ShopBook(4,"Java For Life 4",270,"123efrt4","Manny","Text","bla/bla/bla",5.99,2);
//		List<ShopBook> sks = Arrays.asList(sb,sb2,sb3,sb4);
//		cart.setBooks(sks);
//		String tomId= "1234trd";
//		cart.setUserId(tomId);
//		Order order = new Order("1",cart);
//		System.out.println("order is : "+ order);
//		System.out.println("Order Total is :  "+ orderService.calculateTotal(order));
	}
//	@Bean
//	public Docket api() {
//		return new Docket(DocumentationType.SWAGGER_2)
//				.select()
//				.apis(RequestHandlerSelectors.basePackage("com.revature.bookshelf"))
//				.paths(PathSelectors.any())
//				.build();
//	}
//	@Bean
//	public ApiInfo apiInfo() {
//		final ApiInfoBuilder builder = new ApiInfoBuilder();
//		builder.title("My Application API through Swagger UI").version("1.0").license("(C) Copyright Test")
//				.description("List of all the APIs of My Application App through Swagger UI");
//		return builder.build();
//	}

}
