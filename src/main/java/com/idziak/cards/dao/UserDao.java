package com.idziak.cards.dao;

import com.idziak.cards.model.User;

public interface UserDao extends ListableDao<User, Long> {
	User findByNickname(String nickname);
	User findByEmail(String email);
	boolean emailExists(String email);
	boolean nicknameExists(String nickname);
}