/*
 * Author : Ketki Keni
 * Date : 14-02-2023
 * Created with : IntelliJ IDEA Community Edition
 */

package com.bej.User.controller;

import com.bej.User.domain.User;
import com.bej.User.exception.UserNotFoundException;
import com.bej.User.service.SecurityTokenGenerator;
import com.bej.User.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2")
public class UserControllerV2 {
    UserService userService;
    SecurityTokenGenerator securityTokenGenerator;
    @Autowired
    public UserControllerV2(UserService userService, SecurityTokenGenerator securityTokenGenerator) {
        this.userService = userService;
        this.securityTokenGenerator = securityTokenGenerator;
    }

    @GetMapping("/Users")
    public ResponseEntity<?> getAllUsers(){
        List<User> allUsers = userService.getAllUsers();
        if(allUsers.size()>0){
            return new ResponseEntity<List<User>>(allUsers, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<String>("No Users Found",HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/user/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable int userId) throws UserNotFoundException {
        if(userService.deleteUser(userId)){
            return new ResponseEntity<String>("User deleted", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<String>("Error Occurred", HttpStatus.NOT_FOUND);
        }
    }
}
