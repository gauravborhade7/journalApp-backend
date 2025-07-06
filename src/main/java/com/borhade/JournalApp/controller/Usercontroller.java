package com.borhade.JournalApp.controller;

import com.borhade.JournalApp.entity.User;
import com.borhade.JournalApp.repository.UserRepository;
import com.borhade.JournalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class Usercontroller {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;



    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody User user , @PathVariable String userName) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User userInDb = userService.findByUserName(username);
//        if (userInDb != null) {
            userInDb.setUserName((user.getUserName()));
            userInDb.setPassword((user.getPassword()));
            userService.saveNewUser(userInDb);
//        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/user")
    public ResponseEntity<?> deleteUserById(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        userRepository.deleteByUserName(authentication.getName());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
