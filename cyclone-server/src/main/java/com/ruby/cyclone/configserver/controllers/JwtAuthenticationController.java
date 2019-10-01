package com.ruby.cyclone.configserver.controllers;

import com.ruby.cyclone.configserver.config.JwtTokenUtil;
import com.ruby.cyclone.configserver.config.JwtUserDetailsService;
import com.ruby.cyclone.configserver.models.security.JwtRequest;
import com.ruby.cyclone.configserver.models.security.JwtResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @Autowired
    JwtUserDetailsService jwtUserDetailsService;

    @PostMapping(value = "/api/auth")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest jwtRequest) {
        String username = jwtRequest.getUsername();
        String password = jwtRequest.getPassword();
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(username);
        String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }


}
