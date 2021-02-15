package com.restaurante.AngularSpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restaurante.AngularSpringBoot.entity.PayMethod;
@Repository
public interface PayMethodRepository  extends JpaRepository<PayMethod, Integer> {

}
