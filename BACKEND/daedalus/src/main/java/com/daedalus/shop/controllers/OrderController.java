package com.daedalus.shop.controllers;

import java.util.List;

import org.apache.catalina.mapper.Mapper;
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
import com.daedalus.shop.models.Order;
import com.daedalus.shop.models.OrderHistory;
import com.daedalus.shop.services.CartService;
import com.daedalus.shop.services.OrderHistoryService;
import com.daedalus.shop.services.OrderService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor // <--- così non mi servono gli autowired, basta usare final
public class OrderController {

	final OrderService orderService;
	final OrderHistoryService ohService;
	final CartService cartService;
	
	@GetMapping
	public ResponseEntity<List<Order>> getAllOrders() {
		return new ResponseEntity<List<Order>>(orderService.getAllOrders(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
		return new ResponseEntity<Order>(orderService.getOrderById(id), HttpStatus.OK);
	}
	
	@PostMapping("/{ohid}/{cartid}")
	public ResponseEntity<Order> createOrder(@PathVariable Long ohid, @PathVariable Long cartid) {
		Order o = orderService.createOrder(ohid, cartid);
		return new ResponseEntity<Order>(o, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Order> updateOrder(@RequestBody Order order) {
		return new ResponseEntity<Order>(orderService.updateOrder(order), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> removeOrder(@PathVariable Long id) {
		return new ResponseEntity<String>(orderService.deleteOrder(id), HttpStatus.OK);
	}

}
