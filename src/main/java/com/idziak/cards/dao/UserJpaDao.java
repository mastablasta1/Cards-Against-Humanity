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
        return findSingleByColumn(User.NICKNAME_COLUMN, nickname);
    }

    @Override
    public User findByEmail(String email) {
        return findSingleByColumn(User.EMAIL_COLUMN, email);
    }

    @Override
    public List<User> list(int pageNr, int pageSize) {
        return super.list(pageNr, pageSize);
    }
}
