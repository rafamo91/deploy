package com.restaurante.AngularSpringBoot.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restaurante.AngularSpringBoot.dto.NewProduct;
import com.restaurante.AngularSpringBoot.entity.BasketOrder;
import com.restaurante.AngularSpringBoot.entity.Categories;
import com.restaurante.AngularSpringBoot.entity.Product;
import com.restaurante.AngularSpringBoot.entity.Restaurant;
import com.restaurante.AngularSpringBoot.entity.SubCategories;
import com.restaurante.AngularSpringBoot.security.dto.NewUser;
import com.restaurante.AngularSpringBoot.security.entity.Role;
import com.restaurante.AngularSpringBoot.security.entity.User;
import com.restaurante.AngularSpringBoot.security.enums.RoleName;
import com.restaurante.AngularSpringBoot.security.jwt.JwtProvider;
import com.restaurante.AngularSpringBoot.security.service.RoleService;
import com.restaurante.AngularSpringBoot.security.service.UserService;
import com.restaurante.AngularSpringBoot.services.ProductService;
import com.restaurante.AngularSpringBoot.services.RestaurantService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class MainController {
	

	@Autowired
	ProductService productService;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	UserService userService;
	
	@Autowired
	RoleService roleService;

	@Autowired
	JwtProvider jwtProvider;
	
	@Autowired
	RestaurantService restaurantService;
	
	
	@PostMapping("/registrer")
	public ResponseEntity<String> newUser( @RequestBody NewUser newUser){
			
		if(userService.existsByEmail(newUser.getEmail())) {
			return new ResponseEntity<String>("Its already exists",HttpStatus.BAD_REQUEST);
		}else {
			System.out.println(newUser);
			Set<Role> roles = new HashSet<>();
			roles.add(roleService.getByRoleName(RoleName.ROLE_USER).get());
			if(newUser.getRoles().contains("admin")) {
				roles.add(roleService.getByRoleName(RoleName.ROLE_ADMIN).get());
			}
			
			List<Product> product = new ArrayList<>();
			BasketOrder basket = new BasketOrder();
			basket.setProduct(product);
			basket.setAddress(newUser.getAddress());
			
			
			Restaurant restaurant = new Restaurant();
			restaurant.setAddress(newUser.getAddress());
			restaurant.setEmail(newUser.getEmail());
			User user = new User(newUser.getEmail(),passwordEncoder.encode(newUser.getPwd()),roles,restaurant);

			restaurant.setBasket(basket);
			

			userService.save(user);
			return new ResponseEntity<String>(HttpStatus.ACCEPTED);
		}
	}
	

	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getProducts() {
		return ResponseEntity.ok(productService.findAll());
	}
	
	@PostMapping("/payBasket")
	public ResponseEntity<String>payBasket(@RequestBody Restaurant restaurant) {
		restaurantService.save(restaurant);
		return new ResponseEntity<String>(HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/loadRestaurant")
	public ResponseEntity<Restaurant>loadRestaurant(@RequestBody String email) {
		Restaurant restaurant = restaurantService.loadRestaurant(email);
		
		return new ResponseEntity<Restaurant>(restaurant,HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/addProduct")
	public ResponseEntity<String> addProduct(@RequestBody NewProduct newProduct) {
		
		Categories category = new Categories();
		category.setCategorie(newProduct.getCategory());
		
		SubCategories subCategory = new SubCategories();
		subCategory.setSubCategory(newProduct.getSubCategory());
		subCategory.setCategory(category);
		
		
		
		
		Product product = new Product();
		product.setName(newProduct.getName());
		
		
		product.setDescription(newProduct.getDescription());
		product.setPrice(newProduct.getPrice());
		product.setUnits(newProduct.getUnits());
		product.setCategories(category);
		product.setSubCategories(subCategory);
		
		System.out.println(product);
		
		//productService.save(product);
		
		return new ResponseEntity<String>(HttpStatus.ACCEPTED);
	}
	

}
