package com.restaurante.AngularSpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.restaurante.AngularSpringBoot.entity.SubCategories;

@Repository
public interface SubCategoriesRepository extends  JpaRepository<SubCategories, Integer>{

}
