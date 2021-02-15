package com.restaurante.AngularSpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restaurante.AngularSpringBoot.entity.Restaurant;

@Repository
public interface RestaurantRepository  extends JpaRepository<Restaurant, Integer>{
	
	
	Restaurant findByEmail(String email);
}
