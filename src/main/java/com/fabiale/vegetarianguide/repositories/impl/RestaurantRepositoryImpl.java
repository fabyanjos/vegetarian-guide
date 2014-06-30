package com.fabiale.vegetarianguide.repositories.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fabiale.vegetarianguide.model.Restaurant;
import com.fabiale.vegetarianguide.repositories.RestaurantRepository;

@Repository
@Transactional(readOnly = true)
public class RestaurantRepositoryImpl implements RestaurantRepository {
	
	@Autowired
	private SessionFactory factory;

	@SuppressWarnings("unchecked")
	public List<Restaurant> getAll() {
		return this.factory.getCurrentSession().createCriteria(Restaurant.class).list();
	}

    @Transactional
	public Integer create(Restaurant restaurant) {
    	Session session = factory.getCurrentSession();
    	session.save(restaurant);
		return restaurant.getId();
	}
    
    public Restaurant getById(Integer id) {
    	Restaurant restaurant = (Restaurant) this.factory.getCurrentSession().get(Restaurant.class, id);
		return restaurant;
    }
    
    public Restaurant getByName(String name) {
    	Criteria criteria = this.factory.getCurrentSession().createCriteria(Restaurant.class);
    	criteria.add(Restrictions.eq("name", name).ignoreCase());
    	return (Restaurant) criteria.uniqueResult();
    }
    
    @SuppressWarnings("unchecked")
    public List<Restaurant> getNearBy(Double latMin, Double lngMin, Double latMax, Double lngMax) {
    	Criteria criteria = this.factory.getCurrentSession().createCriteria(Restaurant.class);
    	criteria.add(Restrictions.between("latitude", latMin, latMax));
    	criteria.add(Restrictions.between("longitude", lngMin, lngMax));
    	
    	return criteria.list();
    }
    
    @SuppressWarnings("unchecked")
    public List<Restaurant> getLastUptades(int quantity) {
    	Criteria criteria = this.factory.getCurrentSession().createCriteria(Restaurant.class);
    	criteria.setMaxResults(quantity);
    	criteria.addOrder(Order.desc("createdAt"));
    	return criteria.list();
    }
}
