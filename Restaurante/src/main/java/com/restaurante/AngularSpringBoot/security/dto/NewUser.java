package com.restaurante.AngularSpringBoot.security.dto;

import java.util.HashSet;
import java.util.Set;

import com.restaurante.AngularSpringBoot.entity.Restaurant;

public class NewUser {
	
	
	private String email;
	private String pwd;
	private String address;
	private Set<String> roles = new HashSet<>();
	
	

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
	public Set<String> getRoles() {
		return roles;
	}
	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	
	
	
}
