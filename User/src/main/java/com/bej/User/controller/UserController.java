/*
 * Author : Ketki Keni
 * Date : 13-02-2023
 * Created with : IntelliJ IDEA Community Edition
 */

package com.bej.User.controller;

import com.bej.User.domain.User;
import com.bej.User.exception.UserAlreadyExistsException;
import com.bej.User.exception.UserNotFoundException;
import com.bej.User.service.SecurityTokenGenerator;
import com.bej.User.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    UserService userService;
    SecurityTokenGenerator securityTokenGenerator;

    @Autowired
    public UserController(UserService userService, SecurityTokenGenerator securityTokenGenerator) {
        this.userService = userService;
        this.securityTokenGenerator = securityTokenGenerator;
    }

    //Uri : http://localhost:8082/api/v1/register
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) throws UserAlreadyExistsException {
        User newUser = userService.register(user);
        if(newUser != null) {
            return new ResponseEntity<String>("User registered successfully", HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<String>("Error Occurred", HttpStatus.NOT_FOUND);
        }
    }

    //Uri : http://localhost:8082/api/v1/login
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) throws UserNotFoundException {
        User userLogin = userService.login(user);
        if(userLogin != null) {
            return new ResponseEntity<>(securityTokenGenerator.generateToken(user), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<String>("Error Occurred", HttpStatus.NOT_FOUND);
        }
    }
}
