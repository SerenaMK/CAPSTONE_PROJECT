package com.daedalus.shop.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
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
@Table(name = "order_history")
public class OrderHistory implements Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
//	@ManyToMany(cascade = {CascadeType.PERSIST})
//	private List<Order> orders = new ArrayList<Order>();
	
	@OneToOne
	@JsonIgnore
	private Account account;
	
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	@JsonIgnoreProperties("orderHistory")
	private List<Order> orders = new ArrayList<Order>();
	
	public void addOrder(Order order) {
//		this.orders.add(order);
		this.getOrders().add(order);
	}
	
	public void removeOrder(Order order) {
		this.getOrders().remove(order);
	}

	public OrderHistory(Account account) {
		super();
		this.account = account;
	}

}
