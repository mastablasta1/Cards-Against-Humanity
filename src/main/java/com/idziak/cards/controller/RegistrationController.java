package com.idziak.cards.controller;

import javax.persistence.PersistenceException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
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


		try {
			userService.createUser(newUser);
		} catch (ConstraintViolationException e) {
            for (ConstraintViolation v : e.getConstraintViolations()) {
                if (v.getPropertyPath().toString().equals(User.EMAIL_COLUMN))
                    return "user_exists";
                else if (v.getPropertyPath().toString().equals(User.NICKNAME_COLUMN))
                    return "user_exists";
            }
            return "incorrect";
        } catch (PersistenceException e){
            if(e.getCause() instanceof org.hibernate.exception.ConstraintViolationException){
                org.hibernate.exception.ConstraintViolationException cve = (org.hibernate.exception.ConstraintViolationException) e.getCause();
                cve.getConstraintName();
                return "user_exists";
            }
            return "incorrect";
        }
        return "registered";
    }

}
