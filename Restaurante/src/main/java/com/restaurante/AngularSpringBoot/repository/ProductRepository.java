package com.restaurante.AngularSpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restaurante.AngularSpringBoot.entity.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
