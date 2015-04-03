package com.idziak.cards.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.idziak.cards.model.User;
import com.idziak.cards.service.UserService;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(HttpServletRequest req) {
        String email = req.getParameter("email");
        String nickname = req.getParameter("nickname");
        String password = req.getParameter("password");

        User newUser = new User();
        newUser.setNickname(nickname);
        newUser.setEmail(email);
        newUser.setPassword(password);

        
        boolean userCreated;
		try {
			userCreated = userService.createUser(newUser);
		} catch (ConstraintViolationException e) {
			return "incorrect";
		}

        if (!userCreated)
            return "user_exists";

        return "registered";
    }

}
