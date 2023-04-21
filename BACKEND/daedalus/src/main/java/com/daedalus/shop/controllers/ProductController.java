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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.daedalus.shop.models.Product;
import com.daedalus.shop.services.ProductService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/shop/products")
public class ProductController {

	@Autowired
	ProductService productService;

	@GetMapping
	public ResponseEntity<List<Product>> getAllProducts() {
		return new ResponseEntity<List<Product>>(productService.getAllProducts(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable Long id) {
		return new ResponseEntity<Product>(productService.getProductById(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Product> createProduct(@RequestBody Product product) {
		Product p = productService.createProduct(product);
		return new ResponseEntity<Product>(p, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
		return new ResponseEntity<Product>(productService.updateProduct(product), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> removeProduct(@PathVariable Long id) {
		return new ResponseEntity<String>(productService.deleteProduct(id), HttpStatus.OK);
	}

	// GET BY TITLE
	@GetMapping(value = "/filter", params = "title")
	public ResponseEntity<List<Product>> getProductByTitle(@RequestParam(value = "title") String title) {
		return new ResponseEntity<List<Product>>(productService.getProductByTitle(title), HttpStatus.OK);
	}
	// GET BY TYPE
	@GetMapping(value = "/filter", params = "type")
	public ResponseEntity<List<Product>> getProductByType(@RequestParam(value = "type") String type) {
		return new ResponseEntity<List<Product>>(productService.getProductByType(type), HttpStatus.OK);
	}
	// GET BY DESCRIPTION
	@GetMapping(value = "/filter", params = "description")
	public ResponseEntity<List<Product>> getProductByDescription(@RequestParam(value = "description") String desc) {
		return new ResponseEntity<List<Product>>(productService.getProductByDescriptionContains(desc), HttpStatus.OK);
	}
	// GET BY PRICE LESS THAN
	@GetMapping(value = "/filter", params = "price-less")
	public ResponseEntity<List<Product>> getProductByPriceLessThan(@RequestParam(value = "price-less") double p) {
		return new ResponseEntity<List<Product>>(productService.getProductByPriceLessThan(p), HttpStatus.OK);
	}
	// GET BY PRICE MORE THAN
	@GetMapping(value = "/filter", params = "price-more")
	public ResponseEntity<List<Product>> getProductByPriceMoreThan(@RequestParam(value = "price-more") double p) {
		return new ResponseEntity<List<Product>>(productService.getProductByPriceMoreThan(p), HttpStatus.OK);
	}
	// GET BY PRICE BETWEEN
	@GetMapping(value = "/filter", params = {"price-min", "price-max"})
	public ResponseEntity<List<Product>> getProductByPriceBetween(@RequestParam(value = "price-min") double min, @RequestParam(value = "price-max") double max) {
		return new ResponseEntity<List<Product>>(productService.getProductByPriceBetween(min, max), HttpStatus.OK);
	}
	// GET BY CATEGORY
	@GetMapping(value = "/filter", params = "category")
	public ResponseEntity<List<Product>> getProductsByCategory(@RequestParam(value = "category") String c) {
		return new ResponseEntity<List<Product>>(productService.getProductsByCategoryName(c), HttpStatus.OK);
	}

}
