package com.restaurante.AngularSpringBoot.entity;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name="pay_method")
public class PayMethod {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@ManyToOne
	@JoinColumn(name="id_user")
	private Restaurant user;
	private String payMethod;
	private String address;
	
	public PayMethod() {
		
	}

	public Restaurant getUser() {
		return user;
	}

	public void setUser(Restaurant user) {
		this.user = user;
	}

	public String getPayMethod() {
		return payMethod;
	}

	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}


	public PayMethod(int id, Restaurant user, String payMethod) {
		super();
		this.id = id;
		this.user = user;
		this.payMethod = payMethod;
	}

	@Override
	public String toString() {
		return "PayMethod [id=" + id + ", user=" + user + ", payMethod=" + payMethod + ", address=" + address + "]";
	}
	
	
	
}
