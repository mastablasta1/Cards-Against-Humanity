package com.idziak.cards.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @RequestMapping(value = "/badrequest")
    public ResponseEntity badRequest(){
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}
