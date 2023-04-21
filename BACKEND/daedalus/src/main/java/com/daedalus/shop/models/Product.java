package com.daedalus.shop.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
@Table(name = "products")
public class Product implements Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String title;
	@Column(nullable = false)
	private String type;
	private String brand;
	@Column(nullable = false)
	private String image;
	@Column(nullable = false)
	private double price;
	private String description;
	@Column(nullable = false)
	private boolean isAvailable;
	
	@ManyToMany(cascade = {CascadeType.PERSIST})
	private List<Category> categories = new ArrayList<Category>();
	
//	@ManyToMany
//	@ToString.Exclude
//	@JsonIgnore
//	private List<Cart> carts = new ArrayList<Cart>();
	
//	@ManyToMany
//	@ToString.Exclude
//	@JsonIgnore
//	private List<Order> orders = new ArrayList<Order>();
	
//	@ManyToMany
//	@ToString.Exclude
//	@JsonIgnore
//	private List<Favorites> favorites = new ArrayList<Favorites>();
	
	public Product(String title, String type, String brand, String image, double price, String description,
			boolean isAvailable) {
		super();
		this.title = title;
		this.type = type;
		this.brand = brand;
		this.image = image;
		this.price = price;
		this.description = description;
		this.isAvailable = isAvailable;
	}
	
	public void addCategory(Category c) {
		this.getCategories().add(c);
	}
	
	public void removeCategory(Category c) {
		this.getCategories().remove(c);
	}
	
	
}
