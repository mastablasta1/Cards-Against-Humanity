package com.idziak.cards.controller.admin;


import com.idziak.cards.SessionEventsListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @RequestMapping("/listusers")
    public String listUsers() {
        return "admin/listusers";
    }

    @RequestMapping("/reset")
    @ResponseBody
    public String resetSessions(){
        SessionEventsListener.removeAllSessions();
        return "Sessions reset";
    }
}
