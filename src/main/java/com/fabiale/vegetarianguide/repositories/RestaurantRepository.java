package com.fabiale.vegetarianguide.repositories;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fabiale.vegetarianguide.model.Restaurant;

@Repository
public class RestaurantRepository {
	
	@Autowired
	private SessionFactory factory;

	@SuppressWarnings("unchecked")
	public List<Restaurant> getAll() {
		return this.factory.openSession().createCriteria(Restaurant.class).list();
	}

    @Transactional
	public Integer create(Restaurant restaurant) {
		this.factory.openSession().save(restaurant);
		return restaurant.getId();
	}
    
    public Restaurant getById(Integer id) {
    	return (Restaurant) this.factory.openSession().get(Restaurant.class, id);
    }
}
