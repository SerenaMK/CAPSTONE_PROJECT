package com.daedalus.shop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daedalus.shop.models.Cart;
import com.daedalus.shop.repositories.CartRepository;

@Service
public class CartService {
	
	@Autowired
	CartRepository repo;
	
	public Cart createCart(Cart c) {
		repo.save(c);
		System.out.println("Cart added");
		return c;
	}
	
	public Cart updateCart(Cart c) {
		repo.save(c);
		System.out.println("Cart updated");
		return c;
	}
	
	public String deleteCart(Long id) {
		Cart c = repo.findById(id).get();
		repo.delete(c);
		System.out.println("Cart deleted");
		return "Cart deleted";
	}
	
	public Cart getCartById(Long id) {
		return repo.findById(id).get();
	}
	
	public List<Cart> getAllCarts() {
		return repo.findAll();
	}
	
	// CUSTOM
//	public Cart addProduct(Cart c, Product p) {
//		Cart cart = repo.findById(c.getId()).get();
//		cart.setProducts(null);
//		
//		return repo.findById(id).get();
//	}

}
