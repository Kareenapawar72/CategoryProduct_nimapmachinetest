package com.demo.service;

import java.util.List;
import java.util.Optional;

import com.demo.model.Category;

public interface CategeryService {
	
	Category save(Category p);
	
	 List<Category> findAll();
	 
	 Optional<Category> findById(Long id);
	 
	 void deleteById(Long id);


}
