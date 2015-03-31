package com.idziak.cards.service;

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
	public void createUser(User user){
		userDao.create(user);
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
}
