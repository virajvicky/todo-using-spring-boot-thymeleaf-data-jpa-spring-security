package com.example.service;


import com.example.Entity.User;
import com.example.repository.UserRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder; 
	
	public void saveUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRole("USER");
		userRepository.save(user);
		
	}
	   
   
}