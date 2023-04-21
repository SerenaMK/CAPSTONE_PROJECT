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

import com.daedalus.auth.entity.User;
import com.daedalus.shop.services.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers() {
		return new ResponseEntity<List<User>>(userService.getAllUsers(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Long id) {
//		System.out.println(userService.getUserById(id));
		return new ResponseEntity<User>(userService.getUserById(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User u = userService.createUser(user);
		return new ResponseEntity<User>(u, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		return new ResponseEntity<User>(userService.updateUser(user), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> removeUser(@PathVariable Long id) {
		return new ResponseEntity<String>(userService.deleteUser(id), HttpStatus.OK);
	}
	
	////////////////////// CUSTOM /////////////////////////
	
	// GET USERNAME (LOOSE)
	@GetMapping("/username")
	public ResponseEntity<List<User>> getUserByUsernameContains(@RequestParam(value="user") String username) {
		return new ResponseEntity<List<User>>(userService.getUserByUsernameContains(username), HttpStatus.OK);
	}
	
	// GET USERNAME (PRECISE)
	@GetMapping("/username-precise")
	public ResponseEntity<User> getUserByUsername(@RequestParam(value="user") String username) {
		return new ResponseEntity<User>(userService.getUserByUsername(username), HttpStatus.OK);
	}

}
