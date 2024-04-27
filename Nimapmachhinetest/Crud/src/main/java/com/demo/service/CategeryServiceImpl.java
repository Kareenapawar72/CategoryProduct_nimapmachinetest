package com.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.CategoryRepository;
import com.demo.model.Category;

import jakarta.transaction.Transactional;

@Service
public class CategeryServiceImpl implements CategeryService {
	
	@Autowired
	private CategoryRepository cd;

	@Override
	public Category save(Category c) {
		return cd.save(c);
	}

	@Override
	public List<Category> findAll() {
		return cd.findAll();
	}

	@Override
	public Optional<Category> findById(Long id) {
		return cd.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		 cd.deleteById(id);
	}

	


}
