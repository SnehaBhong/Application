package com.carRental.service;

import com.carRental.entities.User;
import com.carRental.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User byEmail = userRepository.findByEmail(email);
        UserDetails userDetails=new UserDetailsClass(byEmail);
        return userDetails;
    }


//        Optional<User> byEmail = userRepository.findByEmail(email);
//        UserDetails user = null;
//        if (user == null) {
//            throw new UsernameNotFoundException("Invalid username or password.");
//        } else {
//            return user;
//        }


    }

