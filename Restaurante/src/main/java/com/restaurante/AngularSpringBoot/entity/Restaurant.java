package com.restaurante.AngularSpringBoot.entity;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table (name="restaurant")
public class Restaurant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String email;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_basket")
	private BasketOrder basket;
	
	
	private String address;

	public Restaurant() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public BasketOrder getBasket() {
		return basket;
	}

	public void setBasket(BasketOrder basket) {
		this.basket = basket;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Restaurant(int id, String email, BasketOrder basket, String address) {
		super();
		this.id = id;
		this.email = email;
		this.basket = basket;
		this.address = address;
	}

	@Override
	public String toString() {
		return "Restaurant [id=" + id + ", email=" + email + ", basket=" + basket + ", address=" + address + "]";
	}	
}
