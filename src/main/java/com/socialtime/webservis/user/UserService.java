package com.socialtime.webservis.user; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserService { 
	
   	
   UserRepository userRepository;
   PasswordEncoder passwordEncoder;
	  
   	  @Autowired
	  public UserService(UserRepository userRepository,  PasswordEncoder passwordEncoder) { 
			this.userRepository = userRepository;
			this.passwordEncoder= passwordEncoder;
	  }

	 public void save(User user) { 
		 user.setPassword(this.passwordEncoder.encode(user.getPassword()));
		 userRepository.save(user);
	 }
}
