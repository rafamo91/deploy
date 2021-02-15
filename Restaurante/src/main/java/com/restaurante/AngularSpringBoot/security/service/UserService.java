package com.restaurante.AngularSpringBoot.security.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurante.AngularSpringBoot.security.entity.User;
import com.restaurante.AngularSpringBoot.security.repository.UserRepository;

@Service
@Transactional
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public Optional<User> getByEmail(String email){
		
		return userRepository.findByEmail(email);
	}
	
	public boolean existsByEmail(String email) {
		return userRepository.existsByEmail(email);
	}
	
	public void save(User user) {
		userRepository.save(user);
	}
}
