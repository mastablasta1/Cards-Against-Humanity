package com.idziak.cards.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ListController {

	@RequestMapping("/admin/listusers")
	public String listUsers() {
		return "admin/listusers";
	}
}
