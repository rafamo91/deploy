package com.restaurante.AngularSpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.restaurante.AngularSpringBoot.entity.BasketOrder;
@Repository
public interface BasketOrderRepository extends JpaRepository<BasketOrder, Integer> {

}
