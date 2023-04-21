package com.daedalus.shop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.daedalus.shop.models.Account;
import com.daedalus.shop.repositories.AccountRepository;

@Service
public class AccountService {
	
	@Autowired
	AccountRepository repo;
	
	public Account createAccount(Account a) {
		repo.save(a);
		System.out.println("Account added");
		return a;
	}
	
	public Account updateAccount(Account a) {
		repo.save(a);
		System.out.println("Account updated");
		return a;
	}
	
	public String deleteAccount(Long id) {
		Account a = repo.findById(id).get();
		repo.delete(a);
		System.out.println("Account deleted");
		return "Account deleted";
	}
	
	public Account getAccountById(Long id) {
		return repo.findById(id).get();
	}
	
//	@Transactional
	public List<Account> getAllAccounts() {
		return repo.findAll();
	}
	
	// Custom
	public Account getAccountByUserFirstname(String s) {
		return repo.findByUserFirstname(s).get();
	}
	

}
