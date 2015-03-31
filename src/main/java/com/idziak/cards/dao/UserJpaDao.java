package com.idziak.cards.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.idziak.cards.model.User;

@Repository
public class UserJpaDao implements UserDao{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void create(User user){
		entityManager.persist(user);
	}
	
	@Override
	public User get(Serializable id){
		return entityManager.find(User.class, id);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAll(){
		return entityManager.createQuery("from User").getResultList();
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
}
