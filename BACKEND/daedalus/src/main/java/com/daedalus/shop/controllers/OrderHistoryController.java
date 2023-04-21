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

import com.daedalus.shop.models.OrderHistory;
import com.daedalus.shop.services.OrderHistoryService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/order-histories")
public class OrderHistoryController {
	
	@Autowired
	OrderHistoryService orderHistoryService;
	
	@GetMapping
	public ResponseEntity<List<OrderHistory>> getAllOrderHistories() {
		return new ResponseEntity<List<OrderHistory>>(orderHistoryService.getAllOrderHistories(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<OrderHistory> getOrderHistoryById(@PathVariable Long id) {
		return new ResponseEntity<OrderHistory>(orderHistoryService.getOrderHistoryById(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<OrderHistory> createOrderHistory(@RequestBody OrderHistory oh) {
		OrderHistory o = orderHistoryService.createOrderHistory(oh);
		return new ResponseEntity<OrderHistory>(o, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<OrderHistory> updateOrderHistory(@RequestBody OrderHistory oh) {
		return new ResponseEntity<OrderHistory>(orderHistoryService.updateOrderHistory(oh), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> removeOrderHistory(@PathVariable Long id) {
		return new ResponseEntity<String>(orderHistoryService.deleteOrderHistory(id), HttpStatus.OK);
	}
	
	// CUSTOM
//	@GetMapping("/username")
//	public ResponseEntity<List<User>> getUserByUsernameContains(@RequestParam(value="user") String username) {
//		return new ResponseEntity<List<User>>(userService.getUserByUsernameContains(username), HttpStatus.OK);
//	}

}
