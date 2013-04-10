package com.fabiale.vegetarianguide.repositories;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fabiale.vegetarianguide.model.Country;

@Repository
public class CountryRepository {
	
	@Autowired
	private SessionFactory factory;

	@SuppressWarnings("unchecked")
	public List<Country> getAll() {
		return this.factory.openSession().createCriteria(Country.class).list();
	}

    @Transactional
	public Integer create(Country country) {
    	Session session = factory.openSession();
    	Transaction tx = session.beginTransaction();
    	session.save(country);
    	tx.commit();
		return country.getId();
	}
    
    public Country findById(Integer id) {
    	return (Country) this.factory.openSession().get(Country.class, id);
    }
    
    public Country findByName(String name) {
    	Criteria criteria = this.factory.openSession().createCriteria(Country.class);
    	criteria.add(Restrictions.eq("name", name));
    	return (Country) criteria.uniqueResult();
    }
}
