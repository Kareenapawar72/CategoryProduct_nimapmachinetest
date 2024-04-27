package com.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{
	
	Category save(Category p);
	
	 List<Category> findAll();
	 
	 Optional<Category> findById(Long id);
	 
	 void deleteById(Long id);;

}
