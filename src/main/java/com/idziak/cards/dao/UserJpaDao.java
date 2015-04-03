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
public class UserJpaDao extends AbstractJpaDao<User, Long> implements UserDao {

    @Override
    public User findByNickname(String nickname) {
        try {
            TypedQuery<User> query = getEntityManager().createNamedQuery(User.FIND_BY_NICKNAME,
                    User.class);
            query.setParameter("nickname", nickname);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public User findByEmail(String email) {
        return findSingleByColumn(User.class, "email", email);
    }

    @Override
    public List<User> list(int pageNr, int pageSize) {
        try {
            TypedQuery<User> query = getEntityManager().createQuery("select u from User u", User.class);
            query.setFirstResult((pageNr-1)*pageSize);
            query.setMaxResults(pageSize);
            return query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }
}
