package com.fabiale.vegetarianguide.repositories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
    	Session session = factory.openSession();
    	Transaction tx = session.beginTransaction();
    	session.save(restaurant);
    	tx.commit();
		return restaurant.getId();
	}
    
    public Restaurant getById(Integer id) {
    	return (Restaurant) this.factory.openSession().get(Restaurant.class, id);
    }
}
