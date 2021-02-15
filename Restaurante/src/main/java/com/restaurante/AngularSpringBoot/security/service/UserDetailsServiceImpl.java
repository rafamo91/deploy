package com.restaurante.AngularSpringBoot.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.restaurante.AngularSpringBoot.security.entity.User;
import com.restaurante.AngularSpringBoot.security.entity.UserMain;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user =null;
		try {
			user = userService.getByEmail(email).get();
		} catch (Exception e) {
			System.out.println(e);
		}
		
	
		return UserMain.build(user);
	}

}
