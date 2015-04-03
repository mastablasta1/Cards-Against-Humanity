package com.idziak.cards.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.idziak.cards.dao.UserDao;
import com.idziak.cards.model.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public void createUser(User user) {
		userDao.create(user);
	}

	@Override
	public List<User> listUsers(int pageNr, int pageSize) {
		return userDao.list(pageNr, pageSize);
	}
}
