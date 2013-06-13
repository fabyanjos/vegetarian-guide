package com.fabiale.vegetarianguide.repositories;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fabiale.vegetarianguide.model.Image;
import com.fabiale.vegetarianguide.model.Restaurant;

@Repository
@Transactional(readOnly = true)
public class ImageRepository {
	
	@Autowired
	private SessionFactory factory;

	@SuppressWarnings("unchecked")
	public List<Image> getAll() {
		return this.factory.getCurrentSession().createCriteria(Image.class).list();
	}

    @Transactional
	public Integer create(Image image) {
    	this.factory.getCurrentSession().save(image);
		return image.getId();
	}
    
    public Image getById(Integer id) throws SQLException {
    	Image image = (Image) this.factory.getCurrentSession().get(Image.class, id);
		return image;
    }
    
    @SuppressWarnings("unchecked")
	public List<Image> getByRestaurant(Restaurant restaurant) {
    	Criteria criteria = this.factory.getCurrentSession().createCriteria(Image.class);
    	criteria.add(Restrictions.eq("restaurant", restaurant));
    	return criteria.list();
    }
    @SuppressWarnings("unchecked")
    public List<Image> getLastUptades(int quantity) {
    	Criteria criteria = this.factory.getCurrentSession().createCriteria(Image.class);
    	criteria.setMaxResults(quantity);
    	criteria.addOrder(Order.desc("created"));
    	return criteria.list();
    }
}
