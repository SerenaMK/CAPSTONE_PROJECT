package com.daedalus.shop.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daedalus.shop.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	List<Product> findByTitleContainsIgnoreCase(String title);
	List<Product> findByTypeIgnoreCase(String type);
	List<Product> findByBrandIgnoreCase(String brand);
	List<Product> findByDescriptionContainsIgnoreCase(String string);
	List<Product> findByPriceLessThanEqual(double price);
	List<Product> findByPriceGreaterThanEqual(double price);
	List<Product> findByPriceBetween(double price1, double price2);
	List<Product> findByIsAvailableTrue();
	List<Product> findByCategoriesNameIgnoreCase(String category);

}
