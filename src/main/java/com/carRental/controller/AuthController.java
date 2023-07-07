package com.carRental.controller;

import com.carRental.dto.JwtRequest;
import com.carRental.dto.JwtResponse;
import com.carRental.helper.JwtUtil;
import com.carRental.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class AuthController {
    @Autowired
    HttpSession session;

        @Autowired
        private AuthenticationManager authenticationManager;
        @Autowired
        private CustomUserDetailsService customUserDetailsService;
        @Autowired
        private JwtUtil jwtUtil;

        @PostMapping( "/userlogin")
        public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest, HttpSession session) throws Exception {
            System.out.println(jwtRequest);

            try {
                this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getEmail(), jwtRequest.getPassword()));
                session.setAttribute("UserEmail",jwtRequest.getEmail());

            } catch (UsernameNotFoundException e) {
                e.printStackTrace();
                throw new Exception("Invalid Credentials!");

            }catch (BadCredentialsException e){
                e.printStackTrace();
                throw new Exception("Invalid Credentials!");
            }

            //fine area..
            UserDetails userDetails = this.customUserDetailsService.loadUserByUsername(jwtRequest.getEmail());

            String token = this.jwtUtil.generateToken(userDetails);
            System.out.println("JWT "+token);

            //{"token":"value}
            return ResponseEntity.ok(new JwtResponse(token));
        }

    }



