package com.fabiale.vegetarianguide.repositories;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fabiale.vegetarianguide.model.Restaurant;

@Repository
@Transactional(readOnly = true)
public class RestaurantRepository {
	
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
    	Hibernate.initialize(restaurant.getReviews());
		return restaurant;
    }
    
    @SuppressWarnings("unchecked")
    public List<Restaurant> getNearBy(Double latMin, Double lngMin, Double latMax, Double lngMax) {
    	Criteria criteria = this.factory.getCurrentSession().createCriteria(Restaurant.class);
    	criteria.add(Restrictions.between("latitude", latMin, latMax));
    	criteria.add(Restrictions.between("longitude", lngMin, lngMax));
    	
    	return criteria.list();
    }
}
