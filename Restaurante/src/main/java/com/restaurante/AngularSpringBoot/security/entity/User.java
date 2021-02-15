package com.restaurante.AngularSpringBoot.security.entity;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import com.restaurante.AngularSpringBoot.entity.Restaurant;
import com.sun.istack.NotNull;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull
	@Column(unique = true)
	private String email;
	@NotNull
	private String pwd;
	
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Restaurant restaurant;
	
	@NotNull
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_rol", joinColumns =  @JoinColumn(name="User_id"),
	inverseJoinColumns = @JoinColumn(name="Rol_id")
	)
	private Set<Role> roles = new HashSet<>();
	
	public User() {
		
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

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	


	public User(@NotNull String email,@NotNull String pwd,@NotNull Set<Role> roles,@NotNull Restaurant restaurant) {
		super();
		this.restaurant=restaurant;
		this.email = email;
		this.pwd = pwd;
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", pwd=" + pwd + ", restaurant=" + restaurant + ", roles="
				+ roles + "]";
	}




	
	
	
	
	
}
