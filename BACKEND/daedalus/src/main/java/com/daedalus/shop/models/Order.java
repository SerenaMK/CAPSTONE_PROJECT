package com.daedalus.shop.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.daedalus.auth.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "orders")
public class Order implements Serializable {
	
	// MANY TO MANY with OrderHistory
	// MANY TO MANY with Product
	// MANY TO ONE with Account
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
//	@ManyToMany(cascade = {CascadeType.PERSIST})
	@ManyToMany
	private List<Product> products = new ArrayList<Product>();
	
	@ManyToOne
	@JsonIgnoreProperties({"orders"})
	private OrderHistory orderHistory;
	
//	@ManyToMany
//	@ToString.Exclude
//	@JsonIgnore
//	private List<OrderHistory> orderHistories = new ArrayList<OrderHistory>();
	
	public Order(OrderHistory oh, Cart cart) {
		super();
		List<Product> p = new ArrayList<Product>(cart.getProducts());
		oh.getOrders().add(this);
		this.orderHistory = oh;
		this.products = p;
	}

	


}
