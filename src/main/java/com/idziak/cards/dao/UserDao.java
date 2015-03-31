package com.idziak.cards.dao;

import java.io.Serializable;
import java.util.List;

import com.idziak.cards.model.User;

public interface UserDao {

	void create(User user);
	User get(Serializable id);
	List<User> getAll();

}