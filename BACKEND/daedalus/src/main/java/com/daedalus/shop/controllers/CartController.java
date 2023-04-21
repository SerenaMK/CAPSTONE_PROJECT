package com.daedalus.shop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daedalus.shop.models.Cart;
import com.daedalus.shop.services.CartService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/carts")
public class CartController {
	
	@Autowired
	CartService cartService;
	
	@GetMapping
	public ResponseEntity<List<Cart>> getAllCarts() {
		return new ResponseEntity<List<Cart>>(cartService.getAllCarts(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cart> getCartById(@PathVariable Long id) {
		return new ResponseEntity<Cart>(cartService.getCartById(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Cart> createCart(@RequestBody Cart cart) {
		Cart c = cartService.createCart(cart);
		return new ResponseEntity<Cart>(c, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Cart> updateCart(@RequestBody Cart cart) {
		return new ResponseEntity<Cart>(cartService.updateCart(cart), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> removeCart(@PathVariable Long id) {
		return new ResponseEntity<String>(cartService.deleteCart(id), HttpStatus.OK);
	}
	
	// CUSTOM
//	@GetMapping("/username")
//	public ResponseEntity<List<User>> getUserByUsernameContains(@RequestParam(value="user") String username) {
//		return new ResponseEntity<List<User>>(userService.getUserByUsernameContains(username), HttpStatus.OK);
//	}

}
