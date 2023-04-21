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
@Table(name = "accounts")
public class Account implements Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	@JsonIgnoreProperties("account")
//	@JsonIgnore
	private User user;
	
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
	@JsonIgnoreProperties("account")
//	@JsonIgnore
	private Cart cart = new Cart();
//	private Cart cart = new Cart(this);
	
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
	@JsonIgnoreProperties("account")
//	@JsonIgnore
	private Favorites favorites = new Favorites();
//	private Favorites favorites = new Favorites(this);
	
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
	@JsonIgnoreProperties("account")
//	@JsonIgnore
	private OrderHistory orderHistory = new OrderHistory();
//	private OrderHistory orderHistory = new OrderHistory(this);
	
	// REMOVE LATER:	
//	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
//	@JsonIgnoreProperties("account")
//	@JsonIgnore
//	private List<Order> orders = new ArrayList<Order>();


	public Account(User user, Cart cart, Favorites favorites, OrderHistory orderHistory) {
		super();
		this.user = user;
		this.cart = cart;
		this.favorites = favorites;
		this.orderHistory = orderHistory;
	}
	
	public Account(User user) {
		super();
		this.user = user;
	}
	
	
	
}
