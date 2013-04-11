package com.fabiale.vegetarianguide.repositories;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fabiale.vegetarianguide.model.Country;

@Repository
@Transactional(readOnly = true)
public class CountryRepository {
	
	@Autowired
	private SessionFactory factory;

	@SuppressWarnings("unchecked")
	public List<Country> getAll() {
		return this.factory.getCurrentSession().createCriteria(Country.class).list();
	}

    @Transactional
	public Integer create(Country country) {
    	Session session = factory.getCurrentSession();
    	session.save(country);
		return country.getId();
	}
    
    public Country findById(Integer id) {
    	return (Country) this.factory.getCurrentSession().get(Country.class, id);
    }
    
    public Country findByName(String name) {
    	Criteria criteria = this.factory.getCurrentSession().createCriteria(Country.class);
    	criteria.add(Restrictions.eq("name", name));
    	return (Country) criteria.uniqueResult();
    }
}
