package com.idziak.cards.controller;

import javax.persistence.PersistenceException;
import javax.validation.ConstraintViolationException;

import com.idziak.cards.exception.AlreadyExistsException;
import com.idziak.cards.model.User;
import com.idziak.cards.response.RegistrationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.idziak.cards.service.UserService;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<RegistrationResponse> registration(@RequestBody User newUser) {
        if (newUser.getEmail() == null || newUser.getEmail().isEmpty()
                || newUser.getNickname() == null || newUser.getNickname().isEmpty()
                || newUser.getPassword() == null)
            return new ResponseEntity<RegistrationResponse>(HttpStatus.BAD_REQUEST);


        try {
            userService.createUser(newUser);
        } catch (ConstraintViolationException e) {
            return new ResponseEntity<RegistrationResponse>(HttpStatus.BAD_REQUEST);
        } catch (AlreadyExistsException e) {
            RegistrationResponse resp = new RegistrationResponse();
            resp.setFields(e.getFields());
            return ResponseEntity.ok(resp);
        } catch(PersistenceException e){
            return new ResponseEntity<RegistrationResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<RegistrationResponse>(new RegistrationResponse(), HttpStatus.OK);
    }

}
