package com.daedalus.shop.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daedalus.shop.models.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
	
//	Optional<Order> findByTitle(String title);
//	Optional<Order> findByType(String type);
//	Optional<Order> findByBrand(String brand);
//	Optional<Order> findByDescriptionContains(String string);
//	Optional<Order> findByPriceLessThanEqual(double price);
//	Optional<Order> findByPriceGreaterThanEqual(double price);
//	Optional<Order> findByPriceBetween(double price1, double price2);
//	Optional<Order> findByIsAvailableTrue();

}
