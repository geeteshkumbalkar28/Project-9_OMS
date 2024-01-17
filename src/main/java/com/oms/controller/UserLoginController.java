package com.oms.controller;

import com.oms.Entity.EmailVerification;
import com.oms.exceptions.InvalidCredentialsException;
import com.oms.exceptions.UserDisabledException;
import com.oms.payloads.JwtAuthRequest;
import com.oms.payloads.JwtAuthResponse;
import com.oms.security.JwtTokenHelper;
import com.oms.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserLoginController {


    @Autowired
    private JwtTokenHelper jwtTokenHelper;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;


    // generate token
    @PostMapping("/login")
    public ResponseEntity<JwtAuthResponse> generateToken(@RequestBody JwtAuthRequest jwtRequest) throws Exception {

        try {
            try {
                this.authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());
            } catch (UsernameNotFoundException e) {
                throw new Exception("User not found");
            } catch (InvalidCredentialsException e) {
                throw new InvalidCredentialsException("Invalid credentials");
            }
            // authentication done
            UserDetails userDetails = this.customUserDetailsService.loadUserByUsername(jwtRequest.getUsername());
            String token = this.jwtTokenHelper.generateToken(userDetails);
            return ResponseEntity.ok(new JwtAuthResponse(token, "success"));
        } catch (Exception e) {
            return ResponseEntity.ok(new JwtAuthResponse("null", "Invalid credentials"));
        }
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (UserDisabledException e) {
            throw new UserDisabledException("User Disabled");
        } catch (InvalidCredentialsException e) {
            throw new InvalidCredentialsException("Invalid credentials");
        }

    }

}
