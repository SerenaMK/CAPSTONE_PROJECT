package com.daedalus.shop.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daedalus.shop.models.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
	
	Optional<Account> findByUserFirstname(String title);

}
