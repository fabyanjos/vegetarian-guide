package com.fabiale.vegetarianguide.repositories;

import com.fabiale.vegetarianguide.model.Network;
import com.fabiale.vegetarianguide.model.User;

public interface UserRepository {

	public Integer create(User user);
    
    public User findById(Integer id);
    
    public User findByName(String name);
    
    public User findByLogin(String login, Network network);
}
