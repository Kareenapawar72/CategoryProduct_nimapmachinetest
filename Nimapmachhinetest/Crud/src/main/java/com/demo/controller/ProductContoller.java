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
import com.demo.model.Product;
import com.demo.service.ProductService;


@RestController
@RequestMapping("/api")
public class ProductContoller {
	
	private static final Logger log = LoggerFactory.getLogger(ProductContoller.class);
	
	@Autowired
	private ProductService productService;
	
	@PostMapping(value="/product")
	public Product persistProduct(@RequestBody Product prod)
	{
		log.info("Rest request to save producr is {}",prod);
		Product product = null;
		try {
			product = productService.save(prod);
			log.info("Product has been saved with ID {}",product.getId());
		}catch (Exception e) {
			log.error("Something went erong in persistProduct {}",e.getMessage(),e);
		}
		return prod;
	}
	
	@GetMapping(value="/product")
	public List<Product> find()
	{
		return productService.findAll();
	}
	

	@PutMapping(value="/product/{id}")
	public Long updateProduct(@PathVariable Long id, @RequestBody Product newProduct)
	{
		log.info("Rest request to update product for product {}  is {}",id,newProduct);
		try {
			Optional<Product> productOptional = productService.findById(id);
			if (productOptional.isPresent()) {
				Product p = productOptional.get();
				p.setBrand(newProduct.getBrand());
				p.setName(newProduct.getName());
				p.setPrice(newProduct.getPrice());
				p = productService.save(p);
				log.info("Product has been updated successfully with ID {}",p.getId());
			}
		}catch (Exception e) {
			log.error("Something went wrong in updateProduct {}",e.getMessage(),e);
		}
		return id;
	}
	
	@DeleteMapping(value="/product/{id}")
	public void delete(@PathVariable Long id) {
	log.info("Rest request to delete by id {}",id);
	try {
		Optional<Product> productOptional = productService.findById(id);
		if (productOptional.isPresent()) {
			productService.deleteById(id);
		}
	}catch (Exception e) {
		log.error("Something went wrong in {}",e.getMessage(),e);
	}
	}
	
	@GetMapping(value="/product/{id}")
	public Product findById(@PathVariable Long id)
	{
		Optional<Product> productOptional = productService.findById(id);
		
		Product product = null;
		
		if (productOptional.isPresent()) {
			product = productOptional.get();
		}
		return product;
	}


}
