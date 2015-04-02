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
	public boolean createUser(User user) {
		User existing = userDao.findByNickname(user.getNickname());
		if (existing != null)
			return false;
		userDao.create(user);
		return true;
	}

	@Override
	public List<User> listUsers(int pageNr, int pageSize) {
		return userDao.list(pageNr, pageSize);
	}
}
