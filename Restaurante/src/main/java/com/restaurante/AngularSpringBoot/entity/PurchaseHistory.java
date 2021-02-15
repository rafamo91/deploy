package com.restaurante.AngularSpringBoot.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name="purchase_history")
public class PurchaseHistory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private Date date;
	
	@OneToOne
	@JoinColumn(name="id_user")
	private Restaurant user;
	
	@ManyToOne
	@JoinColumn(name="id_product")
	private Product product;
	
	private double productPrice;
	private String address;
	
	public PurchaseHistory() {
		
	}

	public PurchaseHistory(int id, Date date, Restaurant user, Product product, double productPrice, String address) {
		super();
		this.id = id;
		this.date = date;
		this.user = user;
		this.product = product;
		this.productPrice = productPrice;
		this.address = address;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Restaurant getUser() {
		return user;
	}

	public void setUser(Restaurant user) {
		this.user = user;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "PurchaseHistory [id=" + id + ", date=" + date + ", user=" + user + ", product=" + product
				+ ", productPrice=" + productPrice + ", address=" + address + "]";
	}
	
	
	

}
