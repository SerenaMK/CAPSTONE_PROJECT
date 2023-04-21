package com.daedalus.shop.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
@Table(name = "carts")
public class Cart implements Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
//	@ManyToMany(mappedBy = "carts", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@ManyToMany(cascade = {CascadeType.PERSIST})
	private List<Product> products = new ArrayList<Product>();
	
	@OneToOne
	@JsonIgnore
	private Account account;
	
	public void addProduct(Product product) {
		this.products.add(product);
//		product.getCarts().add(this);
	}
	
	public void removeProduct(Product product) {
		this.getProducts().remove(product);
	}

	public Cart(Account account) {
		super();
		this.account = account;
	}
	
	

}
