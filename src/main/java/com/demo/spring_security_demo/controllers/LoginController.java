package com.demo.spring_security_demo.controllers;

import com.demo.spring_security_demo.models.Learner;
import com.demo.spring_security_demo.services.LearnerService;
import org.springframework.security.core.Authentication;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import com.demo.spring_security_demo.helpers.JwtUtils;
import com.demo.spring_security_demo.services.LearnerServiceImp;

import java.util.Collections;

@RestController
@RequestMapping(value = "auth")
@RequiredArgsConstructor
@CrossOrigin("*")
public class LoginController {

    @Autowired
    private LearnerServiceImp learnerService;

    @Autowired
    private AuthenticationManager authenticationManager;

    private UserDetails userDetails;

    @Autowired
    private JwtUtils jwtUtils;

    public LearnerServiceImp getLearnerService() {
        return learnerService;
    }

    @PostMapping("/learner")
    public ResponseEntity<String> loginLearner(@RequestBody Learner learner) {
        System.out.println("this is login learner");
        setAuthenticationManager(learner.getEmail(), learner.getPassword());
        System.out.println("this is login learner22");
        final Learner _user =  learnerService.findByEmail(learner.getEmail());
        final UserDetails userDetails = new org.springframework.security.core.userdetails.User(_user.getEmail(), _user.getPassword(), Collections.singleton(new SimpleGrantedAuthority("LEARNER")));
        if(_user != null){
            System.out.println("user is not null");
            return ResponseEntity.ok( "{\"token\":\""+ jwtUtils.generateToken(userDetails)+"\"}");
        }
        System.out.println("_user " +_user);
        return ResponseEntity.status(400).body("Some error has occurred");
    }

    private void setAuthenticationManager(String email, String password) {
        System.out.println("this is setAuthenticationManager");
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, password)
        );
        System.out.println("this is login learner auth");
    }
}
