package com.restaurante.AngularSpringBoot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="categories")
public class Categories {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(unique = true)
	private String category;
	
	
	
	public Categories() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategorie() {
		return category;
	}

	public void setCategorie(String categorie) {
		this.category = categorie;
	}

	@Override
	public String toString() {
		return "Categories [id=" + id + ", categorie=" + category + "]";
	}

	public Categories(int id, String categorie) {
		super();
		this.id = id;
		this.category = categorie;
	}
	
	
	
}
