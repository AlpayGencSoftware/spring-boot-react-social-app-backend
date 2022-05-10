package com.socialtime.webservis;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

import com.socialtime.webservis.user.User;
import com.socialtime.webservis.user.UserRepository;
import com.socialtime.webservis.user.UserService;

@SpringBootApplication
public class WebservisApplication {

	public static void main(String[] args) { 
		SpringApplication.run(WebservisApplication.class, args); 
	}
	
	@Bean
	CommandLineRunner createInitialUsers(UserService userService) {
		 return (args)->{
				 User user = new User(); 
				 user.setUsername("user_001");
				 user.setDisplayName("UserDisplayName");
				 user.setPassword("Pas0124566");  
				 userService.save(user); 
		 }; 
	}
	
}
