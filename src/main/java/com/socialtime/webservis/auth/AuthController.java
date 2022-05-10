package com.socialtime.webservis.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.socialtime.webservis.configuration.WebservisUserDetails;
import com.socialtime.webservis.error.ApiError;
import com.socialtime.webservis.shared.CurrentUser;
import com.socialtime.webservis.shared.Views;
import com.socialtime.webservis.user.User;
import com.socialtime.webservis.user.UserRepository;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class AuthController {  
	
	@Autowired
	UserRepository userRepository; 
 
	@PostMapping("/api/1.0/auth") 
	@JsonView(Views.Base.class)
	ResponseEntity<?> handleAuthentication(@RequestHeader(name="Authorization") String autorization) {
		 
		String base64Encoded= autorization.split("Basic ")[1];
		String decoded = new String(Base64.getDecoder().decode(base64Encoded));
		String[] parts=decoded.split(":"); // {"user1","password"}
		String username= parts[0];
		 
		User inDB= userRepository.findByUsername(username);
		  
		return ResponseEntity.ok(inDB); 
		 
	}
	
	 

}
