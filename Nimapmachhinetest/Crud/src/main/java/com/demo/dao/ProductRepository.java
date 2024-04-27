package com.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.demo.model.Category;
import com.demo.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	 Product save(Product p);
	
	 List<Product> findAll();
	 
	 Optional<Product> findById(Long id);
	 
	 void deleteById(Long id);
	 
	 
	 }
