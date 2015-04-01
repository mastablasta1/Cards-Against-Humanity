package com.idziak.cards.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idziak.cards.model.User;
import com.idziak.cards.service.UserService;

	
@RestController
@RequestMapping("/rest/list")
public class RestListController {
	
	@Autowired
	private UserService userService;

	@RequestMapping("/users")
	public List<User> users(){
		return userService.listUsers();
	}
}
