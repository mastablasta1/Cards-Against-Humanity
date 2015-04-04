package com.idziak.cards.dao;

import java.io.Serializable;
import java.util.List;

import com.idziak.cards.model.User;

public interface UserDao extends ListableDao<User, Long> {
	User findByNickname(String nickname);
	User findByEmail(String email);
	boolean emailExists(String email);
	boolean nicknameExists(String nickname);
}