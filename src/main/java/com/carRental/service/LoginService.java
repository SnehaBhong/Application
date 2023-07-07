package com.carRental.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
//@Transactional
//    public LoginResponse authenticate(LoginRequest request) {
//        User user = new User();
//
//        user.setEmail(loginRequest.getEmail());
//        user.setPassword(loginRequest.getPassword());
//
//        LoginResponse loginResponse = response(user);
//        return loginResponse;
//
//        if(authenticate(request.getEmail(), request.getPassword())){
//
//            // UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
//            UserDetails userDetails = new UserDetailsClass(customerRepository.findByEmail(request.getUsername()));
//
//
//            String token = this.jwtTokenHelper.generateToken(userDetails);
//            JwtAuthResponse jwtAuthResponse = new JwtAuthResponse();
//            jwtAuthResponse.setToken(token);
//            return new ResponseEntity<JwtAuthResponse>(jwtAuthResponse, HttpStatus.OK);
//        }
//        else{
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//        }
//    }

//    private LoginResponse response(User user) {
//     LoginResponse res = new LoginResponse();
//        res.setFname(user.getFname());
//        res.setLname(user.getLname());
//        res.setDob(user.getDob());
//        res.setEmail(user.getEmail());
//        return res;
//    }
}




