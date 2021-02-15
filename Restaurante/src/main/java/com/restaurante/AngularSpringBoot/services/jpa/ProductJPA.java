package com.restaurante.AngularSpringBoot.services.jpa;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.restaurante.AngularSpringBoot.entity.Product;
import com.restaurante.AngularSpringBoot.repository.ProductRepository;

import com.restaurante.AngularSpringBoot.services.ProductService;

@Service
public class ProductJPA implements ProductService{
	
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private ProductRepository prRep;
	

	public void save(Product p) {
		prRep.save(p);
	}
	
	@Transactional(readOnly = false)
	public void actualizar(Product p) {
		em.merge(p);
	}

	public Product findById(int id) {
		return (Product) em.createQuery("from Product where id='"+id+"'").getSingleResult();
	}
	
	public List<String> findByBasket(int id) {
		return em.createQuery("select u from tablahibubrida u").getResultList();
	}

	@Override
	public List<Product> findAll() {
		return prRep.findAll();
	}

}
