package com.idziak.cards.controller;

import javax.servlet.http.HttpServletRequest;

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

		if (email == null || nickname == null || password == null) {
			return "incorrect";
		}

		User newUser = new User();
		newUser.setNickname(nickname);

		boolean userCreated = userService.createUser(newUser);

		if (!userCreated)
			return "user_exists";

		return "registered";
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
