package com.idziak.cards.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.idziak.cards.model.User;

@Repository
public class UserJpaDao implements UserDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void create(User user) {
		em.persist(user);
	}

	@Override
	public User get(Serializable id) {
		return em.find(User.class, id);
	}

	@Override
	public User findByNickname(String nickname) {
		try {
			TypedQuery<User> query = em.createNamedQuery(User.FIND_BY_NICKNAME,
					User.class);
			query.setParameter("nickname", nickname);
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAll() {
		return em.createQuery("SELECT u FROM User u").getResultList();
	}

	public void setEntityManager(EntityManager entityManager) {
		this.em = entityManager;
	}

}
