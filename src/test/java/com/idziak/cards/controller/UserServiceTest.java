package com.idziak.cards.controller;


import com.idziak.cards.exception.AlreadyExistsException;
import com.idziak.cards.model.User;
import com.idziak.cards.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/test-context.xml"})
public class UserServiceTest {

    @Autowired
    private UserService userService;

    public static final Logger LOG = Logger.getLogger(UserServiceTest.class.getName());

    @Test
    public void createUserTest() {
        User user = new User();
        user.setEmail("testing@email.com");
        user.setNickname("tester");
        user.setPassword("testpassword");

        try {
            userService.createUser(user);
            User savedUser = userService.getUser(user.getId());
            assertEquals(user.getPassword(), savedUser.getPassword());
        } catch (AlreadyExistsException e) {
            fail();
        }
    }
}