package com.fabiale.vegetarianguide.repositories;

import java.util.List;

import org.hibernate.SessionFactory;
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
		this.factory.openSession().save(country);
		return country.getId();
	}
    
    public Country getById(Integer id) {
    	return (Country) this.factory.openSession().get(Country.class, id);
    }
}
