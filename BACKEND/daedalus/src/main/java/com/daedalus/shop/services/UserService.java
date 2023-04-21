package com.daedalus.shop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daedalus.auth.entity.User;
import com.daedalus.auth.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository repo;
	
	public User createUser(User u) {
		repo.save(u);
		System.out.println("User added");
		return u;
	}
	
	public User updateUser(User u) {
		repo.save(u);
		System.out.println("User updated");
		return u;
	}
	
	public String deleteUser(Long id) {
		User u = repo.findById(id).get();
		repo.delete(u);
		System.out.println("User deleted");
		return "User deleted";
	}
	
	public User getUserById(Long id) {
		return repo.findById(id).get();
	}
	
	public List<User> getAllUsers() {
		return repo.findAll();
	}
	
	// CUSTOM ONES
	public User getUserByUsername(String s) {
		return repo.findByUsername(s);
	}
	
	public List<User> getUserByUsernameContains(String s) {
		return repo.findByUsernameContains(s);
	}

}
