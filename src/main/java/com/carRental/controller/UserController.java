package com.carRental.controller;

import com.carRental.entities.User;
import com.carRental.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")            //>>> Registration Page         POST = /register
public class UserController {

    @Autowired
    UserRepository userRepository;

    @PostMapping("")
    public User userRegistration (@RequestBody User user){

        return userRepository.save(user);
    }


}
