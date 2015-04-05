package com.idziak.cards.service;

import java.util.List;

import com.idziak.cards.exception.AlreadyExistsException;
import com.idziak.cards.model.User;

public interface UserService {

    void createUser(User user) throws AlreadyExistsException;

    User authenticateUser(String email, String attemptedPassword);

    List<User> listUsers(int pageNr, int pageSize);

    User getUser(Long id);
}