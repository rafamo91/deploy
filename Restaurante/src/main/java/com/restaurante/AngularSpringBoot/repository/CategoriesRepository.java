package com.restaurante.AngularSpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restaurante.AngularSpringBoot.entity.Categories;

@Repository
public interface CategoriesRepository extends JpaRepository<Categories, Integer>{

}
