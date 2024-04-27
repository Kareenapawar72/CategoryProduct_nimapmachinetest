package com.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.ProductRepository;
import com.demo.model.Category;
import com.demo.model.Product;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository pd;

	@Override
	public Product save(Product p) {
		return pd.save(p);
	}

	@Override
	public List<Product> findAll() {
		return pd.findAll();
	}

	@Override
	public Optional<Product> findById(Long id) {
		return pd.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		 pd.deleteById(id);
	}

}
