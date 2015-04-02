package com.idziak.cards.dao;

import java.io.Serializable;

public interface GenericDao<T, PK extends Serializable> {
    T create(T t);
    T get(PK id);
    T update(T t);
    void delete(T t);
}
