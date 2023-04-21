package com.daedalus.shop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daedalus.shop.models.Product;
import com.daedalus.shop.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository repo;
	
	public Product createProduct(Product p) {
		repo.save(p);
		System.out.println("Product added");
		return p;
	}
	
	public Product updateProduct(Product p) {
		repo.save(p);
		System.out.println("Product updated");
		return p;
	}
	
	public String deleteProduct(Long id) {
		Product p = repo.findById(id).get();
		repo.delete(p);
		System.out.println("Product deleted");
		return "Product deleted";
	}
	
	public Product getProductById(Long id) {
		return repo.findById(id).get();
	}
	
	public List<Product> getAllProducts() {
		return repo.findAll();
	}
	
	// CUSTOM ONES	
	public List<Product> getProductByTitle(String s) {
		return repo.findByTitleContainsIgnoreCase(s);
	}
	
	public List<Product> getProductByType(String s) {
		return repo.findByTypeIgnoreCase(s);
	}
	
	public List<Product> getProductByBrand(String s) {
		return repo.findByBrandIgnoreCase(s);
	}
	
	public List<Product> getProductByDescriptionContains(String s) {
		return repo.findByDescriptionContainsIgnoreCase(s);
	}
	
	public List<Product> getProductByPriceLessThan(double p) {
		return repo.findByPriceLessThanEqual(p);
	}
	
	public List<Product> getProductByPriceMoreThan(double p) {
		return repo.findByPriceGreaterThanEqual(p);
	}
	
	public List<Product> getProductByPriceBetween(double min, double max) {
		return repo.findByPriceBetween(min, max);
	}
	
	public List<Product> getProductByIsAvailable() {
		return repo.findByIsAvailableTrue();
	}
	
	public List<Product> getProductsByCategoryName(String c) {
		return repo.findByCategoriesNameIgnoreCase(c);
	}

}
