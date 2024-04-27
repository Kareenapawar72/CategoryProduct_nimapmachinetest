package com.demo.service;

import java.util.List;
import java.util.Optional;

import com.demo.model.Product;

public interface ProductService {
	
	Product save(Product p);

	List<Product> findAll();

	Optional<Product> findById(Long id);

	void deleteById(Long id);

}
