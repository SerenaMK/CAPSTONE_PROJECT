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

import com.daedalus.shop.models.Favorites;
import com.daedalus.shop.services.FavoritesService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/favorites")
public class FavoritesCartController {
	
	@Autowired
	FavoritesService favoritesService;
	
	@GetMapping
	public ResponseEntity<List<Favorites>> getAllFavorites() {
		return new ResponseEntity<List<Favorites>>(favoritesService.getAllFavorites(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Favorites> getFavoritesById(@PathVariable Long id) {
		return new ResponseEntity<Favorites>(favoritesService.getFavoritesById(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Favorites> createFavorites(@RequestBody Favorites faves) {
		Favorites f = favoritesService.createFavorites(faves);
		return new ResponseEntity<Favorites>(f, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Favorites> updateFavorites(@RequestBody Favorites faves) {
		return new ResponseEntity<Favorites>(favoritesService.updateFavorites(faves), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> removeFavorites(@PathVariable Long id) {
		return new ResponseEntity<String>(favoritesService.deleteFavorites(id), HttpStatus.OK);
	}
	
	// CUSTOM
//	@GetMapping("/username")
//	public ResponseEntity<List<User>> getUserByUsernameContains(@RequestParam(value="user") String username) {
//		return new ResponseEntity<List<User>>(userService.getUserByUsernameContains(username), HttpStatus.OK);
//	}

}
