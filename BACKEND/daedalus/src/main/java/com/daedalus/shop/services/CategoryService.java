package com.daedalus.shop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daedalus.shop.models.Category;
import com.daedalus.shop.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	CategoryRepository repo;
	
	public Category createCategory(Category c) {
		repo.save(c);
		System.out.println("Category added");
		return c;
	}
	
	public Category updateCategory(Category c) {
		repo.save(c);
		System.out.println("Category updated");
		return c;
	}
	
	public String deleteCategory(Long id) {
		Category c = repo.findById(id).get();
		repo.delete(c);
		System.out.println("Category deleted");
		return "Category deleted";
	}
	
	public Category getCategoryById(Long id) {
		return repo.findById(id).get();
	}
	
	public List<Category> getAllCategories() {
		return repo.findAll();
	}
	
	// CUSTOM ONES
	public Category getCategoryByName(String s) {
		return repo.findByName(s).get();
	}

}
