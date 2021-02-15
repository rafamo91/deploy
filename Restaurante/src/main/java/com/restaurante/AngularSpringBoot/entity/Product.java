package com.restaurante.AngularSpringBoot.entity;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name="product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_category")
	private Categories categories;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_subCategory")
	private SubCategories subCategories;
	private String description;
	private String image;
	private double price;
	private int units;

	
	public Product() {
		
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}






	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getImage() {
		return image;
	}



	public void setImage(String image) {
		this.image = image;
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}



	public int getUnits() {
		return units;
	}



	public void setUnits(int units) {
		this.units = units;
	}



	public Categories getCategories() {
		return categories;
	}



	public void setCategories(Categories categories) {
		this.categories = categories;
	}



	public SubCategories getSubCategories() {
		return subCategories;
	}



	public void setSubCategories(SubCategories subCategories) {
		this.subCategories = subCategories;
	}



	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", categories=" + categories + ", subCategories="
				+ subCategories + ", description=" + description + ", image=" + image + ", price=" + price + ", units="
				+ units + "]";
	}










	
}
