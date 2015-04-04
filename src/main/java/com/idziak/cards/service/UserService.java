package com.idziak.cards.service;

import java.util.List;

import com.idziak.cards.AlreadyExistsException;
import com.idziak.cards.model.User;

public interface UserService {

	void createUser(User user) throws AlreadyExistsException;
	List<User> listUsers(int pageNr, int pageSize);
}