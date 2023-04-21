package com.daedalus.shop.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daedalus.shop.models.Favorites;

public interface FavoritesRepository extends JpaRepository<Favorites, Long> {

}
