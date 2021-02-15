package com.restaurante.AngularSpringBoot.services.jpa;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.restaurante.AngularSpringBoot.entity.Restaurant;
import com.restaurante.AngularSpringBoot.repository.RestaurantRepository;

import com.restaurante.AngularSpringBoot.services.RestaurantService;



@Service
public class RestaurantJPA implements RestaurantService  {
	
	@Autowired
	private RestaurantRepository userRespository;
	
	public RestaurantJPA() {
		
	}

	
	public List<Restaurant> findAll() {
		return userRespository.findAll();
	}
	

	@Override
	public void save(Restaurant user) {
		userRespository.save(user);
	}


	@Override
	public Restaurant loadRestaurant(String email) {
		return userRespository.findByEmail(email);
	}






}
