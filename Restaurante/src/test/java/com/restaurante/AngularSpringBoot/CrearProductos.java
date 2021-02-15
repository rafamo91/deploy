package com.restaurante.AngularSpringBoot;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.restaurante.AngularSpringBoot.services.jpa.ProductJPA;

@SpringBootTest
public class CrearProductos {
	
	@Autowired
	private ProductJPA repop;
	
	
	

	@Test
	public void addProducts() {
		/*
		Product p = new Product();
		p.setName("Hamburguesa");
		p.setPrice(200);
		p.setImage("Imagen");
		p.setType("Comida");
		p.setDescription("Ejemplo");
		repop.save(p);
		Product p1 = new Product();
		p1.setName("Pizza");
		p1.setPrice(300);
		p1.setImage("Imagen");
		p1.setCategories("Comida 3");
		p1.setDescription("Ejemplo 3");
		repop.save(p1);
		*/
	}
}
