package com.borhade.JournalApp.controller;

import com.borhade.JournalApp.entity.User;
import com.borhade.JournalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/create-user")
    public void CreateUser(@RequestBody User user ){
        userService.saveNewUser(user);
    }
}
