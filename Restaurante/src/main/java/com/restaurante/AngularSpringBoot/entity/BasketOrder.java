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
@Table (name="basketOrder")
public class BasketOrder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	

	
	@OneToOne
	@JoinColumn(name="id_method")
	private PayMethod payMethod;
	
	@OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Product> product = new ArrayList<>();
	
	@JoinColumn(name="id_address")
	private String address;
	

	public BasketOrder() {
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}




	public PayMethod getPayMethod() {
		return payMethod;
	}


	public void setPayMethod(PayMethod payMethod) {
		this.payMethod = payMethod;
	}


	public List<Product> getProduct() {
		return product;
	}


	public void setProduct(List<Product> product) {
		this.product = product;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public BasketOrder(int id, PayMethod payMethod, List<Product> product, String address) {
		super();
		this.id = id;

		this.payMethod = payMethod;
		this.product = product;
		this.address = address;
	}


	@Override
	public String toString() {
		return "BasketOrder [id=" + id + ", payMethod=" + payMethod + ", product=" + product + ", address=" + address
				+ "]";
	}




	

}
