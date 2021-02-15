package com.restaurante.AngularSpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restaurante.AngularSpringBoot.entity.PurchaseHistory;
@Repository
public interface PurchaseHistoryRepository  extends JpaRepository<PurchaseHistory, Integer>{

}
