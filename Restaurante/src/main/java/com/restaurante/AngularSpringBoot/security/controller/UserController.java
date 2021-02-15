package com.restaurante.AngularSpringBoot.security.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurante.AngularSpringBoot.entity.Product;
import com.restaurante.AngularSpringBoot.entity.Restaurant;
import com.restaurante.AngularSpringBoot.security.dto.JwtDto;
import com.restaurante.AngularSpringBoot.security.dto.LoginUser;
import com.restaurante.AngularSpringBoot.security.dto.NewUser;
import com.restaurante.AngularSpringBoot.security.entity.Role;
import com.restaurante.AngularSpringBoot.security.entity.User;
import com.restaurante.AngularSpringBoot.security.enums.RoleName;
import com.restaurante.AngularSpringBoot.security.jwt.JwtProvider;
import com.restaurante.AngularSpringBoot.security.service.RoleService;
import com.restaurante.AngularSpringBoot.security.service.UserService;
import com.restaurante.AngularSpringBoot.services.RestaurantService;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins="http://localhost:4200")
public class UserController {
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	UserService userService;
	
	@Autowired
	RoleService roleService;

	@Autowired
	JwtProvider jwtProvider;
	
	@Autowired
	RestaurantService restaurantService;

	

	@PostMapping("/login")
	public ResponseEntity<JwtDto> login(@RequestBody LoginUser loginUser){
		System.out.println(loginUser);
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUser.getEmail(), loginUser.getPwd()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtProvider.generateToken(authentication);
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();		
		JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
		
		return new ResponseEntity(jwtDto,HttpStatus.OK);
	}
	
	
	
	
	
}
