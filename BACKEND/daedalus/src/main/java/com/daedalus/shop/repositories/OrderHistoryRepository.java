package com.daedalus.shop.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daedalus.shop.models.OrderHistory;

public interface OrderHistoryRepository extends JpaRepository<OrderHistory, Long> {

}
