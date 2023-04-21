package com.daedalus.shop.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daedalus.shop.models.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {

}
