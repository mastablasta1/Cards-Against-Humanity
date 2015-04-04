package com.idziak.cards.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/error")
public class ErrorController {

    @RequestMapping(value = "/notfound")
    public String notFound(){
        return "error/notfound";
    }

    @RequestMapping(value = "/servererror")
    public String internalServerError(){
        return "error/servererror";
    }
}
