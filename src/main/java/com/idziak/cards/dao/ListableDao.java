package com.idziak.cards.dao;

import java.io.Serializable;
import java.util.List;

public interface ListableDao<T, PK extends Serializable> extends GenericDao<T, PK>{
    List<T> list(int pageNr, int pageSize);
}
