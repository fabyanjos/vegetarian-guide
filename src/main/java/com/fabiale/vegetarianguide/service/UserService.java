package com.fabiale.vegetarianguide.service;

import java.security.NoSuchAlgorithmException;

import com.fabiale.vegetarianguide.model.User;

public interface UserService {
	
	public Integer create(User user);
	
	public User findByName(String name);
	
	public User findByLogin(String login);
	
	public void authentication(User user) throws NoSuchAlgorithmException;

}
