package com.restaurante.AngularSpringBoot.services;

import java.util.List;

import com.restaurante.AngularSpringBoot.entity.Product;

public interface ProductService {

	public List<Product> findAll();

	public void save(Product p);

}
