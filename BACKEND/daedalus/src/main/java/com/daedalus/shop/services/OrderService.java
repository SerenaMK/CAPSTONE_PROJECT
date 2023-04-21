package com.daedalus.shop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daedalus.shop.models.Cart;
import com.daedalus.shop.models.Order;
import com.daedalus.shop.models.OrderHistory;
import com.daedalus.shop.repositories.OrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {
	
//	@Autowired
	final OrderRepository repo;
	final CartService cartService;
	final OrderHistoryService ohService;
	
	public Order createOrder(Order o) {
		repo.save(o);
		System.out.println("Order added");
		return o;
	}
	
	public Order createOrder(Long ohid, Long cartid) {
		Cart cart = cartService.getCartById(cartid);
		OrderHistory oh = ohService.getOrderHistoryById(ohid);
		Order o = new Order(oh, cart);
		repo.save(o);
		System.out.println("Order added");
		return o;
	}
	
	public Order updateOrder(Order o) {
		repo.save(o);
		System.out.println("Order updated");
		return o;
	}
	
	public String deleteOrder(Long id) {
		Order o = repo.findById(id).get();
		repo.delete(o);
		System.out.println("Order deleted");
		return "Order deleted";
	}
	
	public Order getOrderById(Long id) {
		return repo.findById(id).get();
	}
	
	public List<Order> getAllOrders() {
		return repo.findAll();
	}
	
	// CUSTOM ONES	
//	public Optional<Order> getProductByTitle(String s) {
//		return repo.findByTitle(s);
//	}
//	
//	public Optional<Order> getProductByType(String s) {
//		return repo.findByType(s);
//	}
//	
//	public Optional<Order> getProductByBrand(String s) {
//		return repo.findByBrand(s);
//	}
//	
//	public Optional<Order> getProductByDescriptionContains(String s) {
//		return repo.findByDescriptionContains(s);
//	}
//	
//	public Optional<Order> getProductByPriceLessThan(double p) {
//		return repo.findByPriceLessThanEqual(p);
//	}
//	
//	public Optional<Order> getProductByPriceMoreThan(double p) {
//		return repo.findByPriceGreaterThanEqual(p);
//	}
//	
//	public Optional<Order> getProductByPriceBetween(double min, double max) {
//		return repo.findByPriceBetween(min, max);
//	}
//	
//	public Optional<Order> getProductByIsAvailable() {
//		return repo.findByIsAvailableTrue();
//	}

}
