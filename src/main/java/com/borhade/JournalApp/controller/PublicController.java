package com.borhade.JournalApp.controller;

import com.borhade.JournalApp.entity.User;
import com.borhade.JournalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class PublicController {

    @Autowired
    private UserService userService;

    @GetMapping("/health-check")
    public String healthcheck() {
        return "Ok";
    }
//
//    @PostMapping("/create-user")
//    public void CreateUser(@RequestBody User user ){
//        userService.saveNewUser(user);
//    }

    @PostMapping("/create-user")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        boolean result = userService.saveNewUser(user);

        if (result) {
            return ResponseEntity.ok("User registered successfully");
        } else {
            return ResponseEntity.status(500).body("User registration failed");
        }
    }


}