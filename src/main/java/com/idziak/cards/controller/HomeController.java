package com.idziak.cards.controller;

import com.idziak.cards.model.User;
import com.idziak.cards.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    private static final Logger logger = LoggerFactory
            .getLogger(HomeController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(HttpServletRequest req) {
        HttpSession session = req.getSession();
        if (session.getAttribute(User.SESSION_ATTRIBUTE_NAME)!=null)
            return "forward:/board";
        return "home";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String login(HttpServletRequest req, Model model) {
        if(req.getSession().getAttribute(User.SESSION_ATTRIBUTE_NAME)!=null)
            return "forward:/board";

        String email = req.getParameter(User.EMAIL_COLUMN);
        String password = req.getParameter(User.ATTEMPTED_PASSWORD);

        if(email==null || password==null)
            return "forward:/error/badrequest";

        User user = userService.authenticateUser(email, password);
        if(user!=null){
            HttpSession newSession = req.getSession();
            newSession.setAttribute(User.SESSION_ATTRIBUTE_NAME, user);
            return "forward:/board";
        }
        model.addAttribute("login", "incorrect");
        return "home";
    }

    @RequestMapping(value = "/board", method = {RequestMethod.POST, RequestMethod.GET})
    public String board(HttpServletRequest req) {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute(User.SESSION_ATTRIBUTE_NAME);
        if(user==null)
            return "redirect:/";
        return "board";
    }

}
