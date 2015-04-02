package com.idziak.cards.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

public abstract class AbstractJpaDao<T, PK extends Serializable> implements GenericDao<T, PK> {

    private Class<T> entityClass;

    @PersistenceContext
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    public AbstractJpaDao() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass()
                .getGenericSuperclass();
        this.entityClass = (Class<T>) genericSuperclass
                .getActualTypeArguments()[0];
    }

    @Override
    public T create(T t) {
        entityManager.persist(t);
        return t;
    }

    @Override
    public T get(PK id) {
        return entityManager.find(entityClass, id);
    }

    @Override
    public T update(T t) {
        return entityManager.merge(t);
    }

    @Override
    public void delete(T t) {
        t = entityManager.merge(t);
        entityManager.remove(t);
    }

    public T findSingleByColumn(Class<T> cls, String column, Serializable value) {
        try {
            TypedQuery<T> query = getEntityManager().createNamedQuery(
                    String.format("SELECT t FROM %s t WHERE t.%s = :%s", cls.getSimpleName(), column, column),
                    cls);
            query.setParameter(column, value);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public Class<T> getEntityClass() {
        return entityClass;
    }
}
