package com.restaurante.AngularSpringBoot.dto;



public class NewProduct {
	
	private String name;
	private int units;
	private double price;
	private String category;
	private String subCategory;
	private String description;
	
	public NewProduct() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public NewProduct(String name, int units, double price, String category, String subCategory, String description) {
		super();
		this.name = name;
		this.units = units;
		this.price = price;
		this.category = category;
		this.subCategory = subCategory;
		this.description = description;
	}

	@Override
	public String toString() {
		return "NewProduct [name=" + name + ", units=" + units + ", price=" + price + ", category=" + category
				+ ", subCategory=" + subCategory + ", description=" + description + "]";
	}

}
