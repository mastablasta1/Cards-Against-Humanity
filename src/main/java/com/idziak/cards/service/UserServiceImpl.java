package com.idziak.cards.service;

import java.util.ArrayList;
import java.util.List;

import com.idziak.cards.AlreadyExistsException;
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

    @Autowired
    private PasswordEncryptionService passwordEncryptionService;

    @Override
    public void createUser(User user) throws AlreadyExistsException {
        List<String> fields = new ArrayList<String>();
        if (userDao.emailExists(user.getEmail()))
            fields.add(User.EMAIL_COLUMN);
        if (userDao.nicknameExists(user.getNickname()))
            fields.add(User.NICKNAME_COLUMN);
        if (!fields.isEmpty())
            throw new AlreadyExistsException(fields);

        byte[] salt = passwordEncryptionService.generateSalt();
        byte[] encryptedPassword = passwordEncryptionService.getEncryptedPassword(user.getPassword(), salt);
		user.setPassword(new String(encryptedPassword));
        userDao.create(user);
    }

    @Override
    public List<User> listUsers(int pageNr, int pageSize) {
        return userDao.list(pageNr, pageSize);
    }
}
