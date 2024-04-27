package com.demo.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Category;
import com.demo.service.CategeryService;

@RestController
@RequestMapping("/api")
public class CategoryContoller {
	
	private static final Logger log = LoggerFactory.getLogger(CategoryContoller.class);
	
	@Autowired
	private CategeryService categeryService;
	
	@PostMapping(value="/category")
	public Category persistCategory(@RequestBody Category category)
	{
		Category cat = null;
		try {
			log.info("Rest request to save category is {}",category);
			cat = categeryService.save(category);
		}catch (Exception e) {
			log.error("Something went wrong in persistCategory {}",e,e.getMessage());
		}
		return cat;
	}
	
	@GetMapping(value="/category")
	public List<Category> find()
	{
		log.info("Getting all categories");
		return categeryService.findAll();
	}
	

	@PutMapping(value="/category/{id}")
	public Long updateCategory(@PathVariable Long id, @RequestBody Category newCategory)
	{
		log.info("Rest request to update category for category {}  is {}",id,newCategory);
		try {
			Optional<Category> cateegoryOptional = categeryService.findById(id);
			if (cateegoryOptional.isPresent()) {
				Category category = cateegoryOptional.get();
				category.setCat(newCategory.getCat());
				category.setName(newCategory.getName());
				category = categeryService.save(category);
				log.info("Category has been updated successfully with ID {}",category.getId());
			}
		}catch (Exception e) {
			log.error("Something went wrong in updateCategory {}",e.getMessage(),e);
		}
		return id;
	}
	
	@DeleteMapping(value="/category/{id}")
	public void  delete(@PathVariable Long id)
	{
		log.info("Rest request to delete by id {}",id);
		try {
			Optional<Category> categoryOptional = categeryService.findById(id);
			if (categoryOptional.isPresent()) {
				categeryService.deleteById(id);
			}
		}catch (Exception e) {
			log.error("Something went wrong in {}",e.getMessage(),e);
		}
	}
	
	@GetMapping(value="/category/{id}")
	public Category findById(@PathVariable Long id)
	{
		Optional<Category> categoryOptional = categeryService.findById(id);
		
		Category category = null;
		
		if (categoryOptional.isPresent()) {
			category = categoryOptional.get();
		}
		return  category;
	}



}
