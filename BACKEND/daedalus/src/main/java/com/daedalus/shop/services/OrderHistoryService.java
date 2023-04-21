package com.daedalus.shop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daedalus.shop.models.OrderHistory;
import com.daedalus.shop.repositories.OrderHistoryRepository;

@Service
public class OrderHistoryService {
	
	@Autowired
	OrderHistoryRepository repo;
	
	public OrderHistory createOrderHistory(OrderHistory oh) {
		repo.save(oh);
		System.out.println("OrderHistory added");
		return oh;
	}
	
	public OrderHistory updateOrderHistory(OrderHistory oh) {
		repo.save(oh);
		System.out.println("OrderHistory updated");
		return oh;
	}
	
	public String deleteOrderHistory(Long id) {
		OrderHistory oh = repo.findById(id).get();
		repo.delete(oh);
		System.out.println("OrderHistory deleted");
		return "OrderHistory deleted";
	}
	
	public OrderHistory getOrderHistoryById(Long id) {
		return repo.findById(id).get();
	}
	
	public List<OrderHistory> getAllOrderHistories() {
		return repo.findAll();
	}

}
