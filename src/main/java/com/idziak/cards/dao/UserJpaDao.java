package com.idziak.cards.dao;

import java.util.List;

import com.idziak.cards.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserJpaDao extends AbstractJpaDao<User, Long> implements UserDao {

    @Override
    public User findByNickname(String nickname) {
        return findSingleByColumn(User.NICKNAME_COLUMN, nickname);
    }

    @Override
    public User findByEmail(String email) {
        return findSingleByColumn(User.EMAIL_COLUMN, email);
    }

    @Override
    public List<User> list(int pageNr, int pageSize) {
        return super.list(pageNr, pageSize);
    }

    @Override
    public boolean emailExists(String email) {
        return exists(User.EMAIL_COLUMN, email);
    }

    @Override
    public boolean nicknameExists(String nickname) {
        return exists(User.NICKNAME_COLUMN, nickname);
    }
}
