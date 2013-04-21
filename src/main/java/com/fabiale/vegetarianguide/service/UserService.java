package com.fabiale.vegetarianguide.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabiale.vegetarianguide.model.User;
import com.fabiale.vegetarianguide.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;

	public List<User> getAll() {
		return this.repository.getAll();
	}

	public Integer create(User user) {
		return this.repository.create(user);
	}
	
	public User findByName(String name) {
		return this.repository.findByName(name);
	}
	
	public User findByLogin(String login) {
		return this.repository.findByLogin(login);
	}
}
