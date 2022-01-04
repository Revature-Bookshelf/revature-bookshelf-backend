package com.revature.bookshelf.loginservice;

import com.revature.bookshelf.loginservice.entity.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import com.revature.bookshelf.loginservice.controller.UserController;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication
@EnableConfigurationProperties
public class LoginServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginServiceApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder bcryptPasswordEncoder()
	{
		return  new BCryptPasswordEncoder();
	}

	@Bean
	public SpringApplicationContext SpringApplicationContext()
	{
		return  new SpringApplicationContext();
	}

//	@Bean
//	public AppProperties AppProperties()
//	{
//		return  new AppProperties();
//	}

}
