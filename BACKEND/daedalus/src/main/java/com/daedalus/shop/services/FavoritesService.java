package com.daedalus.shop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daedalus.shop.models.Favorites;
import com.daedalus.shop.repositories.FavoritesRepository;

@Service
public class FavoritesService {
	
	@Autowired
	FavoritesRepository repo;
	
	public Favorites createFavorites(Favorites f) {
		repo.save(f);
		System.out.println("Favorites added");
		return f;
	}
	
	public Favorites updateFavorites(Favorites f) {
		repo.save(f);
		System.out.println("Favorites updated");
		return f;
	}
	
	public String deleteFavorites(Long id) {
		Favorites f = repo.findById(id).get();
		repo.delete(f);
		System.out.println("Favorites deleted");
		return "Favorites deleted";
	}
	
	public Favorites getFavoritesById(Long id) {
		return repo.findById(id).get();
	}
	
	public List<Favorites> getAllFavorites() {
		return repo.findAll();
	}

}
