package com.restaurante.AngularSpringBoot.services;

import com.restaurante.AngularSpringBoot.entity.Restaurant;

public interface RestaurantService {

	
	Restaurant loadRestaurant(String email);

	void save(Restaurant restaurant);

	

}
