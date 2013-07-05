package com.fabiale.vegetarianguide.repositories.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fabiale.vegetarianguide.model.Restaurant;
import com.fabiale.vegetarianguide.model.Review;
import com.fabiale.vegetarianguide.repositories.ReviewRepository;

@Repository
@Transactional(readOnly = true)
public class ReviewRepositoryImpl implements ReviewRepository {
	
	@Autowired
	private SessionFactory factory;

	@SuppressWarnings("unchecked")
	public List<Review> getAll() {
		return this.factory.getCurrentSession().createCriteria(Review.class).list();
	}

    @Transactional
	public Integer create(Review review) {
    	factory.getCurrentSession().save(review);
		return review.getId();
	}
    
    @SuppressWarnings("unchecked")
    public List<Review> getLastUptades(int quantity) {
    	Criteria criteria = this.factory.getCurrentSession().createCriteria(Review.class);
    	criteria.setMaxResults(quantity);
    	criteria.addOrder(Order.desc("date"));
    	return criteria.list();
    }
    
    @SuppressWarnings("unchecked")
    public List<Review> getByRestaurant(Restaurant restaurant) {
    	Criteria criteria = this.factory.getCurrentSession().createCriteria(Review.class);
    	criteria.add(Restrictions.eq("restaurant", restaurant));
    	return criteria.list();
    }
    
    public Integer getRestaurantRating(Restaurant restaurant) {
    	Criteria criteria = this.factory.getCurrentSession().createCriteria(Review.class);
    	criteria.add(Restrictions.eq("restaurant", restaurant));
    	criteria.setProjection(Projections.avg("rating"));
    	Double result = (Double) criteria.uniqueResult();
    	return result != null ? result.intValue() : null;
    }
}
