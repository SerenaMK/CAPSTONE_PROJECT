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

import com.daedalus.shop.models.Account;
import com.daedalus.shop.services.AccountService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/accounts")
public class AccountController {
	
	@Autowired
	AccountService accountService;
	
	@GetMapping
	public ResponseEntity<List<Account>> getAllAccounts() {
		return new ResponseEntity<List<Account>>(accountService.getAllAccounts(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Account> getAccountById(@PathVariable Long id) {
		return new ResponseEntity<Account>(accountService.getAccountById(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Account> createAccount(@RequestBody Account account) {
		Account a = accountService.createAccount(account);
		return new ResponseEntity<Account>(a, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Account> updateAccount(@RequestBody Account account) {
		return new ResponseEntity<Account>(accountService.updateAccount(account), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> removeAccount(@PathVariable Long id) {
		return new ResponseEntity<String>(accountService.deleteAccount(id), HttpStatus.OK);
	}
	
	// CUSTOM
//	@GetMapping("/username")
//	public ResponseEntity<List<User>> getUserByUsernameContains(@RequestParam(value="user") String username) {
//		return new ResponseEntity<List<User>>(userService.getUserByUsernameContains(username), HttpStatus.OK);
//	}

}
