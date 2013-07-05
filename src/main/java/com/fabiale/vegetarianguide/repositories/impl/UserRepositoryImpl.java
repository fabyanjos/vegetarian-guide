package com.fabiale.vegetarianguide.repositories.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fabiale.vegetarianguide.model.User;
import com.fabiale.vegetarianguide.repositories.UserRepository;

@Repository
@Transactional(readOnly = true)
public class UserRepositoryImpl implements UserRepository {
	
	@Autowired
	private SessionFactory factory;

    @Transactional
	public Integer create(User user) {
    	Session session = factory.getCurrentSession();
    	session.save(user);
		return user.getId();
	}
    
    public User findById(Integer id) {
    	return (User) this.factory.getCurrentSession().get(User.class, id);
    }
    
    public User findByName(String name) {
    	Criteria criteria = this.factory.getCurrentSession().createCriteria(User.class);
    	criteria.add(Restrictions.eq("name", name));
    	return (User) criteria.uniqueResult();
    }
    
    public User findByLogin(String login) {
    	Criteria criteria = this.factory.getCurrentSession().createCriteria(User.class);
    	criteria.add(Restrictions.eq("login", login));
    	return (User) criteria.uniqueResult();
    }
}
